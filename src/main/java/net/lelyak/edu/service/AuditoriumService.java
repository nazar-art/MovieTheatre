package net.lelyak.edu.service;

import net.lelyak.edu.entity.Auditorium;
import net.lelyak.edu.repository.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * AuditoriumService - Returns info about auditoriums and places
 *
 * Since auditorium information is usually static, store it in some property file. The information that needs to be stored is:
 * name
 * number of seats
 * vip seats (comma-separated list of expensive seats)
 * Several auditoriums can be stored in separate property files, information from them could be injected into the AuditoriumService
 *
 * getAuditoriums(), getSeatsNumber(), getVip()
 */
@Service
public class AuditoriumService {

//    private List<Auditorium> auditoriums;

    @Autowired
    private AuditoriumRepository auditoriumRepository;

    private Random random = new Random();

    /*@Autowired
    public AuditoriumService(List<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    public List<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public int getSeatsNumber(Auditorium auditorium) {
        return auditorium.getSeats();
    }

    public Set<Integer> getVipSeats(Auditorium auditorium) {
        return auditorium.getVip();
    }*/

    public List<Auditorium> getAuditoriums() {
        ArrayList<Auditorium> auditoriums = new ArrayList<>();
        auditoriums.addAll(this.auditoriumRepository.getAll());
        return auditoriums;
    }

    public int getSeatsNumber(Auditorium auditorium) {
        return auditorium.getSeats();
//        return -1;
    }

    public /*Set<Integer>*/String getVipSeats(Auditorium auditorium) {
        return auditorium.getVip();
    }

    public Auditorium getRandomAuditorium() {
        return auditoriumRepository.getById(1 + random.nextInt(3));
    }
}
