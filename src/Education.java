package com.company;

import java.time.LocalDate;

enum NivelEducatie {
    LICEU,
    LICENTA,
    MASTER,
    DOCTORAT
}

public class Education implements Comparable<Education>{

    private LocalDate dataInceput;
    private LocalDate dataSfarsit;
    private String numeInstitutie;
    private NivelEducatie nivelEducatie;
    private Double medieFinalizare;

    public Double getMedieFinalizare() {
        return medieFinalizare;
    }

    private static void validate (LocalDate dataInceput, LocalDate dataSfarsit) throws InvalidDatesException{
        if (dataInceput.isAfter(dataSfarsit)) {
            throw new InvalidDatesException("Datele sunt invalide");
        }
    }

    public Education(LocalDate dataInceput, LocalDate dataSfarsit, String numeInstitutie, NivelEducatie nivelEducatie, Double medieFinalizare) {
        try {
            validate(dataInceput, dataSfarsit);
        } catch (InvalidDatesException e) {
            e.printStackTrace();
        }
        this.dataInceput = dataInceput;
        this.dataSfarsit = dataSfarsit;
        this.numeInstitutie = numeInstitutie;
        this.nivelEducatie = nivelEducatie;
        this.medieFinalizare = medieFinalizare;
    }

    @Override
    public int compareTo(Education o) {
        if (this.dataSfarsit.isAfter(o.dataSfarsit)) return 1;
        else if (this.dataSfarsit.equals(o.dataSfarsit)) {
            if (this.medieFinalizare - o.medieFinalizare > 0) {
                return 1;
            }
            else if (this.medieFinalizare - o.medieFinalizare < 0){
                return -1;
            }
            else {
                if (this.dataInceput.isBefore(o.dataInceput)) {
                    return 1;
                }
                return -1;
            }
        }
        return 0;
    }
}
