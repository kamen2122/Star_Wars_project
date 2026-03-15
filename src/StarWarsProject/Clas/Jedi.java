package StarWarsProject.Clas;

import StarWarsProject.Enums.Rank;

public class Jedi {
    private String name;
    private Rank rank;
    private int age;
    private String saberColor;
    private int strength;

    public Jedi(String name,Rank rank,int age,String saberColor,int strength)
    {
        this.name = name;
        this.rank = rank;
        this.age = age;
        this.saberColor = saberColor;
        this.strength = strength;
    }

}
