import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // system objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        // game variables
        String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin", "Orc"};
        int maxEnemyHealth = 100;
        int enemyAttackDamage = 25;

        // player variables
        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; // percentage that an enemy drops a potion

        boolean running = true;

        System.out.println("Welcome to the Dungeon!");

        GAME:
        while (running) {
            System.out.println("--------------------------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! #\n");


            while (enemyHealth > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");

                String input = in.nextLine();
                if (input.equals("1")) { // attack option chosen
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You stroke the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You received " + damageTaken + " in retaliation!");

                    if (health < 1)  {
                        System.out.println("\tYou have taken too much damage, you're dead!");
                        break;
                    }
                } else if (input.equals("2")) { // drink health potion option chosen
                    if (numHealthPotions > 0) {
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You drank a health potion, healing yourself for " + healthPotionHealAmount + "." +
                                "\n\t You now have " + health + " HP."
                        + "\n\t You have " + numHealthPotions + " health potions left.\n");
                    } else { // when no health potion is available
                        System.out.println("\t> You have no health potions left. Defeat enemies for a chance at dropping one.");
                    }
                } else if (input.equals("3")) { // run option chosen
                    System.out.println("\tYou ran away from the " + enemy +"!");
                    continue GAME;
                } else { // not a valid input

                }
            }
        }

    }
}
