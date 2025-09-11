package untitleRPG;
import java.util.ArrayList;
class floor_mon {
    private ArrayList<Monster> Mons;

    floor_mon(){
    ArrayList<Monster> MSL = new ArrayList<Monster>();
    this.Mons = MSL;
    Monster m1 = new Monster("Slime" , 250 , 5 , 65 , 20);
    this.Mons.add(m1);
    }

    public Monster getMons(){ return this.Mons.get(0); }
}