package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Company implements ISubject{

    private ArrayList<User> observers = null;

    private String nume;
    private Manager manager;

    private ArrayList<Departament> departamentArrayList;
    private ArrayList<Recruiter> recruiterArrayList;

    public void add(Departament departament) {
        departamentArrayList.add(departament);
    }

    public void add(Recruiter recruiter) {
        recruiterArrayList.add(recruiter);
    }

    public void add(Employee employee, Departament departament) {
        departament.add(employee);
    }

    public void remove(Employee employee) {
        for (var v : departamentArrayList) {
            v.getEmployees().removeIf(e -> e.equals(employee));
            /*
            for (var e : v.getEmployees()) {
                if (e.equals(employee)) {
                    v.getEmployees().remove(e);
                }
            }
             */
            return;
        }
    }

    public void remove(Departament departament) {
        for (var v : departament.getEmployees()) {
            departament.getEmployees().remove(v);
        }
        departamentArrayList.remove(departament);
    }

    public void remove(Recruiter recruiter) {
        recruiterArrayList.remove(recruiter);
    }

    public void move(Departament source, Departament destination) {
        for (var e : source.getEmployees()) {
            destination.add(e);
        }
        /*
        for (var j : source.getOpenJobs()) {
            destination.add(j);
        }
         */
        source.getEmployees().clear();
        //source.getJobs().clear();
    }

    public void move(Employee employee, Departament newDepartament) {
        for (var d : departamentArrayList) {
            for (var e : d.getEmployees()) {
                if (e.equals(employee)) {
                    newDepartament.add(e);
                    d.remove(e);
                    return;
                }
            }
        }
    }

    public boolean contains(Departament departament) {
        return departamentArrayList.contains(departament);
    }

    public boolean contains(Employee employee) {
        for (var d : departamentArrayList) {
            if (d.getEmployees().contains(employee)) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(Recruiter recruiter) {
        return  recruiterArrayList.contains(recruiter);
    }

    public Recruiter getRecruiter(User user) {
        for (var r : recruiterArrayList) {
            return r;
        }
        return new Recruiter(this.nume, 0.00f);
    }

    public ArrayList<Job> getJobs(){
        ArrayList<Job> jobs = new ArrayList<>();

        for (var d : departamentArrayList) {
            jobs.addAll(d.getJobs());
        }
        return jobs;
    }

    public String getNume() {
        return nume;
    }

    @Override
    public void addObserver(User user) {
        if (observers == null) {
            observers = new ArrayList<>();
        }
        observers.add(user);
    }

    @Override
    public void removeObserver(User c) {
        observers.remove(c);
    }

    @Override
    public void notifyAllObservers() {
        for (User o : observers) {
            o.update(new Notification("Angajare finalizata la compania: " + nume));
        }
    }
}
