package com.lista04.sections;

import java.io.Console;
import java.sql.SQLException;

import com.lista04.enums.ColorType;
import com.lista04.interfaces.Section;
import com.lista04.jpa.EmployeeDaoJPA;
import com.lista04.utils.Screen;

public class DeleteEmployeeSection implements Section<EmployeeDaoJPA> {
    @Override
    public boolean execute(Console console, String response, EmployeeDaoJPA repository) {
        if (!(response.equalsIgnoreCase("S") || response.equalsIgnoreCase("SIM") || response.equalsIgnoreCase("Y")
                || response.equalsIgnoreCase("YES")))
            return false;

        boolean success = false;

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
            success = repository.deleteUnique(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!success) {
            Screen.println("\nNÃO FOI POSSÍVEL ENCONTRAR UM FUNCIONÁRIO PARA DELETAR!\n", ColorType.RED, true);
        } else {
            Screen.println("\nO FUNCIONÁRIO A SEGUIR FOI DELETADO COM SUCESSO!\n", ColorType.RED, true);
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
