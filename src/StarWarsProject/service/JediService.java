package StarWarsProject.service;

import StarWarsProject.Clas.Jedi;
import StarWarsProject.Clas.Planet;
import StarWarsProject.Enums.Rank;

public class JediService {
    public void addJedi(Planet planet, String name, String rankStr, int age, String color, int strength)
    {
        Rank rank = Rank.valueOf(rankStr);

        Jedi jedi = new Jedi(name, rank, age, color, strength);

        planet.addJedi(jedi);

        System.out.println("Jedi added: " + name);
    }
}
