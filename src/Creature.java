public class Creature {
    public float health;
    public String name;
    public String action;
    public int atkUses1 = 30;
    public int atkUses2 = 20;
    public int atkUses3 = 10;
    public int atkUses4 = 5;


    // Returns the damage done by the Creature
    public AttackData attack() {
        AttackData creatureAttack = new AttackData();
        creatureAttack.moveType = "Normal";
        // 20% chance of missing
        if (Rand.randomInt(0, 10) < 2) {
            creatureAttack.miss = 1; // 1 meaning yes
            action = name + " missed!";
            creatureAttack.power = 0;
            return creatureAttack;
        }

        return normalAttack();

    }
    public AttackData normalAttack() {
        AttackData normalAttack = new AttackData();

        normalAttack.moveType = "Normal"; //2 means normal

        normalAttack.power = Rand.randomFloat(10, 20);
        action = name + " attacked with power " + normalAttack.power + "!";
        return normalAttack;
    }


    public void defend(AttackData incomingPower) {

        // 10 % chance of reducing damage taken
        if (Rand.randomInt(0, 10) < 1) {
            float reduce = incomingPower.power * 0.8f;
            this.health -= reduce;
            action = name + " defended and reduced damage taken to " + reduce;
        }
        else
        {
            dmgAmplifier(incomingPower);
        }


    }

    public void dmgAmplifier(AttackData incomingPower) {
        if (incomingPower.moveType.equals("asd")){
            this.health -= incomingPower.power * 0.5F;
        }
        else if (incomingPower.miss == 1) {
            action = "Oppenent missed!";
        }
        else {
            action = name + " did not defend.";
            this.health -= incomingPower.power;
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
