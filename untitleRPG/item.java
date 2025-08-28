package untitleRPG;
import java.util.ArrayList ;
import java.util.Scanner;

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

    
    public Double openBag(double dfhp){
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

    public  double Useitem(int c , double dfhp){
            HealPotion slt = this.getBag().get(c-1);
            this.getBag().remove(slt);
            System.out.println();
            System.out.println("        #### HP + " + slt.getHeal()  + " ####");
            System.out.println();
            return (dfhp + slt.getHeal());
        }
}