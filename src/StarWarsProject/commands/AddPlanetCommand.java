package StarWarsProject.commands;

import StarWarsProject.model.Galaxy;
import StarWarsProject.service.PlanetService;
/**
 * Команда за <добавяне на планета>.
 */
public class AddPlanetCommand implements Command{
    private PlanetService planetService;

    private Galaxy galaxy;


    public AddPlanetCommand(PlanetService planetService, Galaxy galaxy)
    {
        this.planetService = planetService;
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

        /**
         * args[0] ще е името
         * на планетата.
        */

        if(args.length < 1)
        {


            return "Usage: add_planet <planet>";
        }


        boolean added = planetService.addPlanet( galaxy, args[0] );


        if(added)
        {
           return "Planet added successfully.";
        }
        else
        {
            return "Planet already exists.";
        }
    }
}
