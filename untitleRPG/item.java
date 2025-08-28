package untitleRPG;
import java.util.ArrayList;

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
