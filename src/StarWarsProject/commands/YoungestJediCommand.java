package StarWarsProject.commands;

import StarWarsProject.enums.Rank;
import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Jedi;
import StarWarsProject.model.Planet;
import StarWarsProject.service.JediService;

public class YoungestJediCommand
        implements Command {

    private JediService jediService;

    private Galaxy galaxy;


    public YoungestJediCommand
            (
                    JediService jediService,
                    Galaxy galaxy
            ) {
        this.jediService = jediService;
        this.galaxy = galaxy;
    }


    @Override
    public void execute(String[] args) {

        /*
         get_youngest_jedi
         <planet>
         <rank>
        */

        if (args.length < 2) {
            System.out.println(
                    "Usage: get_youngest_jedi <planet> <rank>"
            );

            return;
        }


        String planetName = args[0];

        String rankString = args[1];


        Planet planet =
                galaxy.getPlanetByName(planetName);


        if (planet == null) {
            System.out.println(
                    "Planet not found."
            );

            return;
        }


        Rank rank;

        try {
            rank =
                    Rank.valueOf(
                            rankString.toUpperCase()
                    );
        } catch (IllegalArgumentException e) {
            System.out.println(
                    "Invalid rank."
            );

            return;
        }


        Jedi youngest =
                jediService
                        .getYoungestJediByRank(
                                planet,
                                rank
                        );


        if (youngest == null) {
            System.out.println(
                    "No Jedi found."
            );

            return;
        }


        System.out.println(youngest);
    }
}