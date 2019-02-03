/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author martin
 */
public class UserMapper {

    EntityManager em;

    public UserMapper(String pu) {
        this.em = Persistence.createEntityManagerFactory(pu).createEntityManager();
    }

    public List<User> getAllUsers() {
        return em.createNamedQuery("User.findAll").getResultList();
    }

    public User updateUser(User user) {
        return em.merge(user);
    }

    public void deleteUser(User user) {
        em.remove(user);
    }
    
    public User addUser(User user){
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        return user;
    }
    
    public User getUser(int id){
        return (User) em.createNamedQuery("User.findById").setParameter("id", id).getSingleResult();
    }
}
