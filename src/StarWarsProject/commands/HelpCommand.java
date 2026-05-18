package StarWarsProject.commands;

/**
 * Команда за <информация на команди>.
 */
public class HelpCommand implements Command
{

    /**
     * Изпълнява логиката на командата.
     *
     * @param args аргументи на командата
     */
    @Override
    public void execute(String[] args)
    {

        System.out.println(">help");
        System.out.println("the following commands are supported:");

        System.out.println("open <file>   opens  <file>");

        System.out.println("close           close currently open file");

        System.out.println("save            save the currently open file");

        System.out.println("save as <file>  saves the currently open file in <file>");

        System.out.println("help            prints this information");

        System.out.println("exit            exits the program");

        /*
         Planet commands
        */
        System.out.println();
        System.out.println("add_planet <planet> - adds planet");

        System.out.println();

        /*
         Jedi commands
        */
        System.out.println("create_jedi <planet> <name> <rank> <age> <color> <strength> - creates jedi");

        System.out.println("removeJedi <planet> <jedi> - removes jedi");

        System.out.println("promote_jedi <planet> <jedi> <multiplier> - promotes jedi");

        System.out.println("demote_jedi <planet> <jedi> <multiplier> - demotes jedi");

        System.out.println("print <planet/jedi> - prints information");

        System.out.println("get_strongest_jedi <planet> - prints strongest jedi");

        System.out.println("get_youngest_jedi <planet> <rank> - prints youngest jedi");

        System.out.println("get_most_used_saber_color <planet> - prints most used saber color");

        System.out.println("<planet1> + <planet2> - merges planets");

    }
}