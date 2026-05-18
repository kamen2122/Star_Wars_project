package StarWarsProject.commands;

public class HelpCommand
        implements Command
{

    @Override
    public void execute(String[] args)
    {

        System.out.println(">help");
        System.out.println("the following commands are supported:");

        System.out.println("open <file>opens<file>");

        System.out.println("close           close currently open file");

        System.out.println("save            save the currently open file");

        System.out.println("save as <file>  saves the currently open file in <file>");

        System.out.println("help            prints this information");

        System.out.println("exit            exits the program");

    }
}