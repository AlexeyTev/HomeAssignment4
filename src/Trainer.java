import java.util.Scanner;

public class Trainer {
    private String name;

    public Trainer(String name, Pokemon pokemon) {
        this.name = name;
        this.pokemon = pokemon;
    }

    public String getName() {
        return name;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    @Override
    public String toString() {
        return this.name + "("+this.pokemon.getPokemonName()+")";
    }

    Pokemon pokemon;
    public void turnOptions(){
        Scanner scanner = new Scanner(System.in);
        pokemon.turnAddHpAndAp();
        boolean success = false;
        boolean gotTripleDamageNextTurn = false;
        do {
            System.out.println(this.name + ", Chose what you want to do next (1 per turn):\n" +
                    Constants.ATTACK_ABILITY_OPTION + ")Use attack ability\n" +
                    Constants.WAIT_OPTION + ")Wait\n" +
                    Constants.EVOLVE_OPTION + ")Evolve\n" +
                    Constants.SPECIAL_ABILITY_OPTION + ")Ultimate ability");
            int userChoice;
            do {
                userChoice = scanner.nextInt();
            } while (userChoice > Constants.SPECIAL_ABILITY_OPTION || userChoice < Constants.ATTACK_ABILITY_OPTION);
            switch (userChoice) {
                case Constants.ATTACK_ABILITY_OPTION -> success = pokemon.useAttackAbility();
                case Constants.WAIT_OPTION -> {gotTripleDamageNextTurn = pokemon.waitOption() ; success=true;}
                case Constants.EVOLVE_OPTION -> {success = pokemon.evolve();if (success){
                    System.out.println(this.pokemon.getPokemonName()+", evolved successfully");}
                }
                case Constants.SPECIAL_ABILITY_OPTION -> success = pokemon.specialAbility();
            }
        }while (!success);
    }
    }
