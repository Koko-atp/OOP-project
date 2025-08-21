package untitleRPG;
class character {
    protected int HP = 100;
    protected int Armor = 50;
    protected int ATK;
    protected int SPD;

}

class Player extends character {
    protected String name;
    protected Weapon weapon;
}

class Monster extends character{
    private String name;
    private int ATK;
    private int SPD;
}
