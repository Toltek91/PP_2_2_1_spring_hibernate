package hiber.dao;

import hiber.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User");
        return query.getResultList();

    }

    @Override
    public User findUser(String car_name, int car_series) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User where Car.model =:paramName and Car.series=:paramSer");
        query.setParameter("paramName", car_name);
        query.setParameter("paramSer", car_series);
        return (User) query.getResultList();
    }
}
