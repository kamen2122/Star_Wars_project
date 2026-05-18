package StarWarsProject.commands;

import StarWarsProject.enums.Rank;
import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Jedi;
import StarWarsProject.model.Planet;
import StarWarsProject.service.JediService;
/**
 * Команда за <най млад джедай>.
 */
public class YoungestJediCommand implements Command {

    private JediService jediService;

    private Galaxy galaxy;


    public YoungestJediCommand(JediService jediService, Galaxy galaxy) {
        this.jediService = jediService;
        this.galaxy = galaxy;
    }

    /**
     * Изпълнява логиката на командата.
     *
     * @param args аргументи на командата
     */
    @Override
    public String execute(String[] args) {



        if (args.length < 2) {
            return "Usage: get_youngest_jedi <planet> <rank>";


        }


        String planetName = args[0];

        String rankString = args[1];


        Planet planet = galaxy.getPlanetByName(planetName);


        if (planet == null) {
            return "Planet not found.";


        }


        Rank rank;

        try {
            rank =Rank.valueOf(rankString.toUpperCase());
        } catch (IllegalArgumentException e) {
            return"Invalid rank.";


        }


        Jedi youngest = jediService.getYoungestJediByRank(planet, rank);


        if (youngest == null) {
            return "No Jedi found.";


        }


        return youngest.toString();
    }
}