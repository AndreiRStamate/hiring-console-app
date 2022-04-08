package com.company;

import java.util.List;

public class Job {

    private String nume;
    private String numeCompanie;

    private boolean valabil;

    private Constraint anulAbsolvirii;
    private Constraint aniExperienta;
    private Constraint medieAcademica;

    private List<User> candidati;
    private Integer numarPosturi;

    private Float salariu;

    public boolean isValabil() {
        return valabil;
    }

    public void apply(User user){

    }

    public boolean meetsRequirements(User user) {
        return false;
    }
}
