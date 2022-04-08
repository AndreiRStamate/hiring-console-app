package com.company;

import java.time.LocalDate;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        Vector<User> users = new Vector<>();

        Consumer.Resume.ResumeBuilder resumeBuilder = new Consumer.Resume.ResumeBuilder();

        Hashtable<String, LanguageSkill> limbi1 = new Hashtable<>();
        limbi1.put("Engleza", LanguageSkill.ADVANCED);
        limbi1.put("Franceza", LanguageSkill.BEGINNER);

        PriorityQueue<Education> educationPriorityQueue1 = new PriorityQueue<>();
        educationPriorityQueue1.add(new Education(LocalDate.of(2015, 9, 1),
                                                LocalDate.of(2019, 7, 1),
                                                "Universitate Bucuresti",
                                                NivelEducatie.MASTER,
                                    10d));

        Consumer.Resume resume1 = resumeBuilder.information(new Information("Andrei",
                                                "Stefan",
                                                    "andreistefan@gmail.com",
                                                "0747321234",
                                                    "M",
                                                        limbi1))
                .educationPriorityQueue(educationPriorityQueue1)
                .experiencePriorityQueue(new PriorityQueue<>())
                .build();

        Hashtable<String, LanguageSkill> limbi2 = new Hashtable<>();
        limbi2.put("Spaniola", LanguageSkill.EXPERIENCED);
        limbi2.put("Germana", LanguageSkill.BEGINNER);

        PriorityQueue<Education> educationPriorityQueue2 = new PriorityQueue<>();
        educationPriorityQueue2.add(new Education(LocalDate.of(2015, 9, 1),
                LocalDate.of(2019, 7, 1),
                "Universitate Politehnica",
                NivelEducatie.DOCTORAT,
                9.85d));

        Consumer.Resume resume2 = resumeBuilder.information(new Information("Marcel",
                "Mihai",
                "marcelmihai@gmail.com",
                "0732421245",
                "F",
                limbi2))
                .educationPriorityQueue(educationPriorityQueue2)
                .experiencePriorityQueue(new PriorityQueue<>())
                .build();

        Company company1 = new Company();

        User user1 = new User(resume1, null);
        User user2 = new User(resume2, null);

        users.add(user1); users.add(user2);

        Employee employee1 = new Employee("Google", 9999.99f);
        Employee employee2 = new Employee("Amazon", 9999.99f);
        Employee employee3 = new Employee("Bloomberg", 9999.99f);

        Manager manager1 = new Manager("Google", 14999.99f);
        Manager manager2 = new Manager("Bloomberg", 14999.99f);

        Recruiter recruiter1 = new Recruiter("Google", 5999.99f);
        Recruiter recruiter2 = new Recruiter("Amazon", 5999.99f);

        Job job1 = new Job();
        Job job2 = new Job();

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(job1);
        jobs.add(job2);

        Departament departament1 = DepartmentFactory.createDepartment(DepartmentType.FINANCE, employees, jobs);
        Departament departament2 = DepartmentFactory.createDepartment(DepartmentType.IT, employees, jobs);
        Departament departament3 = DepartmentFactory.createDepartment(DepartmentType.MANAGEMENT, employees, jobs);
        Departament departament4 = DepartmentFactory.createDepartment(DepartmentType.MARKETING, employees, jobs);

        Application.getInstance().add(company1);

        Application.getInstance().add(user1);
        Application.getInstance().add(user2);

        System.out.println(Application.getInstance().getCompanies());
    }
}
