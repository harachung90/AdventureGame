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
        int attackAttackDamage = 25;

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

        }

    }
}
