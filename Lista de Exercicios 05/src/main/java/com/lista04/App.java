package com.lista04;

import com.lista04.dao.EmployeeDao;
import com.lista04.entity.Employee;
import com.lista04.sections.DeleteEmployeeSection;
import com.lista04.sections.FindEmployeeSection;
import com.lista04.sections.GenerateRandomEmployeesSection;
import com.lista04.sections.ListAllEmployeesSection;
import com.lista04.sections.RegisterEmployeeSection;
import com.lista04.utils.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    EmployeeDao employeeRepository;

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(App.class);

        builder.headless(false).run(args);
    }

    @Override
    public void run(String... args) throws Exception {

        Menu<EmployeeDao> menu = new Menu<EmployeeDao>(employeeRepository);

        // Register
        menu.addSection("1", new RegisterEmployeeSection()).addOption("1", "Registrar funcionário.");

        // List all
        menu.addSection("2", new ListAllEmployeesSection()).addOption("2", "Mostrar todos os funcionários.");

        // Generate fakes
        menu.addSection("3", new GenerateRandomEmployeesSection()).addOption("3",
                "Gerar funcionários fakes (Para testes)");

        // Procurar funcionário
        menu.addSection("4", new FindEmployeeSection()).addOption("4", "Procurar funcionário");

        // Deletar funcionário
        menu.addSection("5", new DeleteEmployeeSection()).addOption("5", "Deletar um funcionário");

        menu.init();
    }

}
