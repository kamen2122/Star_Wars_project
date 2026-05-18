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
    public void execute(String[] args)
    {

        /**
         * get_most_used_saber_color <planet>
        */

        if(args.length < 1)
        {
            System.out.println("Usage: get_most_used_saber_color <planet>");

            return;
        }


        String planetName = args[0];


        Planet planet = galaxy.getPlanetByName(planetName);


        if(planet == null)
        {
            System.out.println("Planet not found.");

            return;
        }


        String color = jediService.getMostUsedSaberColor(planet);


        if(color == null)
        {
            System.out.println("No Jedi found.");

            return;
        }


        System.out.println("Most used saber color: " + color);
    }
}