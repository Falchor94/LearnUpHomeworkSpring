package ru.chernakov.learnUpHomework.operasales.entity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Premiere {

    private String name;
    private LocalDateTime time;
    private String description;
    private int minimumAge;
    private int ticketsAvailable;
    private List<Ticket> tickets = new ArrayList<>();

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public Premiere(String name, LocalDateTime time, String description, int minimumAge, int ticketsAvailable) {
        this.name = name;
        this.time = time;
        this.description = description;
        this.minimumAge = minimumAge;
        this.ticketsAvailable = ticketsAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public int getTicketsAvailable() {
        return ticketsAvailable;
    }

    public void setTicketsAvailable(int ticketsAvailable) {
        this.ticketsAvailable = ticketsAvailable;
    }

    @Override
    public String toString() {
        return "-------------------------------------\n" +
                name + "\n" +
                "Когда: " + time + "\n" +
                "Описание: " + description + "\n" +
                minimumAge + "+" + "\n" +
                "Осталось билетов: " + ticketsAvailable;
    }
}
