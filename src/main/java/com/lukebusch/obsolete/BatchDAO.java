package com.lukebusch.obsolete;

import com.lukebusch.entity.Batch;
import com.lukebusch.persistence.SessionFactoryProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * *** Currently not used in favor of a Generic Dao ***
 *
 *
 *
 * A Dao to manipulate beer batches
 *
 * @author lbusch
 */
public class BatchDAO {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get User by id
     */
    public Batch getById(int id) {
        Session session = sessionFactory.openSession();
        Batch batch = session.get(Batch.class, id);
        return batch;
    }

    /**
     * update Batch
     * @param batch Batch to be inserted or updated
     */
    public void saveOrUpdate(Batch batch) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(batch);
        transaction.commit();
        session.close();
    }

    /**
     * update Batch
     * @param batch Batch to be inserted or updated
     */
    public int insert(Batch batch) {
        int id = 0;

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(batch);
        transaction.commit();
        session.close();

        return id;
    }

    /**
     * Delete a batch
     * @param batch Batch to be deleted
     */
    public void delete(Batch batch) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(batch);
        transaction.commit();
        session.close();
    }


    /** Return a list of all batches
     *
     * @return All batches
     */
    public List<Batch> getAll() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Batch> query = builder.createQuery( Batch.class );
        Root<Batch> root = query.from( Batch.class );
        List<Batch> batches = session.createQuery( query ).getResultList();

        logger.debug("The list of batches: " + batches);
        session.close();

        return batches;
    }
}
