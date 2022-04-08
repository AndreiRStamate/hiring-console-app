package com.company;

import java.time.LocalDate;
import java.util.List;
import java.util.PriorityQueue;

public abstract class Consumer {

    private Resume resume;
    private List<Consumer> listaCunoscuti;

    public Consumer(Resume resume, List<Consumer> listaCunoscuti) {
        this.resume = resume;
        this.listaCunoscuti = listaCunoscuti;
    }

    public Consumer() {
        
    }

    public Resume getResume() {
        return resume;
    }

    public void add(Education education) {

    }

    public void add(Experience experience) {

    }

    public void add(Consumer consumer) {
        listaCunoscuti.add(consumer);
    }

    public int getDegreeInFriendship(Consumer consumer) {
        return -1;
    }

    public void remove(Consumer consumer) {

    }

    public Integer getGraduationYear() {
        return -2020;
    }

    public Double meanGPA() {
        return -1.00;
    }

    static class Resume {
        private Information information;
        private PriorityQueue<Education> educationPriorityQueue;
        private PriorityQueue<Experience> experiencePriorityQueue;

        private static void validate (Information information) throws ResumeIncompleteException{
            if (information == null) {
                throw new ResumeIncompleteException("Informatii lipsa");
            }
        }

        private static void validate (PriorityQueue<Education> educationPriorityQueue) throws ResumeIncompleteException{
            if (educationPriorityQueue.size() < 1) {
                throw new ResumeIncompleteException("Prea putine studii");
            }
        }

        private Resume(ResumeBuilder resumeBuilder) {
            try {
                validate(resumeBuilder.information);
                validate(resumeBuilder.educationPriorityQueue);
            } catch (ResumeIncompleteException e) {
                e.printStackTrace();
            }
        }

        public Information getInformation() {
            return information;
        }

        public PriorityQueue<Education> getEducationPriorityQueue() {
            return educationPriorityQueue;
        }

        public PriorityQueue<Experience> getExperiencePriorityQueue() {
            return experiencePriorityQueue;
        }

        public static class ResumeBuilder {
            private Information information = null;
            private PriorityQueue<Education> educationPriorityQueue = null;
            private PriorityQueue<Experience> experiencePriorityQueue = null;

            public ResumeBuilder() {

            }

            public ResumeBuilder information(Information information) {
                this.information = information;
                return this;
            }

            public ResumeBuilder educationPriorityQueue(PriorityQueue<Education> educationPriorityQueue) {
                this.educationPriorityQueue = educationPriorityQueue;
                return this;
            }

            public ResumeBuilder experiencePriorityQueue(PriorityQueue<Experience> experiencePriorityQueue) {
                this.experiencePriorityQueue = experiencePriorityQueue;
                return this;
            }

            public Resume build() {
                return new Resume(this);
            }
        }
    }
}

