package Fikstur;

import Fikstur.Fikstur;
import Fikstur.Team;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team(1, "Galatasaray"));
        teams.add(new Team(2, "Bursaspor"));
        teams.add(new Team(3, "Fenerbahçe"));
        teams.add(new Team(4, "Beşiktaş"));
        teams.add(new Team(5, "Başakşehir"));
        teams.add(new Team(6, "Trabzonspor"));
        teams.add(new Team(7, "Boluspor"));
        Fikstur again = new Fikstur(teams);
        again.generate();
    }
}