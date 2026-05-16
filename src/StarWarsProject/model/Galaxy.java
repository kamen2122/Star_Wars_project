package StarWarsProject.model;
import java.util.ArrayList;
import java.util.List;

public class Galaxy {

   // Списък с всички планети в галактиката.

    private List<Planet> planets = new ArrayList<>();

    public void addPlanet(Planet planet)
    {
        planets.add(planet);
    }

    public List<Planet> getPlanets()
    {
        return planets;
    }
    /*
    Търси планета по име.
    Ако я намери -> връща Planet
    Ако не -> връща null*/

    public Planet getPlanetByName(String name)
    {
        for(Planet planet : planets)
        {
            if(planet.getName().equalsIgnoreCase(name))
            {
                return planet;
            }
        }

        return null;
    }
    /*
     Проверява дали съществува планета.
    */
    public boolean planetExists(String name)
    {
        return getPlanetByName(name) != null;
    }
}
