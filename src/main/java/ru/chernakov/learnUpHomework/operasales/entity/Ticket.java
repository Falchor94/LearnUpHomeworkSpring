package ru.chernakov.learnUpHomework.operasales.entity;

public class Ticket {

    private Premiere premiere;
    private final int id = this.hashCode();
    private String ticketText;

    public Ticket(Premiere premiere, String ticketText) {
        this.premiere = premiere;
        this.ticketText = ticketText;
    }

    public Premiere getPremiere() {
        return premiere;
    }

    public void setPremiere(Premiere premiere) {
        this.premiere = premiere;
    }

    public String getTicketText() {
        return ticketText;
    }

    public void setTicketText(String ticketText) {
        this.ticketText = ticketText;
    }

    @Override
    public String toString() {
        return "-----------------------------\n" +
                "БИЛЕТ\n" +
                id + "\n" +
                ticketText;
    }
}
