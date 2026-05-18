package StarWarsProject.file;

import StarWarsProject.enums.Rank;
import StarWarsProject.model.Galaxy;
import StarWarsProject.model.Jedi;
import StarWarsProject.model.Planet;

import java.io.*;

public class FileService {
    /*
    Записва галактиката във файла
     */
    public void saveGalaxy(Galaxy galaxy, String fileName)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));


        /*
         Минаваме през всички планети.
        */
            for(Planet planet : galaxy.getPlanets())
            {

            /*
             Записваме планетата.
            */
                writer.write("PLANET:" + planet.getName());

                writer.newLine();


            /*
             Записваме джедаите.
            */
                for(Jedi jedi : planet.getJedis())
                {

                    writer.write(
                            "JEDI:" + jedi.getName() + "," + jedi.getRank() + ","
                                + jedi.getAge() + "," + jedi.getSaberColor() + "," + jedi.getStrength());

                    writer.newLine();
                }
            }


        /*
         Затваряме файла
         НАКРАЯ.
        */
            writer.close();


            System.out.println("Galaxy saved successfully.");
        }
        catch(IOException e)
        {
            System.out.println("Error while saving galaxy.");
        }
    }
    /*
 Зарежда галактика от файл.
    */
    public Galaxy loadGalaxy(String fileName)
    {

        Galaxy galaxy = new Galaxy();

        Planet currentPlanet = null;


        try
        {
            File file = new File(fileName);

            if(!file.exists())
            {
                file.createNewFile();
            }

            BufferedReader reader = new BufferedReader(new FileReader(fileName));


            String line;


        /*
         Четем файла ред по ред.
        */
            while((line = reader.readLine()) != null)
            {

            /*
             Ако редът е планета.
            */
                if(line.startsWith("PLANET:"))
                {

                    String planetName = line.substring(7);

                    currentPlanet = new Planet(planetName);

                    galaxy.addPlanet(currentPlanet);
                }


            /*
             Ако редът е джедай.
            */
                else if(line.startsWith("JEDI:"))
                {

                /*
                 Премахваме "JEDI:"
                */
                    String data = line.substring(5);


                /*
                 Разделяме по запетая.
                */
                    String[] tokens = data.split(",");


                    String name = tokens[0];

                    Rank rank = Rank.valueOf(tokens[1]);

                    int age = Integer.parseInt(tokens[2]);

                    String color = tokens[3];

                    int strength =
                            Integer.parseInt(tokens[4]);


                    Jedi jedi = new Jedi(name, rank, age, color, strength);


                /*
                 Добавяме към
                 текущата планета.
                */
                    if(currentPlanet != null)
                    {
                        currentPlanet.addJedi(jedi);
                    }
                }
            }

            reader.close();

            System.out.println("Galaxy loaded successfully.");
        }
        catch (IOException e)
        {
            System.out.println(
                    "Error loading galaxy."
            );
        }

        return galaxy;
    }
}
