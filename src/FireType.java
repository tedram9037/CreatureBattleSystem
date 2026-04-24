public class FireType extends Creature {
    int atkUses1 = 30;
    int atkUses2 = 20;
    int atkUses3 = 10;
    public FireType(float health, String name) {
        super(health, name);
    }


    @Override
    public AttackData normalAttack() {
        AttackData fireAttack = new AttackData();
        fireAttack.moveType = "Fire";
        boolean doneAttack = false;
        while (!doneAttack) {
            int move = Rand.randomInt(1, 4);
            if (Rand.randomInt(0, 10) < 2) {
                String action = getName() + " missed!";
                updateAction(action);
                fireAttack.power = 0;
            }
            switch (move) {
                case 1:
                    if (atkUses1 > 0) {
                        this.atkUses1--;
                        fireAttack.power = 10;
                        doneAttack = true;
                    }
                    break;
                case 2:
                    if (atkUses2 > 0) {
                        this.atkUses1--;
                        fireAttack.power = 10;
                        doneAttack = true;
                    }
                    break;
                case 3:
                    if (atkUses3 > 0) {
                        this.atkUses1--;
                        fireAttack.power = 10;
                        doneAttack = true;
                    }
                    break;
            }
        }


        String action = getName() + " attacked with a fire type move!";
        updateAction(action);

        return fireAttack;
    }

    @Override
    public void dmgAmplifier(AttackData incomingPower) {
        if (incomingPower.moveType.equals("Water")) {
            float reduce = incomingPower.power * 5;
            reduceHealth(reduce);
        } else if (incomingPower.miss == 1) {
            String action = "Opponent missed!";
            updateAction(action);
        } else {
            reduceHealth(incomingPower.power);
            String action = getName() + " did not defend.";
            updateAction(action);
        }
    }
}


