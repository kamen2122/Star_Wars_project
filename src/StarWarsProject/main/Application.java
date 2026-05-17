package StarWarsProject.main;

import StarWarsProject.commands.*;
import StarWarsProject.file.FileService;
import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Planet;
import StarWarsProject.service.JediService;
import StarWarsProject.service.PlanetService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


    /*
     Създаваме системата.
    */
        Galaxy galaxy = new Galaxy();

        PlanetService planetService = new PlanetService();

        JediService jediService = new JediService();
        FileService fileService = new FileService();

    /*
     Map:
     commandName -> commandObject
    */
        Map<String, Command> commands = new HashMap<>();


    /*
     Регистрираме командите.
    */
        commands.put("add_planet", new AddPlanetCommand(planetService, galaxy));


        commands.put("create_jedi", new CreateJediCommand(jediService, galaxy));
        commands.put("promote_jedi", new PromoteJediCommand(jediService, galaxy));
        commands.put("demote_jedi", new DemoteJediCommand(jediService, galaxy));
        commands.put("print_jedis", new PrintJedisCommand(jediService, galaxy));
        commands.put("remove_jedi", new RemoveJediCommand(jediService, galaxy));
        commands.put("sort_strength", new SortByStrengthCommand(jediService, galaxy));
        commands.put("strongest_jedi", new StrongestJediCommand(jediService, galaxy));
        commands.put("save", new SaveCommand(fileService, galaxy));
    /*
     Главен loop.
    */
        while (true) {

            String input = scanner.nextLine();


        /*
         Изход от програмата.
        */
            if (input.equalsIgnoreCase("exit")) {
                break;
            }


        /*
         Разделяме input-а.
        */
            String[] tokens = input.split(" ");


        /*
         Първата дума е command.
        */
            String commandName = tokens[0];


        /*
         Останалите са arguments.
        */
            String[] commandArgs = new String[tokens.length - 1];


            for (int i = 1; i < tokens.length; i++) {
                commandArgs[i - 1] = tokens[i];
            }


        /*
         Търсим командата.
        */
            Command command = commands.get(commandName);


            if (command == null) {
                System.out.println("Unknown command.");

                continue;
            }


        /*
         Изпълняваме командата.
        */
            command.execute(commandArgs);
        }
    }
}


