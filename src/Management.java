package com.company;

import java.util.ArrayList;

public class Management extends Departament{

    public Management(ArrayList<Employee> employeeArrayList, ArrayList<Job> openJobs) {
        super(employeeArrayList, openJobs);
    }

    @Override
    public double getTotalSalaryBudget() {
        double totalSalary = 0.00;
        for (var e : getEmployees()) {
            totalSalary += e.getSalariu();
        }
        totalSalary *= 0.84; // impozit 16%
        return totalSalary;
    }
}
