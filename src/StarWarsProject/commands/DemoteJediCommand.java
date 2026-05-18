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
            System.out.println("Usage: demote_jedi <planet> <jedi> <multiplier>");

            return;
        }


        String planetName = args[0];

        String jediName = args[1];
        double multiplier;

        try
        {
            multiplier = Double.parseDouble(args[2]);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Invalid multiplier.");

            return;
        }


        Planet planet = galaxy.getPlanetByName(planetName);
        if(planet == null)
        {
            System.out.println("Planet not found.");

            return;
        }


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