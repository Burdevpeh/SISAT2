package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
    
  private static StandardServiceRegistry registry; 
  private static SessionFactory sessionFactory;
//   private static final ThreadLocal<Session> threadLocal = new ThreadLocal();

  
  
  public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
        }

        return sessionFactory;
    }

    public static StandardServiceRegistry getRegistry() {
        return registry;
    }

    public static void setRegistry(StandardServiceRegistry registry) {
        HibernateUtil.registry = registry;
    }
    
//     public static void closeSession() throws HibernateException {
//    Session session = (Session) threadLocal.get();
//    threadLocal.set(null);
//
//    if (session != null) {
//      session.close();
//    }
//  }

}