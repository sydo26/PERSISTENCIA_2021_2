package com.lista04.sections;

import java.io.Console;
import java.sql.SQLException;
import java.util.List;

import com.lista04.dao.EmployeeDao;
import com.lista04.entity.Employee;
import com.lista04.enums.ColorType;
import com.lista04.interfaces.Section;
import com.lista04.utils.Screen;

public class ListAllEmployeesSection implements Section<EmployeeDao> {

    @Override
    public boolean execute(Console console, String response, EmployeeDao repository) {
        if (!(response.equalsIgnoreCase("S") || response.equalsIgnoreCase("SIM") || response.equalsIgnoreCase("Y")
                || response.equalsIgnoreCase("YES")))
            return false;

        Screen.println("\nLISTA DE FUNCIONÁRIOS CADASTRADOS EM ORDEM DECRESCENTE\n", ColorType.WHITE, true);

        try {
            List<Employee> list = repository.findAll();

            Screen.println(String.format("%-7s\t%-9s\t%-20s\t%-20s\t%-11s\t%-11s\n", "ID", "MATRÍCULA", "NOME", "EMAIL",
                    "TELEFONE", "CPF"), ColorType.BLACK, true);
            for (Employee employee : list) {
                Screen.println(employee.toString(), ColorType.WHITE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Screen.println("\nPressione [ENTER] para voltar ao menu.\n", ColorType.BLACK, true);

        console.readLine();

        return false;
    }

    @Override
    public void print() {
        Screen.println("\nLISTA DE FUNCIONÁRIOS CADASTRADOS\n", ColorType.WHITE, true);
        Screen.println("Deseja ver a lista dos funcionários? (S/N)\n", ColorType.BLACK, true);
        Screen.print("Não", ColorType.RED, true);
        Screen.print(" > ", ColorType.YELLOW);
    }
}
