package StarWarsProject.commands;

import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Jedi;
import StarWarsProject.model.Planet;
import StarWarsProject.service.JediService;

public class PrintJedisCommand
        implements Command
{

    private JediService jediService;

    private Galaxy galaxy;


    public PrintJedisCommand
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


        if(planet == null)
        {
            System.out.println("Planet not found.");

            return;
        }


        for(Jedi jedi : planet.getJedis())
        {
            System.out.println(jedi);
        }
    }
}