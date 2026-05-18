package StarWarsProject.commands;

import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Planet;
import StarWarsProject.service.JediService;
/**
 * Команда за <за най използван цвят за меч>.
 */
public class MostUsedSaberColorCommand implements Command
{

    private JediService jediService;

    private Galaxy galaxy;


    public MostUsedSaberColorCommand(JediService jediService, Galaxy galaxy)
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

        /**
         * get_most_used_saber_color <planet>
        */

        if(args.length < 1)
        {
            return "Usage: get_most_used_saber_color <planet>";

        }


        String planetName = args[0];


        Planet planet = galaxy.getPlanetByName(planetName);


        if(planet == null)
        {
            return "Planet not found.";


        }


        String color = jediService.getMostUsedSaberColor(planet);


        if(color == null)
        {
           return "No Jedi found.";


        }


        return "Most used saber color: " + color;
    }
}