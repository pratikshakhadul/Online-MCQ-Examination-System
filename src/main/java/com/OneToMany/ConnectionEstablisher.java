package com.OneToMany;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionEstablisher {

    private static SessionFactory factory;

    static {
        factory = new Configuration()
                .configure("hibernate-cnf.xml")
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Doctor.class)
                .buildSessionFactory();
    }

    public static SessionFactory getConnection() {
        return factory;
    }
}