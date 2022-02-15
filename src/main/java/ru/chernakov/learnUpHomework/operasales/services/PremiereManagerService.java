package ru.chernakov.learnUpHomework.operasales.services;

import org.springframework.stereotype.Service;
import ru.chernakov.learnUpHomework.operasales.entity.Premiere;
import ru.chernakov.learnUpHomework.operasales.entity.Ticket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PremiereManagerService {

    private Map<String, Premiere> premiereMap = new HashMap<>();

    public Map<String, Premiere> getPremiereMap() {
        return premiereMap;
    }

    public void addPremiere() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = null;
        LocalDateTime time = null;
        String description = null;
        Integer minimumAge = null;
        Integer ticketsAvailable = null;

        try {
            System.out.println("Введите название премьеры");
            name = reader.readLine().toUpperCase();
            System.out.println("Введите дату и время в формате dd-MM-yyyy H:m");
            time = LocalDateTime.parse(reader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy H:m"));
            System.out.println("Введите описание премьеры");
            description = reader.readLine();
            System.out.println("Введите возрастное ограничение цифрами");
            minimumAge = Integer.parseInt(reader.readLine());
            System.out.println("Укажите количество мест в зале цифрами");
            ticketsAvailable = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Premiere premiere = new Premiere(name, time, description, minimumAge, ticketsAvailable);
        premiereMap.put(premiere.getName(), premiere);
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPremiere(String name, String timeString, String description, int minimumAge, int ticketsAvailable) {
        LocalDateTime time = LocalDateTime.parse(timeString, DateTimeFormatter.ofPattern("dd-MM-yyyy H:m"));
        Premiere premiere = new Premiere(name, time, description, minimumAge, ticketsAvailable);
        premiereMap.put(premiere.getName(), premiere);
    }

    public List<Ticket> getBoughtTicketsOn(String name) {
        return premiereMap.get(name.toUpperCase()).getTickets();
    }
}
