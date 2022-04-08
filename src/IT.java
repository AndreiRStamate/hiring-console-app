package com.company;

import java.util.ArrayList;

public class IT extends Departament{

    public IT(ArrayList<Employee> employeeArrayList, ArrayList<Job> openJobs) {
        super(employeeArrayList, openJobs);
    }

    @Override
    public double getTotalSalaryBudget() {
        double totalSalary = 0.00;
        for (var e : getEmployees()) {
            totalSalary += e.getSalariu();
        }
        return totalSalary;
    }
}
