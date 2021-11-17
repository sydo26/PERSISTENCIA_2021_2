package com.lista04.sections;

import java.io.Console;
import java.sql.Connection;
import java.sql.SQLException;

import com.lista04.dao.EmployeeDao;
import com.lista04.enums.ColorType;
import com.lista04.interfaces.Section;
import com.lista04.models.Employee;
import com.lista04.utils.Screen;

public class GenerateRandomEmployeesSection implements Section {
    @Override
    public boolean execute(Console console, Connection con, String response) {

        if (!(response.equalsIgnoreCase("S") || response.equalsIgnoreCase("SIM") || response.equalsIgnoreCase("Y")
                || response.equalsIgnoreCase("YES")))
            return false;

        Screen.println("\nGERAR FUNCIONÁRIOS FAKES\n\n", ColorType.WHITE, true);

        EmployeeDao dao = new EmployeeDao(con);

        Screen.println(String.format("%-7s\t%-9s\t%-20s\t%-20s\t%-11s\t%-11s\n", "ID", "MATRÍCULA", "NOME", "EMAIL",
                "TELEFONE", "CPF"), ColorType.BLACK, true);
        int i = 0;
        for (i = 0; i < 20; i++) {
            try {
                Employee emp = dao.saveFake();
                Screen.println(emp.toString(), ColorType.WHITE, true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        Screen.println(String.format("\nFUNCIONÁRIOS GERADOS! QUANTIDADE: %d\n", i), ColorType.WHITE, true);

        Screen.println("Pressione [ENTER] para voltar ao menu.\n", ColorType.BLACK, true);

        console.readLine();

        return false;
    }

    @Override
    public void print() {
        Screen.println("\nGERAR FUNCIONÁRIOS FAKES\n", ColorType.WHITE, true);
        Screen.println("Deseja prosseguir com a geração de funcionários? (S/N)\n", ColorType.BLACK, true);
        Screen.print("Não", ColorType.RED, true);
        Screen.print(" > ", ColorType.YELLOW);
    }
}
