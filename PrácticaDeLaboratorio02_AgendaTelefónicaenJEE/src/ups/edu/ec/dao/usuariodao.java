package ups.edu.ec.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ups.edu.ec.modelo.usuario;
import ups.edu.ec.util.HibernateUtil;


public class usuariodao {

    public void guardarUsuario(usuario usuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the stu dent object
            session.save(usuario);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public boolean validarUsuario(String correo, String password) {

        Transaction transaction = null;
        usuario user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = (usuario) session.createQuery("FROM usuario U WHERE U.correo = :correo").setParameter("correo", correo)
                .uniqueResult();

            if (user != null && user.getPassword().equals(password)) {
                return true;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

}
