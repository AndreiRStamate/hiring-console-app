package com.company;

import java.time.LocalDate;

public class Experience implements Comparable<Experience>{

    private LocalDate dataInceput;
    private LocalDate dataSfarsit;
    private String pozitie;
    private String companie;

    public LocalDate getDataInceput() {
        return dataInceput;
    }

    public LocalDate getDataSfarsit() {
        return dataSfarsit;
    }

    private static void validate (LocalDate dataInceput, LocalDate dataSfarsit) throws InvalidDatesException{
        if (dataInceput.isAfter(dataSfarsit)) {
            throw new InvalidDatesException("Datele sunt invalide");
        }
    }

    public Experience(LocalDate dataInceput, LocalDate dataSfarsit, String pozitie, String companie) {
        try {
            validate(dataInceput, dataSfarsit);
        } catch (InvalidDatesException e) {
            e.printStackTrace();
        }

        this.dataInceput = dataInceput;
        this.dataSfarsit = dataSfarsit;
        this.pozitie = pozitie;
        this.companie = companie;
    }

    @Override
    public int compareTo(Experience o) {
        if (this.dataSfarsit == null || o.dataSfarsit == null) {
            return -this.companie.compareTo(o.companie);
        }
        if (this.dataSfarsit.isAfter(o.dataSfarsit)) return 1;
        return -1;
    }
}
