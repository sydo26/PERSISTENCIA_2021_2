package com.lista04;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.lista04.database.DatabaseConfig;
import com.lista04.database.PgConnection;
import com.lista04.sections.DeleteEmployeeSection;
import com.lista04.sections.FindEmployeeSection;
import com.lista04.sections.GenerateRandomEmployeesSection;
import com.lista04.sections.ListAllEmployeesSection;
import com.lista04.sections.RegisterEmployeeSection;
import com.lista04.utils.Menu;

public class App {
    public static void main(String[] args) throws IOException, SQLException {

        DatabaseConfig config = new DatabaseConfig("config.yaml").load();

        PgConnection pg = new PgConnection(config.host, config.user, config.pass, config.database);

        Connection con = pg.start();

        pg.initDatabase("construct.sql");

        Menu menu = new Menu(con);

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

        menu.start();

    }
}
