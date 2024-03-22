package com.targetindia.programs;

import com.targetindia.entity.Product;
import com.targetindia.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JpqlDemo {
    static private EntityManager em;

    public static void main(String[] args) {
        em = JpaUtil.createEntityManager();

        // displayAllShippers();
        // displayProductsBetweenPrice(0.0, 10.0);
        // displayProductAndSupplierNames();
        // displayCategoryAndStockValue();
        // displayCategoryWiseStockValue();
        // displayPaginatedProductsData(7);
        displayOrderTotal(10250);
        em.close();
    }

    static void displayOrderTotal(int orderId) {
        var sql = "SELECT SUM(UNIT_PRICE*QUANTITY*(1-DISCOUNT)) FROM ORDER_DETAILS WHERE ORDER_ID=:ORDER_ID";
        var qry = em.createNativeQuery(sql);
        qry.setParameter("ORDER_ID", orderId);
        var orderTotal = qry.getSingleResult();
        System.out.printf("order total amount for order id %d is $%.2f\n", orderId, orderTotal);

    }

    static void displayPaginatedProductsData(int pageNum) {
        var jpql = "from Product";
        var pageSize = 10;
        var offset = (pageNum - 1) * pageSize;
        em.createQuery(jpql, Product.class)
                .setMaxResults(pageSize)
                .setFirstResult(offset)
                .getResultStream()
                .forEach(p -> System.out.printf("%d -> %s\n", p.getProductId(), p.getProductName()));
    }

    static void displayCategoryWiseStockValue() {
        em.createNamedQuery("Category.categoryWiseStockValue", Object[].class)
                .setParameter("VALUE", 12000)
                .getResultStream()
                .forEach(ar -> System.out.printf("%s --> %.2f\n", ar[0], ar[1]));
    }

    static void displayCategoryAndStockValue() {
        var jpql = "select c.categoryName, sum(p.unitPrice * p.unitsInStock) from Category c" +
                " join c.products as p group by c.categoryName having sum(p.unitPrice * p.unitsInStock) < 10000";
        var qry = em.createQuery(jpql, Object[].class);
        qry.getResultStream().forEach(ar -> System.out.printf("%s --> %.2f\n", ar[0], ar[1]));
    }

    static void displayProductAndSupplierNames() {
        // var jpql = "select p.productName, s.companyName from Product p join p.supplier as s";
        var jpql = "select p.productName, p.supplier.companyName from Product p";
        var qry = em.createQuery(jpql, Object[].class);
        qry.getResultStream() // stream of Object[] with 2 elements --> p.productName, s.companyName
                .forEach(ar -> System.out.printf("%s --> %s\n", ar[0], ar[1]));

    }

    static void displayProductsBetweenPrice(double min, double max) {
//        var jpql = "from Product where unitPrice between ?1 and ?2";
        var jpql = "from Product where unitPrice between :MIN and :MAX order by unitPrice asc";
        TypedQuery<Product> qry = em.createQuery(jpql, Product.class);
//        qry.setParameter(1, min);
//        qry.setParameter(2, max);
        qry.setParameter("MIN", min);
        qry.setParameter("MAX", max);

        List<Product> list = qry.getResultList();
        list.stream().forEach(JpqlDemo::printProductNameAndPrice);
    }

    static void printProductNameAndPrice(Product p) {
        System.out.println(p.getProductName() + " --> $" + p.getUnitPrice());
    }

    static void displayAllShippers() {
        // sql --> select * from shippers;
        // var jpql = "select s from com.targetindia.entity.Shipper s order by s.companyName";
        var jpql = "from Shipper s order by s.companyName";
        Query qry = em.createQuery(jpql);
        List list = qry.getResultList();
        list.forEach(System.out::println);
    }
}
