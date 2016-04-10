package net.lelyak.edu.tests.util;

import net.lelyak.edu.entity.Event;
import net.lelyak.edu.entity.enums.Rating;
import net.lelyak.edu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
public class RandomTestObjectsGenerator {

    @Autowired
    private RandomDate randomDate;

    @Autowired
    private RandomString randomString;

    private Random random = new Random();

    public Date getRandomDate() {
        return randomDate.get();
    }

    public String getRandomWord() {
        return randomString.getWord();
    }

    public String getRandomSentence() {
        return randomString.getSentence();
    }

    public Event randomEvent() {
        Event event = new Event();
        event.setAirDate(randomDate.get());
        event.setName(randomString.getWord());
        event.setTicketPrice(random.nextDouble());
        event.setEnumRating(Rating.values()[random.nextInt(3)]);

        return event;
    }

    public List<Event> randomEventsList(int count) {
        List<Event> testEvents = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            testEvents.add(randomEvent());
        }
        return testEvents;
    }

    public User randomUser() {
        User user = new User();
        user.setBirthday(randomDate.get());
        user.setName(randomString.getUCWord());
        user.setEmail(randomString.getWord().trim().concat("@").concat(randomString.getWord().trim()));

        return user;
    }

    public List<User> randomUserList(int count) {
        List<User> testUsers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            testUsers.add(randomUser());
        }
        return testUsers;
    }

    public int nextInt() {
        return random.nextInt();
    }

    public int nextInt(int bound) {
        return random.nextInt(bound);
    }

    public long nextLong() {
        return random.nextLong();
    }

}
