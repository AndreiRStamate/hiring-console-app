package com.company;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class User extends Consumer implements IObserver{

    private ArrayList<Notification> notifications;

    private List<String> companies;

    public User(Resume resume, List<Consumer> listaCunoscuti) {
        super(resume, listaCunoscuti);
    }

    public List<String> getCompanies() {
        return companies;
    }

    public Employee convert(){
        return new Employee("Companie", 99.99f);
    }

    public Double getTotalScore() {
        Double totalScore = 0.00;

        int days = 0;
        for (Experience e : this.getResume().getExperiencePriorityQueue()) {
            days += Duration.between(e.getDataInceput(), e.getDataSfarsit()).toDays();
        }
        int months = days / 30;
        int years = 0;
        if (months > 3 && months <= 12) years = 1;
        else if (months > 12) years = months / 12;

        totalScore = years * 1.50;

        Double medieAcademica = 0.00;
        for (Education e : this.getResume().getEducationPriorityQueue()) {
            medieAcademica += e.getMedieFinalizare();
        }
        medieAcademica /= this.getResume().getEducationPriorityQueue().size();

        totalScore += medieAcademica;

        return totalScore;
    }


    @Override
    public void update(Notification notification) {
        System.out.println(notification.toString());
    }
}
