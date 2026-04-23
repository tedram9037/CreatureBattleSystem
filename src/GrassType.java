public class GrassType extends  Creature{
    public GrassType(float health) {
        super(health);
    }

    @Override
    public AttackData normalAttack() {
        AttackData grassAttack = new AttackData();
        grassAttack.moveType = "Grass";
        boolean doneAttack = false;
        while (!doneAttack){
            int move = Rand.randomInt(1,4);
            if (Rand.randomInt(0, 10) < 2) {
                action = name + " missed!";
                grassAttack.power = 0;
            }
            switch (move) {
                case 1:
                    if (atkUses1 > 0) {
                        this.atkUses1--;
                        grassAttack.power = 10;
                        doneAttack = true;
                    }
                    break;
                case 2:
                    if (atkUses2 > 0) {
                        this.atkUses1--;
                        grassAttack.power = 10;
                        doneAttack = true;
                    }
                    break;
                case 3:
                    if (atkUses3 > 0) {
                        this.atkUses1--;
                        grassAttack.power = 10;
                        doneAttack = true;
                    }
                    break;
            }
        }
        action = name + " attacked with a fire type move!" + grassAttack.power + "!";

        return grassAttack;
    }
    @Override
    public void dmgAmplifier(AttackData incomingPower) {
        if (incomingPower.moveType.equals("Fire")){
            super.health -= incomingPower.power * 5;
            action = name + " is weak against water!";
        }
        else if (incomingPower.miss == 1) {
            action = "Opponent missed!";
        }
        else {
            action = name + " did not defend.";
        }
    }

}
