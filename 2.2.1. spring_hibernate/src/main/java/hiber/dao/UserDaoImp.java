package hiber.dao;

import hiber.model.Car;
import org.hibernate.Query;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
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
//   public User getUserWhereCar(Long id, int series) {
//      Transaction transaction = null;
//      try(Session session = sessionFactory.getCurrentSession()) {
//         session.beginTransaction();
//         transaction = sessionFactory.getCurrentSession().getTransaction();
//         Query query = sessionFactory.getCurrentSession().createQuery("FROM Car c WHERE c.id = :paramId AND c.series = :paramSeries");
//         query.setParameter("paramId", id);
//         query.setParameter("paramSeries", series);
//         List<Car> cars = query.list();
//         return list.get(0).getUser();
//      } catch (Exception e) {
//         if (transaction != null) {
//            transaction.rollback();
//         }
//         throw e;
//      }
//   }
   @Override
   public User getUserWhereCar(String model, int series) {
      Query query = sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u WHERE u.car.model = :paramModel AND u.car.series = :paramSeries");
      query.setParameter("paramModel", model);
      query.setParameter("paramSeries", series);
      List<User> user = query.list();
      return user.get(0);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}
