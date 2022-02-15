package ru.chernakov.learnUpHomework.operasales.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chernakov.learnUpHomework.operasales.NoTicketsException;
import ru.chernakov.learnUpHomework.operasales.entity.Premiere;
import ru.chernakov.learnUpHomework.operasales.entity.Ticket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    public BookingService(PremiereManagerService premiereManagerService) {
        this.premiereManagerService = premiereManagerService;
    }

    @Autowired
    private final PremiereManagerService premiereManagerService;

    public void showPremiere() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String premiereName = null;
        System.out.println("Введите название представления");
        try {
            premiereName = reader.readLine().toUpperCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(premiereManagerService.getPremiereMap().get(premiereName));
    }

    public void showAllPremieres() {
        List<Premiere> premieres = new ArrayList<>(premiereManagerService.getPremiereMap().values());
        for (Premiere premiere : premieres) {
            System.out.println(premiere);
        }

    }

    public Ticket buyTicket() {
        System.out.println("Введите название представления");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = null;
        try {
            name = reader.readLine().toUpperCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Premiere premiere = premiereManagerService.getPremiereMap().get(name);
        if (premiere.getTicketsAvailable() <= 0) {
            try {
                throw new NoTicketsException("К сожалению, билеты закончились, приобретение невозможно");
            } catch (NoTicketsException e) {
                System.out.println(e.getMessage());
            }
        }
        String ticketText = (premiere.getName() + "\n" + premiere.getTime() + "\n" + premiere.getDescription());
        Ticket ticket = new Ticket(premiere, ticketText);
        premiere.addTicket(ticket);
        premiereManagerService.getPremiereMap()
                .get(name)
                .setTicketsAvailable(premiereManagerService
                        .getPremiereMap()
                        .get(name)
                        .getTicketsAvailable() - 1);
        System.out.println("Билет приобретен успешно");
        return ticket;
    }
}
