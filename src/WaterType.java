public class WaterType extends Creature{



    @Override
    public void normalAttack() {
        data.moveType = 1; // 1 means water

        // 20% chance of missing
        if (Rand.randomInt(0, 10) < 2) {
            action = name + " missed!";
            data.power = 0;
        }
        int move = Rand.randomInt(1,4);
        float power = 1;

        switch (move) {
            case 1:
                atkUses1--;
                data.power = 10;
                break;
            case 2:
                atkUses2--;
                data.power = 10;
                break;
            case 3:
                atkUses3--;
                data.power = 10;
                break;
        }


        action = name + " attacked with a water type move! " + power + "!";
    }
    @Override
    public void dmgAmplifier(AttackData incomingPower) {
        if (incomingPower.moveType == 4){
            health -= incomingPower.power * 0.5F;
        }
        else {
            action = name + " did not defend.";
        }
    }
}
