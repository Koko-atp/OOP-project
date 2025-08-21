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

    public void setName(String name){ this.name = name;}
    public void setHP(int HP){ this.HP = HP;}
    public void setArmor(int Amr){ this.Armor = Amr;}
    public void setATK(int Atk){ this.ATK = Atk;}
    public void setSPD(int Spd){ this.SPD = Spd;}
}

class Player extends character {
    private Weapon weapon;
    private Armor armor;
    Player(String name){
        super.setName(name);
    }

    public void EquipWeapon(String name , int atk , int speed){
        Weapon w1 = new Weapon(name , atk , speed);
        this.weapon = w1;
        int ina = this.weapon.getATK();
        String n = this.weapon.getName();
        super.setATK(super.getATK() + ina);
        System.out.println("Equip : " + n);
    }
}

class Monster extends character{
    Monster(String name ){
        super.setName(name);
    }
}