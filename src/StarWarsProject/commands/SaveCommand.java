package StarWarsProject.commands;

import StarWarsProject.file.FileService;
import StarWarsProject.main.ApplicationState;
import StarWarsProject.model.Galaxy;
/**
 * Команда за <записване на файл>.
 */
public class SaveCommand implements Command {
    private FileService fileService;
    private ApplicationState state;
    private Galaxy galaxy;


    public SaveCommand(FileService fileService, Galaxy galaxy, ApplicationState state)
    {
        this.fileService = fileService;
        this.galaxy = galaxy;
        this.state = state;
    }
    public SaveCommand(FileService fileService, Galaxy galaxy)
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
    public String execute(String[] args)
    {

        String currentFile = state.getCurrentFile();


        if(currentFile == null)
        {
            return "No file opened.";


        }


        return fileService.saveGalaxy(galaxy, currentFile);

    }
}
