package StarWarsProject.service;

import StarWarsProject.model.Jedi;
import StarWarsProject.model.Planet;
import StarWarsProject.enums.Rank;

import java.util.*;

public class JediService {
    /*
    Добавя нов джедай към планета.
   */
    public boolean addJedi(Planet planet, String name, String rankStr, int age, String color, double strength) {

        // Проверка за null планета
        if (planet == null) {
            return false;
        }


        /*
         Проверка дали вече има джедай
         със същото име.
        */
        for (Jedi jedi : planet.getJedis()) {
            if (jedi.getName().equalsIgnoreCase(name)) {
                return false;
            }
        }


        /*
         Превръщаме String към Rank enum.
        */
        Rank rank;

        try {
            rank = Rank.valueOf(rankStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            return false;
        }


        /*
         Създаваме новия джедай.
        */
        Jedi jedi = new Jedi(name, rank, age, color, (int) strength);


        /*
         Добавяме го към планетата.
        */
        planet.addJedi(jedi);

        return true;
    }

    /*
 Повишава ранга на джедай.
*/
    public boolean promoteJedi(Planet planet, String jediName, double multiplier) {

        // Проверка за null
        if (planet == null) {
            return false;
        }


        // Multiplier трябва да е положителен
        if (multiplier <= 0) {
            return false;
        }


        // Търсим джедая
        Jedi jedi = planet.getJediByName(jediName);

        if (jedi == null) {
            return false;
        }


    /*
     Взимаме текущия rank.
    */
        Rank currentRank = jedi.getRank();


    /*
     Ако вече е GRAND_MASTER
     няма накъде да се повишава.
    */
        if (currentRank == Rank.GRAND_MASTER) {
            return false;
        }


    /*
     Взимаме всички стойности
     от enum-а.
    */
        Rank[] ranks = Rank.values();


    /*
     Следващият rank е:
     текущата позиция + 1
    */
        Rank nextRank = ranks[currentRank.ordinal() + 1];


    /*
     Задаваме новия rank.
    */
        jedi.setRank(nextRank);


    /*
     Увеличаваме силата.
    */
        int newStrength = (int) (jedi.getStrength() + multiplier * jedi.getStrength());

        jedi.setStrength(newStrength);

        return true;
    }

    /*
 Намалява ранга на джедай.
*/
    public boolean demoteJedi(Planet planet, String jediName, double multiplier) {

        if (planet == null) {
            return false;
        }

        if (multiplier <= 0) {
            return false;
        }


        Jedi jedi = planet.getJediByName(jediName);

        if (jedi == null) {
            return false;
        }


        Rank currentRank = jedi.getRank();


    /*
     Ако е най-ниският rank
     не може да пада надолу.
    */
        if (currentRank == Rank.YOUNGLING) {
            return false;
        }


        Rank[] ranks = Rank.values();


    /*
     Предишният rank:
     ordinal - 1
    */
        Rank previousRank = ranks[currentRank.ordinal() - 1];


        jedi.setRank(previousRank);


    /*
     Намаляване на силата.
    */
        int newStrength = (int) (jedi.getStrength() - multiplier * jedi.getStrength());

        jedi.setStrength(newStrength);

        return true;
    }

    /*
 Връща най-силния джедай
 на дадена планета.
*/
    public Jedi getStrongestJedi(Planet planet) {

        // Проверка за null
        if (planet == null) {
            return null;
        }

        // Проверка за празен списък
        if (planet.getJedis().isEmpty()) {
            return null;
        }


    /*
     В началото приемаме,
     че първият е най-силен.
    */
        Jedi strongest = planet.getJedis().get(0);


    /*
     Минаваме през всички
     и сравняваме strength.
    */
        for (Jedi jedi : planet.getJedis()) {
            if (jedi.getStrength() > strongest.getStrength()) {
                strongest = jedi;
            }
        }

        return strongest;
    }

    /*
 Връща най-младия джедай.
*/
    public Jedi getYoungestJedi(Planet planet) {

        if (planet == null) {
            return null;
        }

        if (planet.getJedis().isEmpty()) {
            return null;
        }


        Jedi youngest = planet.getJedis().get(0);


        for (Jedi jedi : planet.getJedis()) {
            if (jedi.getAge() < youngest.getAge()) {
                youngest = jedi;
            }
        }

        return youngest;
    }

    /*
 Връща най-използвания
 цвят на светлинен меч.
*/
    public String getMostUsedSaberColor(Planet planet) {

        if (planet == null) {
            return null;
        }

        if (planet.getJedis().isEmpty()) {
            return null;
        }


    /*
     Пази:
     color -> count
    */
        Map<String, Integer> colors = new HashMap<>();


    /*
     Броим колко пъти
     се среща всеки цвят.
    */
        for (Jedi jedi : planet.getJedis()) {

            String color =
                    jedi.getSaberColor();

            if (colors.containsKey(color)) {
                colors.put(color, colors.get(color) + 1
                );
            } else {
                colors.put(color, 1);
            }
        }


    /*
     Търсим най-често
     срещания цвят.
    */
        String mostUsed = null;

        int maxCount = 0;


        for (Map.Entry<String, Integer> entry : colors.entrySet()) {

            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();

                mostUsed = entry.getKey();
            }
        }

        return mostUsed;
    }

    /*
 Премахва джедай
 от дадена планета.
*/
    public boolean removeJedi(Planet planet, String jediName) {

        if (planet == null) {
            return false;
        }

        return planet.removeJedi(jediName);
    }

    /*
 Сортира по име.
    */
    public List<Jedi> sortByName(Planet planet) {

        if (planet == null) {
            return null;
        }

        List<Jedi> sorted = new ArrayList<>(planet.getJedis());


        Collections.sort(sorted, Comparator.comparing(Jedi::getName));

        return sorted;
    }

    /*
 Сортира по сила.
*/
    public List<Jedi> sortByStrength(Planet planet) {

        if (planet == null) {
            return null;
        }

        List<Jedi> sorted = new ArrayList<>(planet.getJedis());


        Collections.sort(sorted, (j1, j2) -> Integer.compare(j2.getStrength(), j1.getStrength()));

        return sorted;
    }
    /*
    Сортира
    1.По ранг
    2. По име
     */
    public List<Jedi> getSortedJedis(Planet planet) {
        if (planet == null) {
            return null;
        }

        List<Jedi> sorted = new ArrayList<>(planet.getJedis());

        Collections.sort(sorted, Comparator.comparing(Jedi::getRank).thenComparing(Jedi::getName));
     return sorted;
    }
}
