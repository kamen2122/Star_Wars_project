package StarWarsProject.commands;

import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Planet;
import StarWarsProject.service.JediService;

public class PromoteJediCommand  implements Command
{

    private JediService jediService;

    private Galaxy galaxy;


    public PromoteJediCommand
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
         promote_jedi
         planetName
         jediName
         multiplier
        */

        if(args.length < 3)
        {
            System.out.println("Invalid command.");

            return;
        }


        String planetName = args[0];

        String jediName = args[1];

        double multiplier = Double.parseDouble(args[2]);


        Planet planet = galaxy.getPlanetByName(planetName);


        boolean promoted = jediService.promoteJedi(planet, jediName, multiplier);


        if(promoted)
        {
            System.out.println("Jedi promoted successfully.");
        }
        else
        {
            System.out.println("Could not promote Jedi.");
        }
    }
}
