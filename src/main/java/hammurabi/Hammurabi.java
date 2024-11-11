package hammurabi;
import java.util.InputMismatchException;
import java.util.Random;         // imports go here
import java.util.Scanner;

public class Hammurabi {         // must save in a file named Hammurabi.java
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);
    int population;
    int bushels;
    int acresOwned;
    int price; //random between 17-23 each year
    int year;
    int acresToBuy;
    int acresToSell;
    int bushelsToFeed;
    int acresToPlant;
    int deaths;
    int starved;
    int immigrants;
    int harvest;
    int eaten;


    public static void main(String[] args) { // required in every Java program
        new Hammurabi().playGame();
    }

    void playGame() {
        population = 100; // = population + immigration - starvedDeaths - plagueDeaths
        bushels = 2800; // = bushels - (acresToPlant*2) + harvest - ratFood
        acresOwned = 1000; // = acres - acresToSell or acres + acresToBuy
        price = 19; // random
        year = 1; // year + 1;
        while (year < 11) {
//            acresToBuy = askHowManyAcresToBuy(price, bushels);
//            acresOwned += acresToBuy;
//            bushels = acresToBuy*price;
//            if (acresToBuy == 0) {
//                acresToSell = askHowManyAcresToSell(acresOwned);
//                acresOwned -= acresToSell;
//            }
//            System.out.println(acresOwned);
//            bushelsToFeed = askHowMuchGrainToFeedPeople(bushels);
//            bushels -= grainToFeed;
//            System.out.println(bushels);
//            acresToPlant = askHowManyAcresToPlant(acresOwned, population, bushels);
//            bushels -= (acresToPlant*2);
//            System.out.println(bushels);
//            plagueDeaths(population);
//                population -= deaths;
//                System.out.println(population);
//            starvationDeaths(population, bushelsToFeed);
//                population -= starved;
//                System.out.println(population);
//            uprising(population, starved);
//            getImmigrants(population, acresOwned, bushels);
            getHarvest(acresOwned, acresToPlant);

                break;
        }
    }

    int askHowManyAcresToBuy(int price, int bushels) {
        int acresToBuy = getNumber("How many acres of land do you wish to buy?\n");
        while (true) {
            if (acresToBuy < 0) {
                System.out.println("You can't buy negative acres!");
            }
            else if (acresToBuy <= bushels * price) {
                break;
            } else if (acresToBuy > bushels * price) {
                System.out.println("But you don't have enough bushels!");
            }
            acresToBuy = getNumber("How many acres of land do you wish to buy?\n");
        }
        return acresToBuy;
    }

    int askHowManyAcresToSell(int acresOwned) {
        int acresToSell = getNumber("How many acres of land do you wish to sell?\n");
        while (true) {
            if (acresToSell < 0) {
                System.out.println("You can't sell negative acres!");
            } else if (acresToSell > acresOwned) {
                System.out.println("But you don't have enough acres!");
            } else break;
            acresToSell = getNumber("How many acres of land do you wish to sell?\n");
        }
        return acresToSell;
    }

    int askHowMuchGrainToFeedPeople(int bushels) {
        int bushelsToFeed = getNumber("How much grain would you like to feed to your people?\n");
        while (true) {
            if (bushelsToFeed < 0) {
                System.out.println("You can't take their food!");
            } else if (bushelsToFeed > bushels) {
                System.out.println("But you don't have enough food!");
            } else break;
            bushelsToFeed = getNumber("How much grain would you like to feed to your people?\n");
        } return bushelsToFeed;
    }

    int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
        int acresToPlant = getNumber("How many acres would you like to plant with grain?\n");
        while (true) {
            if (acresToPlant < 0) {
                System.out.println("You can't plant negative acres!");
            } else if (acresToPlant <= acresOwned && acresToPlant <= population *10 && acresToPlant <= bushels/2) {
                break;
            } else if (acresToPlant > acresOwned) {
                System.out.println("You don't have enough acres!");
            } else if (acresToPlant > population * 10) {
                System.out.println("You don't have enough people!");
            } else if (acresToPlant > bushels / 2) {
                System.out.println("You don't have enough grain!");
            }
            acresToPlant = getNumber("How many acres would you like to plant with grain?\n");
        }
        return acresToPlant;
    }

    int plagueDeaths(int population){
        if (rand.nextInt(100) < 15) {
            deaths = (population/2);
        } return deaths;
    }

    int starvationDeaths(int population, int bushelsToFeed){
        if (bushelsToFeed < population*20){
            starved = population - bushelsToFeed/20;
        } return starved;
    }

    boolean uprising (int population, int starved) {
        if (starved >= .45/population) {
            return true;
        } else {
            return false;
        }
    }

    int getImmigrants(int population, int acresOwned, int bushels){
        immigrants = (20 * acresOwned + bushels) / (100 * population) + 1;
        return immigrants;
    }

    int getHarvest(int acresOwned, int acresToPlant){
        int harvestPerAcre = rand.nextInt(6) + 1;
        harvest = harvestPerAcre * acresToPlant;
        return harvest;
    }

    int grainEatenByRats(int bushels){
        if (rand.nextInt(100) < 40){
            eaten = bushels - (bushels/(rand.nextInt(21) + 10));
        } return eaten;
    }

    int newCostOfLand(){
        price = rand.nextInt(7) + 17;
        return price;
    }


    String printSummary(int year, int starvationDeaths, int immigrants, int population, int harvest, int harvestData, int ratFood, int bushels, int acresOwned, int price) {
        return "O great Hammurabi!\n" +
                "You are in year 1 of your ten year rule.\n" +
                "In the previous year 0 people starved to death.\n" +
                "In the previous year 5 people entered the kingdom.\n" +
                "The population is now 100.\n" +
                "We harvested 3000 bushels at 3 bushels per acre.\n" +
                "Rats destroyed 200 bushels, leaving 2800 bushels in storage.\n" +
                "The city owns 1000 acres of land.\n" +
                "Land is currently worth 19 bushels per acre.\n";
    }

    String finalSummary() {
        return null;
    }

    int getNumber(String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }
    }
}


