package StarWarsProject.file;

import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Jedi;
import StarWarsProject.model.Planet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {
    /*
    Записва галактиката във файла
     */
    public void saveGalaxy(Galaxy galaxy,String fileName){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            /*
            Минаваме през всички планети
             */
            for (Planet planet : galaxy.getPlanets()) {
                /*
                Записваме планетата.
                 */
                writer.write("PLANET:" + planet.getName());
                writer.newLine();
                for (Jedi jedi:planet.getJedis())
                {
                    writer.write(
                            "JEDI:"
                                    + jedi.getName()
                                    + ","
                                    + jedi.getRank()
                                    + ","
                                    + jedi.getAge()
                                    + ","
                                    + jedi.getSaberColor()
                                    + ","
                                    + jedi.getStrength()
                    );

                    writer.newLine();
                    writer.close();

                    System.out.println("Galaxy saved successfully.");

                }

            }
        }
        catch(IOException e)
        {
            System.out.println("Error while saving galaxy.");
        }
    }
}
