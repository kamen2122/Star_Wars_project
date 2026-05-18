package StarWarsProject.main;

import StarWarsProject.commands.*;
import StarWarsProject.file.FileService;
import StarWarsProject.model.Galaxy;
import StarWarsProject.service.JediService;
import StarWarsProject.service.PlanetService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean fileOpened = false;
        String currentFile = null;
        String currentPath = System.getProperty("user.dir");

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
        commands.put("print", new PrintCommand(galaxy, jediService));
        commands.put("remove_jedi", new RemoveJediCommand(jediService, galaxy));
        commands.put("sort_strength", new SortByStrengthCommand(jediService, galaxy));
        commands.put("strongest_jedi", new StrongestJediCommand(jediService, galaxy));
        commands.put("save", new SaveCommand(fileService, galaxy));
        commands.put("open", new LoadCommand(fileService, galaxy));
        commands.put("help", new HelpCommand());
        commands.put("close", new CloseCommand(galaxy));
        commands.put("save_as", new SaveAsCommand(fileService, galaxy));

    /*
     Главен loop.
    */
        while (true) {
            System.out.print(currentPath + "> ");

            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }


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
            Проверка за:
            save as
            */
            if (tokens.length >= 2) {
                if (tokens[0].equals("save") && tokens[1].equals("as")) {
                    commandName = "save_as";
                }
            }

        /*
         Останалите са arguments.
        */
            String[] commandArgs;

            if(commandName.equals("save_as"))
            {
                commandArgs =
                        new String[tokens.length - 2];

                for(int i = 2; i < tokens.length; i++)
                {
                    commandArgs[i - 2] = tokens[i];
                }
            }
            else
            {
                commandArgs =
                        new String[tokens.length - 1];

                for(int i = 1; i < tokens.length; i++)
                {
                    commandArgs[i - 1] = tokens[i];
                }
            }


        /*
         Търсим командата.
        */
            Command command = commands.get(commandName);


            if (command == null) {
                System.out.println("Unknown command.");

                continue;
            }
            if (!fileOpened && !commandName.equals("open") && !commandName.equals("close") && !commandName.equals("help") && !commandName.equals("exit")) {
                System.out.println("No file opened");
                continue;
            }


        /*
         Изпълняваме командата.
        */
            command.execute(commandArgs);
            /*
            Ако е open команда,
            вече имаме отворен файл.
            */
            if (commandName.equals("open")) {

                if (commandArgs.length > 0) {
                    fileOpened = true;

                    currentFile = commandArgs[0];
                }
            }
            if (commandName.equals("close")) {
                fileOpened = false;

                currentFile = null;
            }
        }
    }
}


