package StarWarsProject.commands;

import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Jedi;
import StarWarsProject.model.Planet;
import StarWarsProject.service.JediService;
/**
 * Команда за <търсене на най силния джедай>.
 */
public class StrongestJediCommand implements Command
{

    private JediService jediService;

    private Galaxy galaxy;


    public StrongestJediCommand(JediService jediService, Galaxy galaxy)
    {
        this.jediService = jediService;
        this.galaxy = galaxy;
    }
    /**
     * Изпълнява логиката на командата.
     *
     * @param args аргументи на командата
     */

    @Override
    public String execute(String[] args)
    {

        if(args.length < 1)
        {
            return "Usage: get_strongest_jedi <planet>";


        }


        String planetName = args[0];


        Planet planet = galaxy.getPlanetByName(planetName);

        if(planet == null)
        {
            return "Planet not found.";


        }
        Jedi strongest = jediService.getStrongestJedi(planet);


        if(strongest == null)
        {
            return "No Jedi found.";


        }


       return strongest.toString();
    }
}
