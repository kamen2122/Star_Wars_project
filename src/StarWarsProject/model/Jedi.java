package StarWarsProject.model;

import StarWarsProject.enums.Rank;

/**
 * Представя джедай в галактиката
 */
public class Jedi {
    private String name;
    private Rank rank;
    private int age;
    private String saberColor;
    private int strength;

    /**
     * Създава нов джедай
     * @param name име на джедай
     * @param rank ранг
     * @param age  възраст
     * @param saberColor цвят на меча
     * @param strength сила на джедая
     */
    public Jedi(String name, Rank rank, int age, String saberColor, int strength) {
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

    @Override
    public String toString() {
        return "Name: " + name
                + ", Rank: " + rank
                + ", Age: " + age
                + ", Saber Color: " + saberColor
                + ", Strength: " + strength;
    }
}
