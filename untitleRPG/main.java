package untitleRPG;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
                Scanner kbd = new Scanner(System.in);
        
        System.out.println("=====================================");
        System.out.print("Enter Player Name: ");
        // System.out.println(" ");
        
        String playerName = kbd.nextLine();

        Player P = new Player(playerName);
        System.out.println(" ");
        System.out.print("# Weapon You can choose # ");
        System.out.println(" ");
        System.out.println("1. Sword");
        System.out.println("2. Axe");
        System.out.println("3. Knife");
        System.out.print("Choose Your Weapon : ");
        // System.out.println(" ");



        String playerWeapon = kbd.nextLine();
        P.equipWeapon(playerWeapon);
        
        System.out.println(" ");
        System.out.print("# Armor On Your Choice # ");
        System.out.println(" ");
        System.out.println("1. Low");
        System.out.println("2. Mid");
        System.out.println("3. High");
        System.out.print("Choose Your Armor : ");
        // System.out.println(" ");
        String playerArmor = kbd.nextLine();
        P.equipArmor(playerArmor);
        System.out.println("=====================================");
        P.ShowDetails();

        Monster M = new Monster();
        M.ShowDetails();
        System.out.println(" ");
        System.out.println("=========== BATTLE START ============");
        System.out.println("Player Speed: " + P.getSPD() + " | Monster Speed: " + M.getSPD());


        Fight(P, M, kbd);
        kbd.close();



    }
    public static void Fight (Player player,Monster M,Scanner input){
        
        while (player.getHP() > 0 && M.getHP() > 0){
            System.out.println("========== Your turn ================");
            System.out.println("What will you do ?");
            System.out.println("1. Attack");
            System.out.println("2. Block");
            System.out.println("3. Use Potion");
            System.out.println("=====================================");
            System.out.println("Enter your choice (Choose the number): ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    player.ATK(player, M);
                    break;
                case 2:
                    player.Block(player, M);
                    break;
                case 3:
                   player.openBag();
                   break;
                default:
                    System.out.println("Invalid choice. You lose your turn.");
                    return;
            }
            if (M.getHP() <= 0) {
                break;
            }
            M.ATK(player, M);
            
            if (player.getHP() <= 0) {
                break;
            }

            System.out.println("Current HP: " + player.getName() + " (" + player.getHP() + " HP) vs " + M.getName() + " (" + M.getHP() + " HP)");
        }
        System.out.println("=========== BATTLE END ==============");
        
        if (player.getHP() <= 0) {
            System.out.println(player.getName() + " has been defeated! " + M.getName() + " wins!");
        } 
        else{
            System.out.println(player.getName() + " is victorious!");
            System.out.println("=====================================");

        }
    }
}