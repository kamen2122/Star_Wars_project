package StarWarsProject.commands;

import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Planet;
import StarWarsProject.service.JediService;

public class CreateJediCommand
        implements Command
{

    private JediService jediService;

    private Galaxy galaxy;


    public CreateJediCommand
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
         Очакваме:

         create_jedi
         planetName
         jediName
         rank
         age
         color
         strength
        */

        if(args.length < 6)
        {
            System.out.println("Invalid command.");

            return;
        }


        String planetName = args[0];

        String jediName = args[1];

        String rank = args[2];

        int age = Integer.parseInt(args[3]);

        String color = args[4];

        double strength =
                Double.parseDouble(args[5]);


        /*
         Търсим планетата.
        */
        Planet planet =
                galaxy.getPlanetByName(planetName);


        boolean added =
                jediService.addJedi(
                        planet,
                        jediName,
                        rank,
                        age,
                        color,
                        strength
                );


        if(added)
        {
            System.out.println(
                    "Jedi created successfully."
            );
        }
        else
        {
            System.out.println(
                    "Could not create Jedi."
            );
        }
    }
}