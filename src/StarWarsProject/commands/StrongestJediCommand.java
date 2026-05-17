package StarWarsProject.commands;

import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Jedi;
import StarWarsProject.model.Planet;
import StarWarsProject.service.JediService;

public class StrongestJediCommand implements Command
{

    private JediService jediService;

    private Galaxy galaxy;


    public StrongestJediCommand
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

        if(args.length < 1)
        {
            System.out.println("Invalid command.");

            return;
        }


        String planetName = args[0];


        Planet planet = galaxy.getPlanetByName(planetName);


        Jedi strongest = jediService.getStrongestJedi(planet);


        if(strongest == null)
        {
            System.out.println("No Jedi found.");

            return;
        }


        System.out.println(strongest);
    }
}
