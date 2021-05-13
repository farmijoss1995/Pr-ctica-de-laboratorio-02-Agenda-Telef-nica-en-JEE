package ups.edu.ec.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ups.edu.ec.modelo.Telefono;
import ups.edu.ec.modelo.usuario;
import ups.edu.ec.util.HibernateUtil;

public class telefonodao {

   
    public void saveTelefono(Telefono telefono) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(telefono);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

   
    public void updateTelefono(Telefono telefono) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(telefono);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    
    public void deleteTelefono(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a tel object
            Telefono tel = session.get(Telefono.class, id);
            if (tel != null) {
                session.delete(tel);
                System.out.println("telefono is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    
    public Telefono getTelefono(int id) {

        Transaction transaction = null;
        Telefono tel = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an tel object
            tel = session.get(Telefono.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return tel;
    }

    @SuppressWarnings("unchecked")
    public List < Telefono > getAllTelefono() {

        Transaction transaction = null;
        List < Telefono > listOfTelefono = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an tel object

            listOfTelefono = session.createQuery("from Telefono").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfTelefono;
    }
}
