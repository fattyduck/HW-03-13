import java.util.Random;
import java.util.Scanner;

/**
 * Created by fattyduck on 3/13/15.
 */

/**
 * Created by fattyduck on 3/13/15.
 */
import java.util.Random;
import java.util.Scanner;
public class AncientBattle {

    public static void main(String[] args){
        //System objects
        Scanner in=new Scanner(System.in);
        Random rand= new Random();

        //game variables
        String[] enemies={"Swordsman","Spearman","Chivalry","Bowman"};
        int maxEnemyHP=200;
        int enemyAD=20;

        //player variables
        int health =100;
        int attackDamage=50;
        int numHealthPots= 3;
        int healthPotHeal=30;
        int healthPotDrop=50;

        boolean run=true;

        System.out.println("Welcome to the battlefield!");

        GAME:
        while(run){
            System.out.println("-------------------------------------------------------------------------------------");

            int enemyHealth=rand.nextInt(maxEnemyHP);
            String enemy= enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# "+enemy+ " has appeared! #\n");
            //  #Swordsman has appeared#

            while(enemyHealth>0){
                System.out.println("\tYour HP: "+health);
                System.out.println("\tA " + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat is your next move?");
                System.out.println("\t1. Attack!");
                System.out.println("\t2. Drink the pot");
                System.out.println("\t3. Run!");

                String input=in.nextLine();
                if (input.equals("1")){
                    int damageDealt=rand.nextInt(attackDamage);
                    int damageTaken=rand.nextInt(enemyAD);
                    enemyHealth-=damageTaken;
                    health-=damageDealt;
                    System.out.println("\t>You dealt "+damageTaken+" damage to the "+enemy+"!");
                    System.out.println("\t>The "+enemy+" dealt "+damageDealt+" damage to you!");

                    if(health<1){
                        System.out.println("\t>You have died");
                        break;
                    }

                }else if(input.equals("2")){
                    if(numHealthPots>0){
                        health+=healthPotHeal;
                        numHealthPots--;
                        System.out.println("\t>You drank a health pot, healing for "+healthPotHeal+"."
                                +"\n\t>You now have "+health+" HP"
                                + "\n\t>You still have "+numHealthPots+" health pots left.");
                    }else{
                        System.out.println("\t>YOu don't have any health pots left ='( Defeat enemies to get more");
                    }

                }else if(input.equals("3")){
                    System.out.println("\tYou have ran away like a coward");
                    continue GAME;

                }else{
                    System.out.println("\tPlease enter a valid command(1,2, or 3)");
                }


            }

            if(health<1){
                System.out.println("\nThere are roses at your funeral, brave warrior");
                break;
            }

            System.out.println("------------------------------------------------------------------------------------");
            System.out.println(" # " +enemy+ " was defeated! # ");
            System.out.println(" # You have "+health+ " HP left. #");
            if(rand.nextInt(100)>healthPotDrop){
                numHealthPots++;
                System.out.println(" # The "+enemy+" dropped a Health pot");
                System.out.println(" # You now have " + numHealthPots+ "health potion(s)");
                System.out.println("What is your next move?");
                System.out.println("1. Continue Battling!");
                System.out.println("2. Exit Battlefield");

                String input=in.nextLine();

                while(!input.equals("1") && !input.equals("2")){
                    System.out.println("Please enter a valid command! (1 or 2)");
                    input=in.nextLine();
                }
                if (input.equals("1")){
                    System.out.println("Back to battle, you go!");

                }else if(input.equals("2")){
                    System.out.println("Exiting Battlefield!");
                    break;
                }
            }


        }
        System.out.println("########################");
        System.out.println("# THANKS FOR PLAYING");
        System.out.println("########################");
    }
}