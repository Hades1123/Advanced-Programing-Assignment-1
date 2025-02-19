public class Warrior extends Fighter {
    public Warrior(int baseHp, int wp) {
        super(baseHp, wp);
    }

    @Override
    public double getCombatScore() {
        if(Utility.isPrime(Battle.GROUND)) {
            return this.getBaseHp() * 2;
        }
        if (this.getWp() == 1){
            return this.getBaseHp();
        }
        return this.getBaseHp() / 10.0;
    }
}
