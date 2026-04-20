public class Creature {
    public float health;
    public String name;
    public String action;
    public String moveType;
    public int atkUses1;
    public int atkUses2;
    public int atkUses3;
    public int atkUses4;


    // Returns the damage done by the Creature
    public float attack() {

        // 20% chance of missing
        if (Rand.randomInt(0, 10) < 2) {
            action = name + " missed!";
            return 0;
        }

        return normalAttack();

    }
    public float normalAttack() {
        this.moveType = "Normal";
        // otherwise, do damage between 10-20
        float power = Rand.randomFloat(10, 20);
        action = name + " attacked with power " + power + "!";
        return power;
    }

    public void defend(float incomingPower) {

        // 10 % chance of reducing damage taken
        if (Rand.randomInt(0, 10) < 1) {
            incomingPower = incomingPower * 0.8f;
            action = name + " defended and reduced damage taken to " + incomingPower;
        }
        else
        {
            action = name + " did not defend.";
        }

        if (moveType.equals("Fire")){
            health -= incomingPower*0.5;
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
