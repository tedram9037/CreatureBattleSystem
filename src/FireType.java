public class FireType extends Creature{
    public String type;



    @Override
    public float normalAttack() {
        this.moveType = "Fire";

        // 20% chance of missing
        if (Rand.randomInt(0, 10) < 2) {
            action = name + " missed!";
            return 0;
        }


        int move = Rand.randomInt(1,4);
        float power = 1;

        switch (move) {
            case 1:
                atkUses1 = 10;
                atkUses1--;
                power = 10;
                break;
            case 2:
                atkUses2 = 10;
                atkUses2--;
                power = 10;
                break;
            case 3:
                atkUses1 = 10;
                atkUses2--;
                power = 10;
                break;



        }


        action = name + " attacked with power " + power + "!";
        return power;

    }


}
