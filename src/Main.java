
void main() {

    // set up the creatures
    Creature a = new Creature(100);
    Creature b = new Creature(100);
    WaterType p = new WaterType(100);
    FireType d = new FireType(100);


    p.name = "Water Man";
    d.name = "Fire Man";
    a.name = "A";
    b.name = "B";

    // set up the battle
    BattleSystem battleSystem = new BattleSystem();


    //run the battle
    battleSystem.battle(d, p);


}
