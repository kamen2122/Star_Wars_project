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
    public String execute(String[] args)
    {

        if(args.length < 1)
        {
            return "Usage: print <planet/jedi>";

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
            StringBuilder builder = new StringBuilder();

            builder.append("Planet: ").append(planet.getName()).append("\n");


            for(Jedi jedi : jediService.getSortedJedis(planet))
            {
                builder.append(jedi.getName()).append(" ").append(jedi.getRank()).append(" ");
                builder.append(jedi.getAge()).append(" ").append(jedi.getSaberColor()).append("\n");
            }
          return builder.toString();
        }


        /**
         * Ако не е планета, търсим джедай.
        */
        Jedi jedi = galaxy.findJediByName(name);


        if(jedi != null)
        {
            StringBuilder builder = new StringBuilder();

            Planet jediPlanet = galaxy.findPlanetByJedi(name);
            builder.append(jedi.getName()).append(" ").append(jedi.getRank()).append(" ");
            builder.append(jedi.getAge()).append(" ").append(jedi.getSaberColor()).append("\n");
            builder.append("Planet: ").append(jediPlanet.getName()).append("\n");

            return builder.toString();
        }


        return "Planet or Jedi not found.";
   }
}
