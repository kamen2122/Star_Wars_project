package StarWarsProject.commands;
/**
 * Основен интерфейс за всички команди.
 */
public interface Command {

    /**
     * Изпълнява логиката на командата.
     *
     * @param args аргументи на командата
     */
    String execute(String[] args);

}
