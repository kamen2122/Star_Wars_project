package StarWarsProject.service;

import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Planet;

public class PlanetService {

    /*
    Добавя планета в галактиката.
   */
    public boolean addPlanet(Galaxy galaxy, String planetName)
    {

        // Проверка дали планетата вече съществува
        if(galaxy.planetExists(planetName))
        {
            return false;
        }

        // Създаваме нова планета
        Planet planet = new Planet(planetName);

        // Добавяме я в галактиката
        galaxy.addPlanet(planet);

        return true;
    }
}
