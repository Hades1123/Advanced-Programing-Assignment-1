public class Warrior extends Fighter {
    public Warrior(int baseHp, int wp) {
        super(baseHp, wp);
    }
    public boolean isPrime(int x){
        for (int i = 2 ; i <= Math.sqrt(x) ; i++){
            if (x % i == 0){
                return false;
            }
        }
        return x > 1;
    }
    @Override
    public double getCombatScore() {
        if(isPrime(Battle.GROUND)) {
            return this.getBaseHp() * 2;
        }
        if (this.getWp() == 1){
            return this.getBaseHp();
        }
        return this.getBaseHp() / 10.0;
    }
}
