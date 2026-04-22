public class FireType extends Creature{



    @Override
    public AttackData normalAttack() {
        AttackData fireAttack = new AttackData();
        fireAttack.moveType = "Fire";
        boolean doneAttack = false;
        while (!doneAttack){
            int move = Rand.randomInt(1,4);
            if (Rand.randomInt(0, 10) < 2) {
                action = name + " missed!";
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


        action = name + " attacked with a fire type move!";

        return fireAttack;
    }
    @Override
    public void dmgAmplifier(AttackData incomingPower) {
        if (incomingPower.moveType.equals("Water")){
            health -= incomingPower.power * 5;
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
