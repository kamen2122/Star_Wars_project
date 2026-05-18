package StarWarsProject.commands;

import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Planet;
import StarWarsProject.service.JediService;
/**
 * Команда за <намаляне на ранг>.
 */
public class DemoteJediCommand  implements Command
{

    private JediService jediService;

    private Galaxy galaxy;


    public DemoteJediCommand(JediService jediService, Galaxy galaxy)
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
            return"Usage: demote_jedi <planet> <jedi> <multiplier>";


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
            return"Invalid multiplier.";


        }


        Planet planet = galaxy.getPlanetByName(planetName);
        if(planet == null)
        {
            return"Planet not found.";


        }


        boolean demoted = jediService.demoteJedi(planet, jediName, multiplier);


        if(demoted)
        {
           return "Jedi demoted successfully.";
        }
        else
        {
            return "Could not demote Jedi.";
        }
    }
}