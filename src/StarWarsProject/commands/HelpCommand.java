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
    public String execute(String[] args)
    {
             StringBuilder builder = new StringBuilder();
             builder.append(">help").append("\n");
             builder.append("the following commands are supported:").append("\n");
             builder.append("open <file>   opens  <file>").append("\n");
             builder.append("close           close currently open file").append("\n");
             builder.append("save            save the currently open file").append("\n");
             builder.append("save as <file>  saves the currently open file in <file>").append("\n");
             builder.append("help            prints this information").append("\n");
             builder.append("exit            exits the program").append("\n");
             builder.append("add_planet <planet> - adds planet").append("\n");
             builder.append("create_jedi <planet> <name> <rank> <age> <color> <strength> - creates jedi").append("\n");
             builder.append("promote_jedi <planet> <jedi> <multiplier> - promotes jedi").append("\n");
             builder.append("demote_jedi <planet> <jedi> <multiplier> - demotes jedi").append("\n");
             builder.append("print <planet/jedi> - prints information").append("\n");
             builder.append("get_strongest_jedi <planet> - prints strongest jedi").append("\n");
             builder.append("get_youngest_jedi <planet> <rank> - prints youngest jedi").append("\n");
             builder.append("get_most_used_saber_color <planet> - prints most used saber color").append("\n");
             builder.append("<planet1> + <planet2> - merges planets").append("\n");

                  return builder.toString();

    }
}