package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
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
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public User getUserFromCarModelAndSeries(String model, int series) {
      TypedQuery<User> query;
      try {
         query = sessionFactory.getCurrentSession()
                 .createQuery("from User user where user.userCar.model = :model and user.userCar.series = :series");
         query.setParameter("model", model).setParameter("series", series);

         return query.setMaxResults(1).getSingleResult();

      }catch (NoResultException e){
         System.out.println("Не найден пользователь с такой машиной");
      }
      return null;
   }

}
