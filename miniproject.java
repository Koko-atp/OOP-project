import java.util.Scanner;


public class miniproject {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.print("Enter Player Name: ");
        System.out.println(" ");

        String playerName = kbd.nextLine();

        Player P = new Player();
        P.setName(playerName);

        System.out.print("Weapon You can choose : ");
        System.out.println(" ");
        System.out.println("1. Sword");
        System.out.println("2. Axe");
        System.out.println("3. Knife");
        System.out.print("Choose Your Weapon : ");
        System.out.println(" ");



        String playerWeapon = kbd.nextLine();
        P.setWeapon2(playerWeapon);

        System.out.print("Armor You can Armor : ");
        System.out.println(" ");
        System.out.println("1. Low");
        System.out.println("2. Mid");
        System.out.println("3. High");
        System.out.print("Choose Your Armor : ");
        System.out.println(" ");
        String playerArmor = kbd.nextLine();
        P.setArmor2(playerArmor);
        System.out.println("=====================================");
        P.ShowDetails();

        Monster M = new Monster();
        M.ShowDetails();
        System.out.println("=========== BATTLE START ============");
        System.out.println("Player Speed: " + P.getSPD() + " | Monster Speed: " + M.getSPD());


        Flight(P, M, kbd);
        kbd.close();



    }
    public static void Flight (Player player,Monster M,Scanner input){
        
        while (player.getHP() > 0 && M.getHP() > 0){

            System.out.println("========== Your turn ================");
            System.out.println("What will you do ?");
            System.out.println("1. Attack");
            System.out.println("=====================================");
            System.out.println("Enter your choice (Choose the number): ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    PlayerAttack(player, M);
                    break;
                default:
                    System.out.println("Invalid choice. You lose your turn.");
                    return;
            }
            if (M.getHP() <= 0) {
                break;
            }
            MonsterAttack(player, M);
            
            if (player.getHP() <= 0) {
                break;
            }

            System.out.println("Current HP: " + player.getNAME() + " (" + player.getHP() + " HP) vs " + M.getNAME() + " (" + M.getHP() + " HP)");
        }
        System.out.println("=========== BATTLE END ==============");
        
        if (player.getHP() <= 0) {
            System.out.println(player.getNAME() + " has been defeated! " + M.getNAME() + " wins!");
        } 
        else{
            System.out.println(player.getNAME() + " is victorious!");
            System.out.println("=====================================");

        }
    }

    private static void PlayerAttack(Player player , Monster M){
        
            int playerDamage = player.getATK() - M.getDEF();
            if(playerDamage < 0) playerDamage = 0;

            M.setHP(M.getHP() - playerDamage);
            System.out.println("=====================================");

            System.out.println(player.getNAME() + " attacks " + M.getNAME() + " " + playerDamage + " Damage");

        
    }
    private static void MonsterAttack(Player player , Monster M){
            int monsterDamage = M.getATK() - player.getDEF();
            if(monsterDamage < 0) monsterDamage = 0;

            player.setHP(player.getHP() - monsterDamage);
            System.out.println(M.getNAME() + " attacks " + player.getNAME() + " " + monsterDamage + " Damage");
            System.out.println("=====================================");


        
    }
}
 class Character{

    protected String NAME;
    protected int HP ;
    protected int DEF;
    protected int ATK;
    protected int SPD;
    
    public String getNAME (){
        return this.NAME;
    }
    public int getHP(){
        return this.HP;
    }
    public int getDEF(){
        return this.DEF;
    }
    public int getATK(){
        return this.ATK;
    }
    public int getSPD(){
        return this.SPD;
    }


    public void setName(String name){
        this.NAME = name;
    }
    public void setHP(int HP){
        this.HP = HP;
    }
    public void setDEF(int DEF){
        this.DEF = DEF;
    }
    public void setATK(int Atk){
        this.ATK = Atk;
    }
    public void setSPD(int Spd){
        this.SPD = Spd;
    }
}

class Player extends Character{

    protected String Weapon;
    protected String Armor;
    

    public Player() {
        this.HP = 100;
        this.DEF = 50;
        this.ATK = 30;
        this.SPD = 20;
        
    }
    
    public String getWeapon(){
        return this.Weapon;
    }

    public void setWeapon(String Weapon){
        this.Weapon = Weapon;
    }
    
    public String getArmor(){
        return this.Armor;
    }

    public void setArmor(String Armor){
        this.Armor = Armor;
    }

    
    public void setWeapon2(String Choose_Weapon){
        
        this.Weapon = Choose_Weapon; 

        if (Weapon.equalsIgnoreCase("Sword")) {
            
            this.ATK += 100;
        }
        else if (Weapon.equalsIgnoreCase("1")) {

            this.Weapon = "Sword";
            this.ATK += 100;
        } 
        else if (Weapon.equalsIgnoreCase("Axe")) {
            
            this.ATK += 150;
        }
        else if (Weapon.equalsIgnoreCase("2")) {

            this.Weapon = "Axe";
            this.ATK += 150;
        }
        else if (Weapon.equalsIgnoreCase("Knife")) {

            this.Weapon = "Knife";
            this.ATK += 50;
        }
        else if (Weapon.equalsIgnoreCase("3")) {
            
            this.ATK += 50;
        }
        else{
            System.out.println("=====================================");
            System.out.println("We don't have that weapon ");
            System.out.println("Please try again");
            System.out.println("=====================================");
            System.exit(1);
        }
        
    }

    public void setArmor2 (String Choose_Armor){
        
        this.Armor = Choose_Armor;
        
        if (Armor.equalsIgnoreCase("Low")) {

            this.DEF += 50;
        }
        else if (Armor.equalsIgnoreCase("1")) {

            this.Armor = "Low";
            this.DEF += 100;
        }
        else if (Armor.equalsIgnoreCase("Mid")) {

            this.DEF += 100;
        }
        else if (Armor.equalsIgnoreCase("2")) {

            this.Armor = "Mid";
            this.DEF += 100;
        }
        else if (Armor.equalsIgnoreCase("High")) {

            this.DEF += 150;
        }
        else if (Armor.equalsIgnoreCase("3")) {

            this.Armor = "High";
            this.DEF += 150;
        }
        else{
            System.out.println("=====================================");
            System.out.println("We don't have that Armor ");
            System.out.println("Please try again");
            System.out.println("=====================================");
            System.exit(1);
            
        }
    }

    public void ShowDetails(){
        System.out.println("========== PLAYER INFORMATION =======");
        System.out.println("Name : " + this.NAME);
        System.out.println("HP : " + this.HP);
        System.out.println("DEF : " + this.DEF);
        System.out.println("ATK : " + this.ATK);
        System.out.println("SPD : " + this.SPD);    
        System.out.println("Weapon : " + this.Weapon);
        System.out.println("Armor : " +this.Armor);
        System.out.println("=====================================");


    }
}
class Monster extends Character{
    
    public Monster() {
        super.setName("Slime");
        this.HP = 1000;
        this.DEF = 50;
        this.ATK = 30;
        this.SPD = 20;

    }

    public void ShowDetails(){
        System.out.println("========= MONSTER INFORMATION =======");
        System.out.println("Name : " + this.NAME);
        System.out.println("HP : " + this.HP);
        System.out.println("DEF : " + this.DEF);
        System.out.println("ATK : " + this.ATK);
        System.out.println("SPD : " + this.SPD);    
        System.out.println("=====================================");


    }
    
}

