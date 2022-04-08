package com.company;

import java.util.ArrayList;

public abstract class Departament{

    private ArrayList<Employee> employeeArrayList;
    private ArrayList<Job> openJobs;

    public Departament(ArrayList<Employee> employeeArrayList, ArrayList<Job> openJobs) {
        this.employeeArrayList = employeeArrayList;
        this.openJobs = openJobs;
    }

    public abstract double getTotalSalaryBudget();

    public ArrayList<Job> getJobs(){
        ArrayList<Job> jobs = new ArrayList<>();

        for (var v : openJobs) {
            if (v.isValabil()) {
                jobs.add(v);
            }
        }
        return jobs;
    }

    public void add(Employee employee){
        employeeArrayList.add(employee);
    }

    public void remove(Employee employee){
        employeeArrayList.remove(employee);
    }

    public void add(Job job){
        openJobs.add(job);
    }

    public ArrayList<Employee> getEmployees(){
        return employeeArrayList;
    }

    public ArrayList<Job> getOpenJobs() {
        return openJobs;
    }
}

enum DepartmentType {
    IT,
    MANAGEMENT,
    MARKETING,
    FINANCE
}

class DepartmentFactory {
    public static Departament createDepartment(DepartmentType departmentType,
                                               ArrayList<Employee> employeeArrayList,
                                               ArrayList<Job> openJobs) {
        return switch (departmentType) {
            case IT -> new IT(employeeArrayList, openJobs);
            case MANAGEMENT -> new Management(employeeArrayList, openJobs);
            case MARKETING -> new Marketing(employeeArrayList, openJobs);
            case FINANCE -> new Finance(employeeArrayList, openJobs);
        };
    }
}