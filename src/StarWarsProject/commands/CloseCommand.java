package StarWarsProject.commands;

import StarWarsProject.model.Galaxy;
/**
 * Команда за <затваряне на файл>.
 */
public class CloseCommand implements Command
{

    private Galaxy galaxy;


    public CloseCommand(Galaxy galaxy)
    {
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

        /*
         Изчистваме
         всички планети.
        */
        galaxy.getPlanets().clear();

        System.out.println("Successfully closed file.");
    }
}