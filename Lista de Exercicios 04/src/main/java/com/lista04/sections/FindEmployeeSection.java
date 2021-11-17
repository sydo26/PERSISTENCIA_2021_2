package com.lista04.sections;

import java.io.Console;
import java.sql.Connection;
import java.sql.SQLException;

import com.lista04.dao.EmployeeDao;
import com.lista04.enums.ColorType;
import com.lista04.interfaces.Section;
import com.lista04.models.Employee;
import com.lista04.utils.Screen;

public class FindEmployeeSection implements Section {
    @Override
    public boolean execute(Console console, Connection con, String response) {
        if (!(response.equalsIgnoreCase("S") || response.equalsIgnoreCase("SIM") || response.equalsIgnoreCase("Y")
                || response.equalsIgnoreCase("YES")))
            return false;

        EmployeeDao dao = new EmployeeDao(con);
        Employee employee = null;

        Screen.println("\nPROCURE UM FUNCIONÁRIO PELO ID, MATRÍCULA ou CPF.\n", ColorType.WHITE, true);
        Screen.print("Informe o id, matrícula ou cpf do funcionário: ", ColorType.WHITE, true);

        String res = console.readLine();

        Integer number = null;
        try {
            number = Integer.parseInt(res);
        } catch (Exception e) {
            number = -1;
        }

        try {
            employee = dao.findFirst(new Employee(number, number, "", "", "", res));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (employee == null) {
            Screen.println("\nNÃO FOI POSSÍVEL ENCONTRAR UM FUNCIONÁRIO!\n", ColorType.RED, true);
        } else {
            Screen.println(String.format("%-7s\t%-9s\t%-20s\t%-20s\t%-11s\t%-11s\n", "ID", "MATRÍCULA", "NOME", "EMAIL",
                    "TELEFONE", "CPF"), ColorType.BLACK, true);
            Screen.println(employee.toString(), ColorType.WHITE);
        }

        Screen.println("\nPressione [ENTER] para voltar ao menu.\n", ColorType.BLACK, true);

        console.readLine();

        return false;
    }

    @Override
    public void print() {
        Screen.println("\nPROCURE UM FUNCIONÁRIO\n", ColorType.WHITE, true);
        Screen.println("Deseja prosseguir e procurar um funcionário? (S/N)\n", ColorType.BLACK, true);
        Screen.print("Não", ColorType.RED, true);
        Screen.print(" > ", ColorType.YELLOW);
    }
}
