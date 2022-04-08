package com.company;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static Application instance;

    private Application() {

    }

    public static Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }
        return instance;
    }

    private ArrayList<Company> companyList = new ArrayList<>();
    private ArrayList<User> userList = new ArrayList<>();

    public ArrayList<Company> getCompanies() {
        return companyList;
    }

    public Company getCompany(String name) {
        for (Company c : companyList) {
            if (c.getNume().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public void add(Company company) {
        companyList.add(company);
    }

    public void add(User user) {
        userList.add(user);
    }

    public boolean remove(Company company) {
        for (Company c : companyList) {
            if (c == company) {
                companyList.remove(c);
                return true;
            }
        }
        return false;
    }

    public boolean remove(User user) {
        for (User u : userList) {
            if (u == user) {
                userList.remove(u);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Job> getJobs(List<String> companies) {
        ArrayList<Job> jobs = new ArrayList<>();
        for (var c : companies) {
            jobs.addAll(getCompany(c).getJobs());
        }
        /*
        for (var u : userList) {
            for (var c : u.getCompanies()) {
                jobs.addAll(getCompany(c).getJobs());
            }
        }

         */
        return jobs;
    }

}
