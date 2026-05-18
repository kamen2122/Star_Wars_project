package StarWarsProject.commands;

import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Jedi;
import StarWarsProject.model.Planet;
import StarWarsProject.service.JediService;
/**
 * Команда за <изкарване на екран по планета или джедай>.
 */

public class PrintCommand implements Command{
    private Galaxy galaxy;

    private JediService jediService;


    public PrintCommand
            (Galaxy galaxy, JediService jediService)
    {
        this.galaxy = galaxy;
        this.jediService = jediService;
    }
    /**
     * Изпълнява логиката на командата.
     *
     * @param args аргументи на командата
     */

    @Override
    public void execute(String[] args)
    {

        if(args.length < 1)
        {
            System.out.println("Usage: print <planet/jedi>");

            return;
        }


        String name = args[0];


        /**
         * Първо проверяваме дали е планета.
        */
        Planet planet = galaxy.getPlanetByName(name);


        /**
         * Ако е планета.
        */
        if(planet != null)
        {

            System.out.println("Planet: " + planet.getName());


            for(Jedi jedi : jediService.getSortedJedis(planet))
            {
                System.out.println(jedi);
            }

            return;
        }


        /**
         * Ако не е планета, търсим джедай.
        */
        Jedi jedi = galaxy.findJediByName(name);


        if(jedi != null)
        {

            Planet jediPlanet = galaxy.findPlanetByJedi(name);


            System.out.println(jedi);

            System.out.println("Planet: " + jediPlanet.getName());

            return;
        }


        System.out.println("Planet or Jedi not found.");
   }
}
