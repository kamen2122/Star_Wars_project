package StarWarsProject.commands;

import StarWarsProject.model.Galaxy;
import StarWarsProject.service.PlanetService;

public class AddPlanetCommand implements Command{
    private PlanetService planetService;

    private Galaxy galaxy;


    public AddPlanetCommand
            (
                    PlanetService planetService,
                    Galaxy galaxy
            )
    {
        this.planetService = planetService;
        this.galaxy = galaxy;
    }


    @Override
    public void execute(String[] args)
    {

        /*
         args[0] ще е името
         на планетата.
        */

        if(args.length < 1)
        {
            System.out.println("Invalid command.");

            return;
        }


        boolean added = planetService.addPlanet( galaxy, args[0] );


        if(added)
        {
            System.out.println("Planet added successfully.");
        }
        else
        {
            System.out.println("Planet already exists.");
        }
    }
}
