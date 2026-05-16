package StarWarsProject.main;
import StarWarsProject.commands.AddPlanetCommand;
import StarWarsProject.commands.Command;
import StarWarsProject.commands.CreateJediCommand;
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


    /*
     Map:
     commandName -> commandObject
    */
            Map<String, Command> commands =new HashMap<>();


    /*
     Регистрираме командите.
    */
            commands.put("add_planet",

                    new AddPlanetCommand(planetService, galaxy));


            commands.put("create_jedi", new CreateJediCommand(jediService, galaxy));


    /*
     Главен loop.
    */
            while(true)
            {

                String input = scanner.nextLine();


        /*
         Изход от програмата.
        */
                if(input.equalsIgnoreCase("exit"))
                {
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
                String[] commandArgs =
                        new String[tokens.length - 1];


                for(int i = 1; i < tokens.length; i++)
                {
                    commandArgs[i - 1] = tokens[i];
                }


        /*
         Търсим командата.
        */
                Command command =commands.get(commandName);


                if(command == null)
                {
                    System.out.println(
                            "Unknown command."
                    );

                    continue;
                }


        /*
         Изпълняваме командата.
        */
                command.execute(commandArgs);
            }
        }
    }


