package StarWarsProject.commands;


import StarWarsProject.file.FileService;
import StarWarsProject.model.Galaxy;

public class SaveAsCommand
        implements Command
{

    private FileService fileService;

    private Galaxy galaxy;


    public SaveAsCommand(FileService fileService, Galaxy galaxy)
    {
        this.fileService = fileService;
        this.galaxy = galaxy;
    }


    @Override
    public void execute(String[] args)
    {

        /*
         save_as <file>
        */
        if(args.length < 1)
        {
            System.out.println("Usage: save as <file>");

            return;
        }


        String fileName = args[0];


        fileService.saveGalaxy(galaxy, fileName);


        System.out.println("Successfully saved as " + fileName);
    }
}