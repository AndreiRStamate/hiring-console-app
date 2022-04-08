package com.company;

import java.util.Dictionary;

enum LanguageSkill {
    BEGINNER,
    ADVANCED,
    EXPERIENCED
}

public class Information {

    private String nume;
    private String prenume;
    private String email;
    private String telefon;
    private String sex;
    private Dictionary<String, LanguageSkill> limbiCunoscute;

    public Information() {
    }

    public Information(String nume, String prenume, String email, String telefon, String sex, Dictionary<String, LanguageSkill> limbiCunoscute) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.telefon = telefon;
        this.sex = sex;
        this.limbiCunoscute = limbiCunoscute;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }

}
