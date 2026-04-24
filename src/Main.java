
void main() {

    // set up the creatures
    Creature a = new Creature(100, "A");
    Creature b = new Creature(100, "B");
    WaterType p = new WaterType(100, "Water Man");
    FireType d = new FireType(100, "Fire Man");

    // set up the battle
    BattleSystem battleSystem = new BattleSystem();


    //run the battle
    battleSystem.battle(d, p);


}
