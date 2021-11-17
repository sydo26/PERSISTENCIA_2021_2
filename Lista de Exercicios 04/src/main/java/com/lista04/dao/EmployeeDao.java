package com.lista04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;
import com.lista04.interfaces.DaoCommon;
import com.lista04.models.Employee;

public class EmployeeDao implements DaoCommon<Employee> {

    protected final int batchSize = 100;
    protected final int protectedLimitSearch = 50;
    protected Connection con;

    public EmployeeDao(Connection connection) {
        this.con = connection;
    }

    @Override
    public List<Employee> findAll() throws SQLException {
        PreparedStatement employeesPs = con.prepareStatement("SELECT * FROM employee ORDER BY(id) DESC LIMIT ?",
                new String[] { "id", "name", "registration", "email", "cpf", "phone" });

        employeesPs.setInt(1, protectedLimitSearch);

        ResultSet res = employeesPs.executeQuery();

        List<Employee> employess = new ArrayList<>();

        while (res.next()) {
            Integer id = res.getInt("id");
            Integer registration = res.getInt("registration");
            String name = res.getString("name");
            String email = res.getString("email");
            String cpf = res.getString("cpf");
            String phone = res.getString("phone");

            employess.add(new Employee(id, registration, name, email, phone, cpf));
        }

        return employess;
    }

    @Override
    public Employee deleteUnique(Integer identifier) throws SQLException {
        PreparedStatement employeesPs = con.prepareStatement("DELETE FROM employee WHERE id=?",
                new String[] { "id", "name", "registration", "email", "cpf", "phone" });

        employeesPs.setInt(1, identifier);

        employeesPs.execute();

        ResultSet res = employeesPs.getGeneratedKeys();

        if (res.next()) {
            Integer id = res.getInt("id");
            Integer registration = res.getInt("registration");
            String name = res.getString("name");
            String email = res.getString("email");
            String cpf = res.getString("cpf");
            String phone = res.getString("phone");

            return new Employee(id, registration, name, email, phone, cpf);
        }

        return null;
    }

    @Override
    public Employee findFirst(Employee obj) throws SQLException {
        PreparedStatement employeesPs = con.prepareStatement(
                "SELECT * FROM employee WHERE id=? OR registration=? OR cpf=? ORDER BY(id) ASC LIMIT 1",
                new String[] { "id", "name", "registration", "email", "cpf", "phone" });

        employeesPs.setInt(1, obj.getId() != null ? obj.getId() : null);
        employeesPs.setInt(2, obj.getRegistration() != null ? obj.getRegistration() : null);
        employeesPs.setString(3, obj.getCpf() != null ? obj.getCpf() : null);

        ResultSet res = employeesPs.executeQuery();

        if (res.next()) {
            Integer id = res.getInt("id");
            Integer registration = res.getInt("registration");
            String name = res.getString("name");
            String email = res.getString("email");
            String cpf = res.getString("cpf");
            String phone = res.getString("phone");

            return new Employee(id, registration, name, email, phone, cpf);
        }

        return null;
    }

    @Override
    public Employee save(Employee obj) throws SQLException {
        PreparedStatement employeePs = con.prepareStatement(
                "INSERT INTO employee(name, email, cpf, phone) VALUES(?, ?, ?, ?)",
                new String[] { "id", "name", "registration", "email", "cpf", "phone" });

        employeePs.setString(1, obj.getName());
        employeePs.setString(2, obj.getEmail());
        employeePs.setString(3, obj.getCpf());
        employeePs.setString(4, obj.getPhone());

        employeePs.execute();

        ResultSet res = employeePs.getGeneratedKeys();

        if (res.next()) {

            Integer id = res.getInt("id");
            Integer registration = res.getInt("registration");
            String name = res.getString("name");
            String email = res.getString("email");
            String cpf = res.getString("cpf");
            String phone = res.getString("phone");

            return new Employee(id, registration, name, email, phone, cpf);
        }

        return null;
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
}
