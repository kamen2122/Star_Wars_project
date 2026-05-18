package StarWarsProject.commands;


import StarWarsProject.file.FileService;
import StarWarsProject.model.Galaxy;
/**
 * Команда за <записване на файл като>.
 */
public class SaveAsCommand implements Command
{

    private FileService fileService;

    private Galaxy galaxy;


    public SaveAsCommand(FileService fileService, Galaxy galaxy)
    {
        this.fileService = fileService;
        this.galaxy = galaxy;
    }
    /**
     * Изпълнява логиката на командата.
     *
     * @param args аргументи на командата
     */

    @Override
    public void execute(String[] args)
    {


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