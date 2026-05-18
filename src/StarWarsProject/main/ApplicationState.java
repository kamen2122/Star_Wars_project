package StarWarsProject.main;

/**
 * Съхранява информация за текущо отворения файл.
 */
public class ApplicationState
{

    private String currentFile;


    public String getCurrentFile()
    {
        return currentFile;
    }


    public void setCurrentFile(String currentFile)
    {
        this.currentFile = currentFile;
    }
}