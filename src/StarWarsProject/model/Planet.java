package StarWarsProject.model;

import java.util.*;

public class Planet {

    private String planetName;



    private List<Jedi> jedis = new ArrayList<>();

    public Planet(String planetName)
    {
        this.planetName = planetName;
    }

    public String getName()
    {
        return planetName;
    }

    public void addJedi(Jedi jedi)
    {
        jedis.add(jedi);
    }

    public List<Jedi> getJedis()
    {
        return jedis;
    }
    /*
 Търси джедай по име.
*/
    public Jedi getJediByName(String name)
    {
        for(Jedi jedi : jedis)
        {
            if(jedi.getName().equalsIgnoreCase(name))
            {
                return jedi;
            }
        }

        return null;
    }
}
