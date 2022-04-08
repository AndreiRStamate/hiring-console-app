package com.company;

import java.util.ArrayList;

public class Marketing extends Departament{

    public Marketing(ArrayList<Employee> employeeArrayList, ArrayList<Job> openJobs) {
        super(employeeArrayList, openJobs);
    }

    @Override
    public double getTotalSalaryBudget() {
        double totalSalary = 0.00;
        for (var e : getEmployees()) {
            var aux = e.getSalariu();
            if (aux > 5000) {
                aux *= 0.90f; // impozit 10%
            }
            else if (aux < 3000) {
                aux = aux; // fara impozit
            }
            else {
                aux *= 0.84f; // impozit 16
            }
            totalSalary += aux;
        }
        return totalSalary;

    }
}
