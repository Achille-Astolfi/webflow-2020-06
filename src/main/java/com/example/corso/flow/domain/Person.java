package com.example.corso.flow.domain;

import java.time.LocalDate;

public class Person {
    // per creare una class JavaBean "la riempio" di campi
    private String firstName;
    private String lastName;
    // il .toString() di un oggetto LocalDate è in formato ISO yyyy-MM-gg
    private LocalDate birthDate;
    private String patronymic;
    // In Russia si usano firstName, patronymic, lastName
    // In Italia si usano firstName, lastName
    // In Islanda si usano firstName, patronymic
    
    // Una volta che ho compilato l'elenco dei campi, chiedo alla mia IDE di generare
    // i getter e i setter; terminata questa operazione ho di fatto generato un JavaBean
    // SE non aggiungo altri metodi ho creato un Data Transfer Object (DTO)

    // Il costruttore resta quello di default

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
