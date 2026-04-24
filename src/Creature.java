public class Creature {
    private float health;
    private final String name;
    private String action;

    //getters
    public float getHealth() {
        return health;
    }
    public String getName() {return name;}

    //methods to update values
    public void updateAction(String action) {
        this.action = action;
    }
    public void reduceHealth(float reduction) {
        this.health -= reduction;
    }

    //constructor
    public Creature(float health, String name) {
        this.name = name;
        this.health = health;
    }

    // Returns the damage done by the Creature
    public AttackData attack() {
        AttackData creatureAttack = new AttackData();
        creatureAttack.moveType = "Normal";
        // 20% chance of missing
        if (Rand.randomInt(0, 10) < 2) {
            creatureAttack.miss = 1; // 1 meaning yes
            String action = name + " missed!";
            updateAction(action);
            creatureAttack.power = 0;
            return creatureAttack;
        }

        return normalAttack();

    }
    public AttackData normalAttack() {
        AttackData normalAttack = new AttackData();

        normalAttack.moveType = "Normal"; //2 means normal

        normalAttack.power = Rand.randomFloat(10, 20);
        String action = name + " attacked with power " + normalAttack.power + "!";
        updateAction(action);
        return normalAttack;
    }


    public void defend(AttackData incomingPower) {

        // 10 % chance of reducing damage taken
        if (Rand.randomInt(0, 10) < 1) {
            float reduce = incomingPower.power * 0.8f;
            reduceHealth(reduce);
            String action = name + " defended and reduced damage taken to " + reduce;
            updateAction(action);
        }
        else
        {
            dmgAmplifier(incomingPower);
        }


    }

    public void dmgAmplifier(AttackData incomingPower) {
        if (incomingPower.miss == 1) {
            String action = "Opponent missed!";
            updateAction(action);
        }
        else {
            String action = name + " did not defend.";
            updateAction(action);
            reduceHealth(incomingPower.power);
        }
    }

    public String readAction() {
        return action;
    }

    @Override
    public String toString() {
        return getClass() + "{name: " + name + ", health: " + health + "}";
    }
}
