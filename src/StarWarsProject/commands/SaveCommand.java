package StarWarsProject.commands;

import StarWarsProject.file.FileService;
import StarWarsProject.model.Galaxy;

public class SaveCommand implements Command {
    private FileService fileService;

    private Galaxy galaxy;


    public SaveCommand(FileService fileService, Galaxy galaxy)
    {
        this.fileService = fileService;
        this.galaxy = galaxy;
    }


    @Override
    public void execute(String[] args)
    {

        if(args.length < 1)
        {
            System.out.println("Invalid command.");

            return;
        }


        String fileName = args[0];


        fileService.saveGalaxy(galaxy, fileName);
    }
}
