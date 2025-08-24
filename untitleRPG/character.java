package untitleRPG;
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
    

    public Player() {        
    } 

    public int getHP() { return super.getHP();}
    public int getDEF() { return super.getDEF();}
    public int getATK() { return super.getATK();}
    public int getSPD() { return super.getSPD();}
    public String getName() {return super.getName();}

    public String getWeapon(){
        return this.Weapon.getName(); }
    public String getArmor(){
        return this.Armor.getName(); }
    
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

    public void equipArmor (String Choose_Armor){
        if (Choose_Armor.equalsIgnoreCase("Low") || Choose_Armor.equalsIgnoreCase("1")) {
            this.setArmor("Low", 50);
        }

        else if (Choose_Armor.equalsIgnoreCase("Mid") || Choose_Armor.equalsIgnoreCase("2")) {
            this.setArmor("Mid", 100);
        }

        else if (Choose_Armor.equalsIgnoreCase("High") || Choose_Armor.equalsIgnoreCase("3")) {
            this.setArmor("High", 150);
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
}