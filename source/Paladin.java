public class Paladin extends Knight {
	public Paladin(int baseHp, int wp) {
		super(baseHp, wp);
	}

	@Override
	public double getCombatScore() {
		int[] fibo = new int[47];
		fibo[0] = 0;
		fibo[1] = 1;
		for (int i = 2 ; i < 47; ++ i){
			fibo[i] = fibo[i-1] + fibo[i-2];
		}

		for (int i = 3 ; i < 47; ++ i){
			if (fibo[i] == this.getBaseHp()){
				return 1000.0 + i;
			}
		}
		return this.getBaseHp() * 3.0;
	}
}
