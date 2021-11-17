package com.lista04.sections;

import java.io.Console;
import java.sql.Connection;
import java.sql.SQLException;

import com.lista04.dao.EmployeeDao;
import com.lista04.enums.ColorType;
import com.lista04.interfaces.Section;
import com.lista04.models.Employee;
import com.lista04.utils.Screen;

public class DeleteEmployeeSection implements Section {
    @Override
    public boolean execute(Console console, Connection con, String response) {
        if (!(response.equalsIgnoreCase("S") || response.equalsIgnoreCase("SIM") || response.equalsIgnoreCase("Y")
                || response.equalsIgnoreCase("YES")))
            return false;

        EmployeeDao dao = new EmployeeDao(con);
        Employee employee = null;

        Screen.println("\nDELETE UM FUNCIONÁRIO PELO ID.\n", ColorType.WHITE, true);
        Screen.print("Informe o id: ", ColorType.WHITE, true);

        String line = console.readLine();

        Integer id;
        try {
            id = Integer.parseInt(line);
        } catch (Exception e) {
            id = -1;
        }

        try {
            employee = dao.deleteUnique(id);
        } catch (SQLException e) {
        }

        if (employee == null) {
            Screen.println("\nNÃO FOI POSSÍVEL ENCONTRAR UM FUNCIONÁRIO PARA DELETAR!\n", ColorType.RED, true);
        } else {
            Screen.println("\nO FUNCIONÁRIO A SEGUIR FOI DELETADO COM SUCESSO!\n", ColorType.RED, true);
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
        Screen.println("\nDELETE UM FUNCIONÁRIO\n", ColorType.WHITE, true);
        Screen.println("Deseja prosseguir e deletar um funcionário? (S/N)\n", ColorType.BLACK, true);
        Screen.print("Não", ColorType.RED, true);
        Screen.print(" > ", ColorType.YELLOW);
    }
}
