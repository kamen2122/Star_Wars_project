package StarWarsProject.commands;

import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Jedi;
import StarWarsProject.model.Planet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * Команда за <извждане на екран в сортиран вид>.
 */
public class MergePlanetsCommand implements Command
{

    private Galaxy galaxy;


    public MergePlanetsCommand(Galaxy galaxy)
    {
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
         * planet1 + planet2
        */

        if(args.length < 2)
        {
            return "Usage: <planet1> + <planet2>";


        }


        Planet firstPlanet = galaxy.getPlanetByName(args[0]);

        Planet secondPlanet = galaxy.getPlanetByName(args[1]);


        if(firstPlanet == null || secondPlanet == null)
        {
            return "Planet not found.";

        }


        /**
         * Обединяваме джедаите.
        */
        List<Jedi> jedis = new ArrayList<>();


        jedis.addAll(firstPlanet.getJedis());

        jedis.addAll(secondPlanet.getJedis());


        /**
         * Лексикографски начин на сортиране.
        */
        jedis.sort(Comparator.comparing(Jedi::getName));

        StringBuilder builder = new StringBuilder();

        for(Jedi jedi : jedis)
        {

            builder.append(jedi.getName()).append(" ").append(jedi.getRank()).append(" ");
            builder.append(jedi.getAge()).append(" ").append(jedi.getSaberColor()).append("\n");

        }
        return builder.toString();
    }
}