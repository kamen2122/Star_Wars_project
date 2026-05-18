package StarWarsProject.commands;

import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Planet;
import StarWarsProject.service.JediService;
/**
 * Команда за <създаване на джедай>.
 */
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


    /**
     * Изпълнява логиката на командата.
     *
     * @param args аргументи на командата
     */
    @Override
    public String execute(String[] args)
    {



        if(args.length < 6)
        {
            return"Usage: create_jedi <planet> <name> <rank> <age> <color> <strength>";


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
            return"Invalid age or strength.";


        }


        /**
         * Търсим планетата.
        */
        Planet planet = galaxy.getPlanetByName(planetName);
        if(planet == null)
        {
            return "Planet not found.";


        }


        boolean added = jediService.addJedi(planet, jediName, rank, age,
                        color, strength);


        if(added)
        {
            return"Jedi created successfully.";
        }
        else
        {
            return "Could not create Jedi.";
        }
    }
}