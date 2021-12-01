package com.lista04.jpa;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.persistence.EntityManager;

import com.github.javafaker.Faker;
import com.lista04.entity.Employee;
import com.lista04.interfaces.IEmployeeDao;
import com.lista04.utils.JPAUtil;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class EmployeeDaoJPA implements IEmployeeDao {

    protected final int batchSize = 100;
    protected final int protectedLimitSearch = 50;

    @Override
    public Employee save(Employee obj) throws SQLException {
        EntityManager em = JPAUtil.getEntityManager();
        Employee result = null;
        try {
            JPAUtil.beginTransaction();
            result = em.merge(obj);
            JPAUtil.commit();
        } catch (Exception e) {
            JPAUtil.rollback();
            e.printStackTrace();
        } finally {
            JPAUtil.closeEntityManager();
        }

        return result;
    }

    @Override
    public Employee saveFake() throws SQLException {
        Faker faker = new Faker(new Locale("pt-BR"), new Random(System.currentTimeMillis()));

        String email = faker.bothify("???##?????##@????.com");
        String name = faker.address().firstName() + " " + faker.address().lastName();
        String phone = faker.bothify("###########");
        String cpf = faker.bothify("###########");

        return this.save(Employee.create(name, email, phone, cpf));
    }

    @Override
    public List<Employee> findAll() throws SQLException {

        EntityManager em = JPAUtil.getEntityManager();
        List<Employee> l = em.createQuery("SELECT e FROM Employee as e ORDER BY(e.id) DESC", Employee.class)
                .setMaxResults(protectedLimitSearch)
                .getResultList();
        JPAUtil.closeEntityManager();

        return l;
    }

    @Override
    public Employee findFirst(Employee obj) throws SQLException {
        EntityManager em = JPAUtil.getEntityManager();
        Employee result = em.find(Employee.class, obj.getId() != null ? obj.getId()
                : obj.getRegistration() != null ? obj.getRegistration() : obj.getCpf());
        JPAUtil.closeEntityManager();

        return result;
    }

    @Override
    public boolean deleteUnique(Integer id) throws SQLException {
        EntityManager em = JPAUtil.getEntityManager();
        JPAUtil.beginTransaction();
        int result = em.createQuery("DELETE FROM Employee WHERE id=:id").setParameter("id", id).executeUpdate();
        JPAUtil.closeEntityManager();

        return result > 0;
    }

}
