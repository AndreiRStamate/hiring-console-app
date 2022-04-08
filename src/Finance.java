package com.company;

import java.time.Duration;
import java.util.ArrayList;

public class Finance extends Departament{

    public Finance(ArrayList<Employee> employeeArrayList, ArrayList<Job> openJobs) {
        super(employeeArrayList, openJobs);
    }

    @Override
    public double getTotalSalaryBudget() {
        double totalSalary = 0.00;
        for (var e : getEmployees()) {
            var aux = e.getSalariu();
            if (
                    Duration.between(e.getResume().getExperiencePriorityQueue().peek().getDataInceput(),
                                    e.getResume().getExperiencePriorityQueue().peek().getDataSfarsit())
                                    .toDays() < 366){
                aux *= 0.90f; // impozit 10%
            }
            else{
                aux *= 0.84f; // impozit 16
            }

            totalSalary += aux;
        }
        return totalSalary;

    }
}
