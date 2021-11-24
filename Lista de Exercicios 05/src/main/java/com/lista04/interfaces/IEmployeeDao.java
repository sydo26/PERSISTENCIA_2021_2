package com.lista04.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.lista04.entity.Employee;

public interface IEmployeeDao {
    /** Salva um novo objeto no banco */
    public Employee save(Employee obj) throws SQLException;

    /** Salva dados fakes */
    public Employee saveFake() throws SQLException;

    /** Lista todos os objetos do banco */
    public List<Employee> findAll() throws SQLException;

    /** Pega o primeiro objeto que possui os dados informados */
    public Employee findFirst(Employee obj) throws SQLException;

    /** Deleta o um objeto que possui o identificador */
    public boolean deleteUnique(Integer id) throws SQLException;
}
