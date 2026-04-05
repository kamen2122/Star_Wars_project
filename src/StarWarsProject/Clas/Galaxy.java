package StarWarsProject.Clas;
import java.util.ArrayList;
import java.util.List;

public class Galaxy {

    private List<Planet> planets = new ArrayList<>();

    public void addPlanet(Planet planet)
    {
        planets.add(planet);
    }

    public List<Planet> getPlanets()
    {
        return planets;
    }
}
