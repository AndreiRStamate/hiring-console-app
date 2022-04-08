package com.company;

public class Notification {
    private String notificare;

    public Notification(String notificare) {
        this.notificare = notificare;
    }

    public String getNotificare() {
        return notificare;
    }

    public void setNotificare(String notificare) {
        this.notificare = notificare;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificare='" + notificare + '\'' +
                '}';
    }
}