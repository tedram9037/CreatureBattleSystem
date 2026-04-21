import java.sql.SQLOutput;

public class BattleSystem {
    public void battle(Creature a, Creature b) {
        while (a.health > 0 && b.health > 0) {
            b.defend(a.data);
            System.out.println(a.readAction());
            System.out.println(b.readAction());

            System.out.println(a);
            System.out.println(b);
            System.out.println();

            // swap turns
            Creature temp = a;
            a = b;
            b = temp;
        }
    }
}
