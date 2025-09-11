package test1;
import java.util.ArrayList ;
import java.util.Scanner;

import javax.jws.soap.SOAPBinding.Use;

import characterFunction;

public class mainiproject {
    public static void mainiproject(String[] args){
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
            System.out.println(" ");
            System.out.println("Current HP: " + player.getName() + " (" + player.getHP() + " HP) vs " + M.getName() + " (" + M.getHP() + " HP)");
            System.out.println(" ");

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

abstract class character {
    private String name;
    private int HP = 100;
    private int DEF = 50;
    private int ATK = 30;
    private int SPD = 20;

    public int getHP() { return this.HP;}
    public int getDEF() { return this.DEF;}
    public int getATK() { return this.ATK;}
    public int getSPD() { return this.SPD;}
    public String getName() {return this.name;}

    public void setName(String name){ this.name = name;}
    public void setHP(int HP){ this.HP = HP;}
    public void setDEF(int DEF){ this.DEF = DEF;}
    public void setATK(int Atk){ this.ATK = Atk;}
    public void setSPD(int Spd){ this.SPD = Spd;}

    public void ShowDetails(){
        System.out.println("Name : " + this.name);
        System.out.println("HP : " + this.HP);
        System.out.println("DEF : " + this.DEF);
        System.out.println("ATK : " + this.ATK);
        System.out.println("SPD : " + this.SPD);    
    }
}

class Player extends character implements characterFunction{

    private Weapon Weapon;
    private Armor Armor;
    private HealPotionBag PotionBag;
    private boolean isBlocking = false;

    
    Player(String Name) {
        super.setName(Name);
        HealPotionBag newPB = new HealPotionBag(Name);
        this.PotionBag = newPB;
    }

    public int getHP() { return super.getHP();}
    public int getDEF() { return super.getDEF();}
    public int getATK() { return super.getATK();}
    public int getSPD() { return super.getSPD();}
    public String getName() {return super.getName();}

    public String getWeapon(){ return this.Weapon.getName(); }
    public String getArmor(){ return this.Armor.getName(); }
    public HealPotionBag getBag(){ return this.PotionBag;}
    public boolean getIsBlocking(){ return this.isBlocking;}

    
    private void setArmor(String name , int DEF){
        Armor na = new Armor(name , DEF);
        this.Armor = na;
        super.setDEF(getDEF() + na.getDEF());
    } 

        private void setWeapon(String name , int Atk ,int spd){
        Weapon nw = new Weapon(name , Atk , spd);
        this.Weapon = nw;
        super.setATK(getATK() + nw.getATK());
        super.setSPD(getSPD() + nw.getSpeed());
    } 
        
    
    public void equipWeapon(String Choose_Weapon){
         
        if (Choose_Weapon.equalsIgnoreCase("Sword") || Choose_Weapon.equalsIgnoreCase("1")) {
            setWeapon("Sword", 100, 50);
        } 
        else if (Choose_Weapon.equalsIgnoreCase("Axe") || Choose_Weapon.equalsIgnoreCase("2")) {
            setWeapon("Axe", 150, 25);
        }
        else if (Choose_Weapon.equalsIgnoreCase("Dagger") || Choose_Weapon.equalsIgnoreCase("3")) {
            setWeapon("Dagger", 50, 75);
        }
        else{
            System.out.println("=====================================");
            System.out.println("We don't have that weapon ");
            System.out.println("Please try again");
            System.out.println("=====================================");
            System.exit(1);
        }

    }
    public void openBag(){
          Integer result =  this.getBag().openBag(super.getHP());
          if(result != null){
            super.setHP(result);
            
          } 
    }
        

    public void equipArmor (String Choose_Armor){
        if (Choose_Armor.equalsIgnoreCase("Low") || Choose_Armor.equalsIgnoreCase("1")) {
            this.setArmor("Low", 50);
            this.getBag().addHealPotion("Normal HP Potion", 20, 3);
        }

        else if (Choose_Armor.equalsIgnoreCase("Mid") || Choose_Armor.equalsIgnoreCase("2")) {
            this.setArmor("Mid", 100);
            this.getBag().addHealPotion("Normal HP Potion", 20, 2);
        }

        else if (Choose_Armor.equalsIgnoreCase("High") || Choose_Armor.equalsIgnoreCase("3")) {
            this.setArmor("High", 150);
            this.getBag().addHealPotion("Normal HP Potion", 20, 1);
        }
        else{
            System.out.println("=====================================");
            System.out.println("We don't have that Armor ");
            System.out.println("Please try again");
            System.out.println("=====================================");
            System.exit(1);
            
        }
    }

    public void setIsBlocking(boolean isBlocking) {
        this.isBlocking = isBlocking;
    }


    public void ShowDetails(){
        System.out.println("========== PLAYER INFORMATION =======");
        super.ShowDetails();
        System.out.println("Weapon : " + this.getWeapon());
        System.out.println("Armor : " + this.getArmor());
        System.out.println("=====================================");
    }

    @Override
    public void ATK(Player player , Monster M){
            int playerDamage = player.getATK() - M.getDEF();
            if(playerDamage < 0) playerDamage = 0;

            M.setHP(M.getHP() - playerDamage);
            System.out.println("=====================================");
            System.out.println(player.getName() + " attacks " + M.getName() + " " + playerDamage + " Damage"); 
            super.ShowDetails();

    }

    public void Block(Player player , Monster M){

            player.setIsBlocking(true);
            System.out.println("=====================================");                
            System.out.println(player.getName() + " is blocking!");
            double playerincreasedef = player.getDEF() * 0.5;
            player.setDEF((int)(player.getDEF() + playerincreasedef));
            System.out.println(player.getName() + " block " + M.getName() + " " + player.getName() +" DEF UP " + playerincreasedef);
            super.ShowDetails();
    }

}
class Monster extends character implements characterFunction {
    
    public Monster() {
        super.setName("Slime");
        super.setHP(1000);
    }

    public int getHP() { return super.getHP();}
    public int getDEF() { return super.getDEF();}
    public int getATK() { return super.getATK();}
    public int getSPD() { return super.getSPD();}
    public String getName() {return super.getName();}

    public void ShowDetails(){
        System.out.println("========= MONSTER INFORMATION =======");
        super.ShowDetails();
        System.out.println("=====================================");
    }

    @Override
    public void ATK(Player player , Monster M){
            int monsterDamage = M.getATK() - player.getDEF();
            if(monsterDamage < 0) monsterDamage = 0;

            player.setHP(player.getHP() - monsterDamage);
            System.out.println(M.getName() + " attacks " + player.getName() + " " + monsterDamage + " Damage");
            System.out.println("=====================================");
    }
    
}

interface characterFunction {
    void ATK(Player player , Monster M);
    void ShowDetails();
}

class Weapon {
    private String name;
    private int ATK;
    private int speed;
    Weapon(String name , int atk , int speed){
        this.name = name;
        this.ATK = atk;
        this.speed = speed;
    }
    public int getATK(){return this.ATK;}
    public int getSpeed(){return this.speed;}
    public String getName(){return this.name;}
}

class Armor {
    private String name; 
    private int DEF;
    Armor(String name , int def){
        this.name = name ;
        this.DEF = def;
    }
    public int getDEF(){return this.DEF;}
    public String getName(){return this.name;}
}

class HealPotion {
    private String Name;
    private int heal;
    HealPotion(String name , int hp){
        this.Name = name;
        this.heal = hp;
    } 
    public String getName(){ return this.Name; }
    public int getHeal(){ return this.heal; }
}

class HealPotionBag {
    private String Name;
    private ArrayList<HealPotion> HPB;
     HealPotionBag(String owner){
        this.Name = owner + " HealPotionBag";
        ArrayList<HealPotion> Hp = new ArrayList<HealPotion>();
        this.HPB = Hp;
     }

    public ArrayList<HealPotion> getBag(){ return this.HPB;}
    public String  getName(){ return this.Name; }

    public void addHealPotion(String potionName ,int hpst , int QTT){
        HealPotion hp = new HealPotion(potionName , hpst);
        for(int i=0 ; i<QTT ; i++){
             this.getBag().add(hp);
        }
    }

    
    public Integer openBag(int dfhp){
        Scanner Choice = new Scanner(System.in);
        System.out.println("========== " + this.getName() + " ==============");
        System.out.println();
         if (this.getBag().size() > 0){
             for (int i = 0 ; i < this.getBag().size() ; i ++){
                 System.out.println(( 1+ i) + ". " + this.getBag().get(i).getName());
                }
            }
        else{
            System.out.println("            ***EMPTY***             ");
        }
        System.out.println("0. Exit Potion Bag");
        System.out.println();
        System.out.println("=====================================");
        int  c = Choice.nextInt();
         if((c) <= this.getBag().size() && c > 0 ){
            return this.Useitem(c , dfhp);
         }
         else if (c == 0){
            return null ;
         }
         else{
            System.out.println("            ### We Dont Have That Potion ###");
            return null;
         }
    }

    public  int Useitem(int c , int dfhp){
            HealPotion slt = this.getBag().get(c-1);
            this.getBag().remove(slt);
            System.out.println();
            System.out.println("        #### HP + " + slt.getHeal()  + " ####");
            System.out.println();
            return (dfhp + slt.getHeal());
        }
}