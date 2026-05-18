package StarWarsProject.commands;

import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Planet;
import StarWarsProject.service.JediService;

public class CreateJediCommand
        implements Command
{

    private JediService jediService;

    private Galaxy galaxy;


    public CreateJediCommand(JediService jediService, Galaxy galaxy)
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
            System.out.println("Usage: create_jedi <planet> <name> <rank> <age> <color> <strength>");

            return;
        }


        String planetName = args[0];

        String jediName = args[1];

        String rank = args[2];



        String color = args[4];
        int age;
        int strength;

        try
        {
            age = Integer.parseInt(args[3]);

            strength = Integer.parseInt(args[5]);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Invalid age or strength.");

            return;
        }


        /*
         Търсим планетата.
        */
        Planet planet = galaxy.getPlanetByName(planetName);
        if(planet == null)
        {
            System.out.println("Planet not found.");

            return;
        }


        boolean added = jediService.addJedi(planet, jediName, rank, age,
                        color, strength);


        if(added)
        {
            System.out.println("Jedi created successfully.");
        }
        else
        {
            System.out.println("Could not create Jedi.");
        }
    }
}