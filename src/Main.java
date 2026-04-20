public class    Main {
    public static void main(String[] args) {

        // set up the creatures
        Creature a = new Creature();
        Creature b = new Creature();
        a.name = "A";
        a.health = 100;
        b.name = "B";
        b.health = 100;

        // set up the battle
        BattleSystem battleSystem = new BattleSystem();

        // run the battle
        battleSystem.battle(a, b);
    }
}
