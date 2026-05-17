package StarWarsProject.commands;

import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Planet;
import StarWarsProject.service.JediService;

public class DemoteJediCommand  implements Command
{

    private JediService jediService;

    private Galaxy galaxy;


    public DemoteJediCommand(JediService jediService, Galaxy galaxy)
    {
        this.jediService = jediService;
        this.galaxy = galaxy;
    }


    @Override
    public void execute(String[] args)
    {

        if(args.length < 3)
        {
            System.out.println("Invalid command.");

            return;
        }


        String planetName = args[0];

        String jediName = args[1];

        double multiplier = Double.parseDouble(args[2]);


        Planet planet = galaxy.getPlanetByName(planetName);


        boolean demoted = jediService.demoteJedi(planet, jediName, multiplier);


        if(demoted)
        {
            System.out.println("Jedi demoted successfully.");
        }
        else
        {
            System.out.println("Could not demote Jedi.");
        }
    }
}