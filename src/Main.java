
void main() {

    // set up the creatures
    Creature a = new Creature();
    Creature b = new Creature();
    WaterType p = new WaterType();
    FireType d = new FireType();


    p.name = "Water Man";
    p.health = 100;
    d.name = "Fire Man";
    d.health = 100;
    a.name = "A";
    a.health = 100;
    b.name = "B";
    b.health = 100;

    // set up the battle
    BattleSystem battleSystem = new BattleSystem();


    //run the battle
    battleSystem.battle(d, p);


}
