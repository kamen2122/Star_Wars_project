package StarWarsProject.commands;

import StarWarsProject.file.FileService;
import StarWarsProject.model.Galaxy;

public class LoadCommand implements Command
{

    private FileService fileService;

    private Galaxy galaxy;


    public LoadCommand(FileService fileService, Galaxy galaxy)
    {
        this.fileService = fileService;
        this.galaxy = galaxy;
    }


    @Override
    public void execute(String[] args)
    {

        if(args.length < 1)
        {
            System.out.println("Usage: open <file>");

            return;
        }

        String fileName = args[0];


        /*
         Зареждаме новата галактика.
        */
        Galaxy loadedGalaxy = fileService.loadGalaxy(fileName);


        /*
         Изчистваме старата.
        */
        galaxy.getPlanets().clear();


        /*
         Добавяме новите планети.
        */
        galaxy.getPlanets().addAll(loadedGalaxy.getPlanets());
    }
}