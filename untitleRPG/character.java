package untitleRPG;
abstract class character {
    private String name;
    private int HP = 100;
    private int Armor = 50;
    private int ATK;
    private int SPD;

    public int getHP() { return this.HP;}
    public int getArmor() { return this.Armor;}
    public int getATK() { return this.ATK;}
    public int getSPD() { return this.SPD;}
    public String getName() {return this.name;}
}

class Player extends character {
    private Weapon weapon;
    private Armor armor;

}

class Monster extends character{

    Monster(String name){
    }
}