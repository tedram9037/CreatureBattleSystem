public class GrassType extends  Creature{
    int atkUses1 = 30;
    int atkUses2 = 20;
    int atkUses3 = 10;
    public GrassType(float health, String name) {
        super(health, name);
    }

    @Override
    public AttackData normalAttack() {
        AttackData grassAttack = new AttackData();
        grassAttack.moveType = "Grass";
        boolean doneAttack = false;
        while (!doneAttack){
            int move = Rand.randomInt(1,4);
            if (Rand.randomInt(0, 10) < 2) {
                String action = getName() + " missed!";
                updateAction(action);
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
        String action = getName() + " attacked with a fire type move!" + grassAttack.power + "!";
        updateAction(action);
        return grassAttack;
    }
    @Override
    public void dmgAmplifier(AttackData incomingPower) {
        if (incomingPower.moveType.equals("Fire")){
            float reduce = incomingPower.power * 5;
            reduceHealth(reduce);
            String action = getName() + " is weak against water!";
            updateAction(action);
        }
        else if (incomingPower.miss == 1) {
            String action = "Opponent missed!";
            updateAction(action);
        }
        else {
            reduceHealth(incomingPower.power);
            String action = getName() + " did not defend.";
            updateAction(action);
        }
    }

}
