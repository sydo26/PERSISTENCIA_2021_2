package com.lista04.sections;

import java.io.Console;
import java.sql.Connection;
import java.sql.SQLException;

import com.lista04.dao.EmployeeDao;
import com.lista04.enums.ColorType;
import com.lista04.enums.ValidatorType;
import com.lista04.interfaces.Section;
import com.lista04.models.Employee;
import com.lista04.utils.Questions;
import com.lista04.utils.Screen;

public class RegisterEmployeeSection implements Section {
    @Override
    public boolean execute(Console console, Connection con, String response) {

        if (!(response.equalsIgnoreCase("S") || response.equalsIgnoreCase("SIM") || response.equalsIgnoreCase("Y")
                || response.equalsIgnoreCase("YES")))
            return false;

        Questions questions = new Questions("\nREGISTRAR NOVO FUNCIONÁRIO\n", console);

        String name = questions.ask("Nome do funcionário:", ValidatorType.IsName);
        String email = questions.ask("E-mail:", ValidatorType.IsEmail);
        String cpf = questions.ask("Sequência de números do cpf:", ValidatorType.IsCPF);
        String phone = questions.ask("Agora informe o número de telefone:", ValidatorType.IsPlainPhone);

        EmployeeDao dao = new EmployeeDao(con);

        try {
            Employee employee = dao.save(Employee.create(name, email, phone, cpf.replaceAll("[\\-\\.]", "")));
            if (employee != null) {
                Screen.println("\nFUNCIONÁRIO CADASTRADO COM SUCESSO!\n", ColorType.WHITE, true);
            } else {
                Screen.println("\nNÃO FOI POSSÍVEL CADASTRAR O FUNCIONÁRIO!\n", ColorType.RED, true);
            }
        } catch (SQLException e) {
            if (e.getMessage().contains("Key (cpf)")) {
                Screen.println("\nO CPF INFORMADO JÁ ESTÁ CADASTRADO!\n", ColorType.RED, true);
            } else {
                Screen.println("\nNÃO FOI POSSÍVEL CADASTRAR O FUNCIONÁRIO!\n", ColorType.RED, true);
            }

        }

        Screen.println("Pressione [ENTER] para voltar ao menu.\n", ColorType.BLACK, true);

        console.readLine();

        return false;
    }

    @Override
    public void print() {
        Screen.println("\nREGISTRAR NOVO FUNCIONÁRIO\n", ColorType.WHITE, true);
        Screen.println("Deseja prosseguir com o cadastro? (S/N)\n", ColorType.BLACK, true);
        Screen.print("Não", ColorType.RED, true);
        Screen.print(" > ", ColorType.YELLOW);
    }

}
