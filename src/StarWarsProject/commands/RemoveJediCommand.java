package StarWarsProject.commands;

import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Planet;
import StarWarsProject.service.JediService;

public class RemoveJediCommand
        implements Command
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


    @Override
    public void execute(String[] args)
    {

        /*
         remove_jedi
         planetName
         jediName
        */

        if(args.length < 2)
        {
            System.out.println("Usage: removeJedi <planet> <jedi>");

            return;
        }


        String planetName = args[0];

        String jediName = args[1];


        Planet planet = galaxy.getPlanetByName(planetName);
        if(planet == null)
        {
            System.out.println("Planet not found.");

            return;
        }


        boolean removed = jediService.removeJedi(planet, jediName);


        if(removed)
        {
            System.out.println("Jedi removed successfully.");
        }
        else
        {
            System.out.println("Could not remove Jedi.");
        }
    }
}
