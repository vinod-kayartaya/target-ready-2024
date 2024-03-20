package com.targetindia.programs;

import com.targetindia.entity.Product;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import com.targetindia.utils.Printer;

public class GetProductAndCorrespondingCategory {
    public static void main(String[] args) {
        var id = KeyboardUtil.getInt("enter product id to search: ");

        Product p = null;

        try (var em = JpaUtil.createEntityManager()) {
            p = em.find(Product.class, id);
        } // em.close() called here; db connection is lost

        if (p == null) {
            System.out.println("no data found for product id " + id);
            return;
        }

        Printer.print(p, "category", "supplier");
        Printer.print(p.getCategory(), "products");
        Printer.print(p.getSupplier(), "products");
    }
}
