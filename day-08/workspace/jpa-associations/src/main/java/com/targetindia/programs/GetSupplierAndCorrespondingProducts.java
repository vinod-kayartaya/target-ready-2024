package com.targetindia.programs;

import com.targetindia.entity.Supplier;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import com.targetindia.utils.Printer;

public class GetSupplierAndCorrespondingProducts {
    public static void main(String[] args) {

        var id = KeyboardUtil.getInt("enter supplier id to search: ");
        Supplier sup=null;
        try(var em = JpaUtil.createEntityManager()){
             sup = em.find(Supplier.class, id);

        } // em.close() called --> db connection is closed

        // sup now is a detached object
        if(sup==null){
            System.out.println("no data found for supplier id " + id);
            return;
        }

        Printer.print(sup, "products");
        System.out.println("products supplied by this supplier: ");

        // re-attach the object `sup` with a new entity manager
        try(var em = JpaUtil.createEntityManager()){
            sup = em.merge(sup); // now `sup` is a managed object
            sup.getProducts() // uses the new entity manager to get the data from db
                    .stream()
                    .map(p->p.getProductName())
                    .forEach(System.out::println);
        }
    }
}
