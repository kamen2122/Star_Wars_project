package StarWarsProject.commands;

import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Planet;
import StarWarsProject.service.JediService;
/**
 * Команда за <премахване на джедай>.
 */
public class RemoveJediCommand implements Command
{

    private JediService jediService;

    private Galaxy galaxy;


    public RemoveJediCommand
            (
                    JediService jediService,
                    Galaxy galaxy
            )
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



        if(args.length < 2)
        {
            return "Usage: removeJedi <planet> <jedi>";


        }


        String planetName = args[0];

        String jediName = args[1];


        Planet planet = galaxy.getPlanetByName(planetName);
        if(planet == null)
        {
            return "Planet not found.";


        }


        boolean removed = jediService.removeJedi(planet, jediName);


        if(removed)
        {
            return "Jedi removed successfully.";
        }
        else
        {
            return "Could not remove Jedi.";
        }
    }
}
