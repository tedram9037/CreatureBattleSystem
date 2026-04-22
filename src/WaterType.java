public class WaterType extends Creature{
    @Override
    public AttackData normalAttack() {
        AttackData waterAttack = new AttackData();
        waterAttack.moveType = "Water";
        boolean doneAttack = false;

        while (!doneAttack){
            int move = Rand.randomInt(1,4);
            if (Rand.randomInt(0, 10) < 2) {
                action = name + " missed!";
                waterAttack.power = 0;
            }
            switch (move) {
                case 1:
                    if (atkUses1 > 0) {
                        this.atkUses1--;
                        waterAttack.power = 10;
                        doneAttack = true;
                    }
                    break;
                case 2:
                    if (atkUses2 > 0) {
                        this.atkUses1--;
                        waterAttack.power = 10;
                        doneAttack = true;
                    }
                    break;
                case 3:
                    if (atkUses3 > 0) {
                        this.atkUses1--;
                        waterAttack.power = 10;
                        doneAttack = true;
                    }
                    break;
            }
        }
        action = name + " attacked with a water type move!";
        return waterAttack;
    }

    @Override
    public void dmgAmplifier(AttackData incomingPower) {
        if (incomingPower.moveType.equals("Fire")){
            health -= incomingPower.power * 0.5F;
            action = name + " is strong against fire!";
        }
        else if (incomingPower.miss == 1) {
            action = "Opponent missed!";
        }
        else {
            action = name + " did not defend.";
        }
    }
}
