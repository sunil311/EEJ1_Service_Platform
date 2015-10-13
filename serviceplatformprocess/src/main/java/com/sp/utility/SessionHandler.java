package com.sp.utility;

import org.hibernate.Session;

/**
 * 
 * @author rakesh.singhania
 *
 */
public class SessionHandler {

    /**
     * Start new session
     * @return session
     */
    public static Session stratTransaction() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        return session;
    }
    
    /**
     * End existing session
     * @param session
     */
    public static void endTransaction(Session session) {
        session.getTransaction().commit();
        session.close();
    }
    
    public static void revertTransaction(Session session) {
        session.getTransaction().rollback();
        session.close();
    }
}