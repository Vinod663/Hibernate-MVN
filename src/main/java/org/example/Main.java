package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Customer;
import org.example.entity.CustomerFullName;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    private static FactoryConfiguration factory;

    public static void main(String[] args) {
        factory=FactoryConfiguration.getInstance();

        /*CustomerFullName customerFullName=new CustomerFullName("Vinod","Niloshana");
        Customer customer=new Customer(
                2,
                customerFullName,
                "vinod@gmail.com",
                "1234",
                "0778193985",
                "Google's service, offered free of charge, instantly translates words," +
                        " phrases, and web pages between English and over 100 other languages.");
        saveCustomer(customer);*/

        CustomerFullName customerFullName1=new CustomerFullName("Praneeth","Sudinu");
        Customer customer1=new Customer(
                1,
                customerFullName1,
                "praneeth@gmail.com",
                "6858",
                "0771711117",
                "Google's service, offered free of charge, instantly translates words," +
                        " phrases, and web pages between English and over 100 other languages.");
        saveCustomer(customer1);


    }



    public static boolean saveCustomer(Customer customer){
        Session session=factory.getSession();
        try {
            Transaction transaction=session.beginTransaction();
            session.save(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if(session!=null){
                session.close();
            }
        }
    }
}