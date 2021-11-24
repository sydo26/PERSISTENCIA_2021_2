package com.lista04.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import com.github.javafaker.Faker;
import com.lista04.entity.Employee;
import com.lista04.interfaces.IEmployeeDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao implements IEmployeeDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    protected final int batchSize = 100;
    protected final int protectedLimitSearch = 50;

    public EmployeeDao() {
    }

    @Override
    public List<Employee> findAll() throws SQLException {

        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("limit", this.protectedLimitSearch);

        return jdbc.query("SELECT * FROM employee ORDER BY(id) DESC LIMIT :limit", namedParameters, (res, rowIdx) -> {
            Integer id = res.getInt("id");
            Integer registration = res.getInt("registration");
            String name = res.getString("name");
            String email = res.getString("email");
            String cpf = res.getString("cpf");
            String phone = res.getString("phone");
            return new Employee(id, registration, name, email, phone, cpf);
        });
    }

    @Override
    public boolean deleteUnique(Integer identifier) throws SQLException {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("id", identifier);
        int res = jdbc.update("DELETE FROM employee WHERE id=:id", params);
        return res > 0;
    }

    @Override
    public Employee findFirst(Employee obj) throws SQLException {

        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", obj.getId())
                .addValue("registration", obj.getRegistration()).addValue("cpf", obj.getCpf());

        return jdbc.queryForObject(
                "SELECT * FROM employee WHERE id=:id OR registration=:registration OR cpf=:cpf ORDER BY(id) ASC LIMIT 1",
                namedParameters, (res, rowIdx) -> {
                    Integer id = res.getInt("id");
                    Integer registration = res.getInt("registration");
                    String name = res.getString("name");
                    String email = res.getString("email");
                    String cpf = res.getString("cpf");
                    String phone = res.getString("phone");
                    return new Employee(id, registration, name, email, phone, cpf);
                });
    }

    @Override
    public Employee save(Employee obj) throws SQLException {

        SqlParameterSource params = new MapSqlParameterSource().addValue("name", obj.getName())
                .addValue("email", obj.getEmail()).addValue("cpf", obj.getCpf()).addValue("phone", obj.getPhone());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update("INSERT INTO employee(name, email, cpf, phone) VALUES(:name,:email,:cpf,:phone)", params, keyHolder,
                new String[] { "id", "registration", "name", "email", "cpf", "phone" });

        Map<String, Object> res = keyHolder.getKeys();

        if (res.size() > 0) {
            Integer id = (Integer) res.get("id");
            Integer registration = (Integer) res.get("registration");
            String name = (String) res.get("name");
            String email = (String) res.get("email");
            String cpf = (String) res.get("cpf");
            String phone = (String) res.get("phone");
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
