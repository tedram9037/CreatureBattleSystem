public class Creature {
    public float health;
    public String name;
    public String action;
    public AttackData data = new AttackData();
    public int atkUses1 = 30;
    public int atkUses2 = 20;
    public int atkUses3 = 10;
    public int atkUses4 = 5;


    // Returns the damage done by the Creature
    public void attack() {
        data.moveType = 1; // 1 means normal

        // 20% chance of missing
        if (Rand.randomInt(0, 10) < 2) {
            action = name + " missed!";
            data.power = 0;
        }

        normalAttack();

    }
    public void normalAttack() {
        data.moveType = 2; //2 means normal

        data.power = Rand.randomFloat(10, 20);
        action = name + " attacked with power " + data.power + "!";
    }


    public void defend(AttackData incomingPower) {

        // 10 % chance of reducing damage taken
        if (Rand.randomInt(0, 10) < 1) {



            float reduce = incomingPower.power * 0.8f;

            action = name + " defended and reduced damage taken to " + reduce;
        }
        else
        {
            dmgAmplifier(incomingPower);
        }


    }

    public void dmgAmplifier(AttackData incomingPower) {
        if (incomingPower.moveType == 1){
            health -= incomingPower.power * 0.5F;
        }
        else {
            action = name + " did not defend.";
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
