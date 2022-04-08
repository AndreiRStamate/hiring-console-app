package com.company;


public class Employee extends Consumer{
    private String companie;
    private Float salariu;

    public Float getSalariu() {
        return salariu;
    }

    public Employee(String companie, Float salariu) {
        super();
        this.companie = companie;
        this.salariu = salariu;
    }

    public Employee(User user) {
        super();

    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Employee) {
            Employee aux = (Employee)o;
            return getResume().getInformation().getEmail().equals(aux.getResume().getInformation().getEmail()) &&
                    getResume().getInformation().getNume().equals(aux.getResume().getInformation().getNume()) &&
                    getResume().getInformation().getPrenume().equals(aux.getResume().getInformation().getPrenume()) &&
                    getResume().getInformation().getTelefon().equals(aux.getResume().getInformation().getTelefon());
        }
        return false;
    }
}
