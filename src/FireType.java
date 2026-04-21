public class FireType extends Creature{



    @Override
    public void normalAttack() {
        data.moveType = 3; // 3 means fire
        // 20% chance of missing
        if (Rand.randomInt(0, 10) < 2) {
            action = name + " missed!";
            data.power = 0;
        }


        int move = Rand.randomInt(1,4);
        float power = 1;

        switch (move) {
            case 1:
                atkUses1 = 10;
                atkUses1--;
                data.power = 10;
                break;
            case 2:
                atkUses2 = 10;
                atkUses2--;
                data.power = 10;
                break;
            case 3:
                atkUses1 = 10;
                atkUses2--;
                data.power = 10;
                break;



        }


        action = name + " attacked with a fire type move!" + data.power + "!";

    }


}
