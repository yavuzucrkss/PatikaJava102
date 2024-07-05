package Fikstur;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fikstur {
    List<Team> teams;
    List<String> eRounds, dRounds;
    private static int sc = 1;

    public Fikstur(List<Team> teams) {
        this.teams = teams;
        eRounds = new ArrayList<>();
        dRounds = new ArrayList<>();
    }

    public void generate() {
        Random random = new Random();
        int half = (teams.size() * (teams.size() - 1)) / 2;
        int counter = 0;
        if (teams.size() % 2 == 0) {
            while (counter < half) {
                Team home = teams.get(random.nextInt(teams.size()));
                Team away = teams.get(random.nextInt(teams.size()));

                if (home != away && !eRounds.contains(home.getName() + " - " + away.getName()) && away.getId() != 0 && home.getId() != 0) {
                    eRounds.add(home.getName() + " - " + away.getName());
                    dRounds.add(away.getName() + " - " + home.getName());
                    counter++;
                }

            }
        } else {
            teams.add(new Team(0, "BAY"));

            while (counter < half) {
                Team home = teams.get(random.nextInt(teams.size()));
                Team away = teams.get(random.nextInt(teams.size()));

                if (home != away && !eRounds.contains(home.getName() + " - " + away.getName()) && away.getId() != 0 && home.getId() != 0) {
                    eRounds.add(home.getName() + " - " + away.getName());
                    dRounds.add(away.getName() + " - " + home.getName());
                    counter++;
                }
            }
        }
        display(eRounds);
        display(dRounds);
    }

    public void display(List<String> rounds) {

        for (int i = 0; i < rounds.size(); i++) {
            if (i % 3 == 0) {
                System.out.println("\n" + sc + ". Round: ");
                sc++;
            }

            System.out.println(rounds.get(i));
        }
    }
}