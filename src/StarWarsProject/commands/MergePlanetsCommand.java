package StarWarsProject.commands;

import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Jedi;
import StarWarsProject.model.Planet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergePlanetsCommand implements Command
{

    private Galaxy galaxy;


    public MergePlanetsCommand(Galaxy galaxy)
    {
        this.galaxy = galaxy;
    }


    @Override
    public void execute(String[] args)
    {

        /*
         planet1 + planet2
        */

        if(args.length < 2)
        {
            System.out.println("Usage: <planet1> + <planet2>");

            return;
        }


        Planet firstPlanet = galaxy.getPlanetByName(args[0]);

        Planet secondPlanet = galaxy.getPlanetByName(args[1]);


        if(firstPlanet == null || secondPlanet == null)
        {
            System.out.println("Planet not found.");

            return;
        }


        /*
         Обединяваме
         джедаите.
        */
        List<Jedi> jedis = new ArrayList<>();


        jedis.addAll(firstPlanet.getJedis());

        jedis.addAll(secondPlanet.getJedis());


        /*
         Lexicographic sort.
        */
        jedis.sort(Comparator.comparing(Jedi::getName));


        /*
         Print.
        */
        for(Jedi jedi : jedis)
        {
            System.out.println(jedi);
        }
    }
}