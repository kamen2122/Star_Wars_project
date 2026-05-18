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
    public String execute(String[] args)
    {


        if(args.length < 3)
        {
            return "Usage: promote_jedi <planet> <jedi> <multiplier>";


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
            return "Invalid multiplier.";


        }

        Planet planet = galaxy.getPlanetByName(planetName);
        if(planet == null)
        {
            return "Planet not found.";

        }

        boolean promoted = jediService.promoteJedi(planet, jediName, multiplier);


        if(promoted)
        {
            return "Jedi promoted successfully.";
        }
        else
        {
            return "Could not promote Jedi.";
        }
    }
}
