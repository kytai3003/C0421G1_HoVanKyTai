package codegym.model.repository;

import codegym.model.bean.Product;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepoImpl implements IProductRepo{

    @PersistenceContext
    private static EntityManager entityManager;

    static {
        try {
            SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product as p", Product.class);

        return query.getResultList();
    }

    @Override
    public void save(Product product) {
//        Session session = null;
//        Transaction transaction = null;
//        try {
//            session = sessionFactory.openSession();
//            transaction = session.beginTransaction();
//            session.createNativeQuery("Insert into Product values (:p1, :p2, :p3, :p4, :p5)")
//                    .setParameter("p1", product.getProductId())
//                    .setParameter("p2", product.getProductName())
//                    .setParameter("p3", product.getProductPrice())
//                    .setParameter("p4", product.getDescription())
//                    .setParameter("p5", product.getProductBrand());
//
//            transaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }

        try {
            entityManager.getTransaction().begin();

            if (product.getProductId() != null) {
                entityManager.merge(product);
            } else {
                entityManager.persist(product);
            }

            entityManager.getTransaction().commit();

        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(int id) {
        String queryStr = "SELECT p FROM Product AS p WHERE p.productId = :id";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void remove(int id) {

        try {
            entityManager.getTransaction().begin();

            entityManager.remove(entityManager.merge(findById(id)));

            entityManager.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        String queryStr = "SELECT p FROM Product AS p WHERE p.productName like :name";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
}
