package pl.shadoq.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import pl.shadoq.entity.BaseEntity;
import pl.shadoq.repository.GenericRepository;

import java.util.List;

/**
 * Created by Jan on 2015-10-31.
 */
public class GenericRepositoryImpl<T> implements GenericRepository<T> {

    protected Class<T> type;
    protected SessionFactory sessionFactory;

    public GenericRepositoryImpl() {

    }

    public GenericRepositoryImpl(SessionFactory sessionFactory, Class<T> type) {
        this.sessionFactory = sessionFactory;
        this.type = type;
    }

    public GenericRepositoryImpl(Class<T> type) {
        this.type = type;
    }

    public Long add(T emp) {
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        Long id = null;
        try {
            id = (Long) session.save(emp);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println(e.getMessage());
        } finally {
            session.close();
        }
        return id;
    }

    public T get(Long id) {
            Session session = sessionFactory.openSession();

            Criteria criteria = session.createCriteria(type);

            Transaction transaction = session.beginTransaction();
            System.out.println("typ generyczny: " + type);

            ClassMetadata  classMetadata = sessionFactory.getClassMetadata(type);
            String NameColumnPK = classMetadata.getIdentifierPropertyName();

            criteria.add(Restrictions.eq(NameColumnPK, id));
            T obj = null;
            List<T> objs = criteria.list();
            if (objs != null && !objs.isEmpty()) {
                obj = objs.get(0);
            }
            transaction.commit();
            session.close();
            return obj;
    }

    public Boolean update(Long id, T emp) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(emp.getClass());

        ClassMetadata  classMetadata = sessionFactory.getClassMetadata(emp.getClass());
        String NameColumnPK = classMetadata.getIdentifierPropertyName();

        criteria.add(Restrictions.eq(NameColumnPK, id));
        Boolean result = false;
        T obj;
        List<T> objs = criteria.list();
        Transaction transaction = session.beginTransaction();
        if (objs != null && !objs.isEmpty() && objs.size() == 1) {
            obj = objs.get(0);
            ((BaseEntity) emp).setId(((BaseEntity) obj).getId());

            try {
                result = true;
                if( ((BaseEntity) emp).getId() != null) {
                    session.merge(emp);
                } else {
                    session.update(emp);
                }
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                System.err.println(e.getMessage());
            } finally {
                session.close();
            }
        }

        return result;
    }

    public Boolean delete(T emp) {
        Session session = sessionFactory.openSession();
        Boolean result = false;

        if (emp != null && !emp.equals("")) {
            Transaction transaction = session.beginTransaction();
            try {
                session.delete(emp);
                result = true;
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                System.err.println(e.getMessage());
            } finally {
                session.close();
            }
        }
        return result;
    }
}
