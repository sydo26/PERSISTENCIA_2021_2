package com.trab02;

import java.time.LocalDate;

import com.trab02.dtos.StudentStoreDTO;
import com.trab02.entities.Student;
import com.trab02.services.StudentService;
import com.trab02.shared.other.AddMultiplesStudents;
import com.trab02.shared.ui.IUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired()
    private IUI iui;

    @Autowired
    private AddMultiplesStudents addMultiplesStudents;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.addMultiplesStudents.run();
        this.iui.run(args);
    }
}
