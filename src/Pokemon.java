import java.util.Random;
import java.util.Scanner;

public abstract class Pokemon {
    final Random random = new Random();
    final Scanner scanner = new Scanner(System.in);
    private int maxLvl;
    private int currentLvl;
    private int maxHp;
    private int currentHp;
    private int maxAp;
    private int currentAp;

    public abstract void removeHp();
    public abstract void removeAp();
    public void kick (Pokemon damagedPokemon){
        damagedPokemon.currentHp-=Constants.KICK_DMG;
    }
    public abstract boolean specialAbility ();
    public void turnAddHpAndAp(){
    int hpToAdd = random.nextInt(Constants.MIN_TURN_HP_ADD,Constants.MAX_TURN_HP_ADD);
    int apToAdd = random.nextInt(Constants.MIN_TURN_AP_ADD,Constants.MAX_TURN_AP_ADD);
    if (this.currentHp+hpToAdd>this.maxHp){
        this.currentHp=this.maxHp;
    }else {
        this.currentHp+=hpToAdd;
    }
        if (this.currentAp+apToAdd>this.maxAp){
            this.currentAp=this.maxAp;
        }else {
            this.currentAp+=apToAdd;
        }

    }
    public boolean waitOption() {
        boolean tripleAttackDamage = false;
        int randomOption = random.nextInt(Constants.WAIT_OPTION_1,Constants.WAIT_OPTION_3);
        switch (randomOption){
            case Constants.WAIT_OPTION_1 -> randomOptionAddHp();
            case Constants.WAIT_OPTION_2  -> randomOptionAddAp();
            case Constants.WAIT_OPTION_3  -> tripleAttackDamage=true;
        }
        return tripleAttackDamage;
    }
    private void randomOptionAddHp(){
        int hpToAdd = random.nextInt(Constants.MIN_WAIT_HP_ADD,Constants.MAX_WAIT_HP_ADD);
        if (this.currentHp+hpToAdd>this.maxHp){
            this.currentHp=this.maxHp;
        }else {
            this.currentHp+=hpToAdd;
        }
    }
    private void randomOptionAddAp(){
        int apToAdd = random.nextInt(Constants.MIN_WAIT_AP_ADD,Constants.MAX_WAIT_AP_ADD);
        if (this.currentAp+apToAdd>this.maxAp){
            this.currentAp=this.maxAp;
        }else {
            this.currentAp+=apToAdd;
        }
    }
    public abstract boolean useAttackAbility();
    public abstract void printCurrentState();

    public boolean evolve (){
        boolean isEvolvedSuccessfully = false;
        if (this.currentLvl<this.maxLvl){
            switch (this.currentLvl){
                case 1 -> {if (this.currentHp-Constants.EVOLVE_2_HP_COST>0){
                    if (this.currentAp-Constants.EVOLVE_2_AP_COST>0){
                        this.currentLvl++;
                        this.currentHp-=Constants.EVOLVE_2_HP_COST;
                        this.currentAp-=Constants.EVOLVE_2_AP_COST;
                        isEvolvedSuccessfully = true;
                    }else System.out.println("You dont have enough attack points ("+Constants.EVOLVE_2_AP_COST+")");
                }else System.out.println("You dont have enough hp ("+Constants.EVOLVE_2_HP_COST+")");
            }
            case 2 -> {if (this.currentHp-Constants.EVOLVE_3_HP_COST>0){
                    if (this.currentAp-Constants.EVOLVE_3_AP_COST>0){
                        this.currentLvl++;
                        this.currentHp-=Constants.EVOLVE_3_HP_COST;
                        this.currentAp-=Constants.EVOLVE_3_AP_COST;
                        isEvolvedSuccessfully = true;
                    }else System.out.println("You dont have enough attack points ("+Constants.EVOLVE_3_AP_COST+")");
                }else System.out.println("You dont have enough hp ("+Constants.EVOLVE_3_HP_COST+")");
            }
            }
            }else System.out.println("You are at your max level");
       return isEvolvedSuccessfully; }
    public abstract String getPokemonName ();
    }


