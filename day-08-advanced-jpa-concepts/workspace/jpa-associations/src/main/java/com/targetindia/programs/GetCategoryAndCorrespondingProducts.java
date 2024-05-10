package com.targetindia.programs;

import com.targetindia.entity.Category;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import com.targetindia.utils.Printer;

public class GetCategoryAndCorrespondingProducts {
    public static void main(String[] args) {
        var id = KeyboardUtil.getInt("enter category id to search: ");
        Category cat = null;
        try (var em = JpaUtil.createEntityManager()) {
            cat = em.find(Category.class, id);

            if(cat==null){
                System.out.println("no category found for id " + id);
                return;
            }
        } // em.close() is called; DB connection is closed

        Printer.print(cat, "products");

        System.out.println("products that belong to this category are: ");
        cat.getProducts() // this is when the query for getting products will be fired
                .stream()
                .map(p->p.getProductName())
                .forEach(System.out::println);


    }
}
