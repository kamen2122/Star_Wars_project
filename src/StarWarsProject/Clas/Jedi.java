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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getSaberColor() {
        return saberColor;
    }

    public void setSaberColor(String saberColor) {
        this.saberColor = saberColor;
    }
}
