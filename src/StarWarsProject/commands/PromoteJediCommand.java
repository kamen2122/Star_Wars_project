package StarWarsProject.commands;

import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Planet;
import StarWarsProject.service.JediService;
/**
 * Команда за <увеличаване на ранг>.
 */
public class PromoteJediCommand  implements Command
{

    private JediService jediService;

    private Galaxy galaxy;


    public PromoteJediCommand(JediService jediService, Galaxy galaxy)
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
    public void execute(String[] args)
    {


        if(args.length < 3)
        {
            System.out.println("Usage: promote_jedi <planet> <jedi> <multiplier>");

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
