package com.example.gpc_p;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/////////////////////////// Klasa główna aplikacji ////////////////////////////

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GpcPApplication {

    ///////////// Metoda uruchamiająca aplikację /////////////

    // @param args argumenty wiersza poleceń
    public static void main(String[] args) {
        SpringApplication.run(GpcPApplication.class, args);
    }

}
