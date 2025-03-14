//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Random;

public class Battle {
    private static final double RATE_WIN = (double)0.5F;
    private static final int GROUND_BOUND = 999;
    public static int GROUND = 1;
    private Combatable[] mTeam1;
    private Combatable[] mTeam2;

    public static void moveRandomGround() {
        Random var0 = new Random();
        GROUND = var0.nextInt(999) + 1;
        System.out.println(" Moving to ground " + GROUND + ".");
    }

    public Battle(Combatable[] var1, Combatable[] var2) {
        this.mTeam1 = var1;
        this.mTeam2 = var2;
    }

    public void combat() {
        double var1 = (double)0.0F;

        for(int var3 = 0; var3 < this.mTeam1.length; ++var3) {
            double var4 = this.duel(this.mTeam1[var3], this.mTeam2[var3]);
            var1 += var4;
            if (var3 == 0 && var4 >= (double)0.5F) {
                moveRandomGround();
            }
        }

        var1 /= (double)this.mTeam1.length;
        System.out.println(" Battle result. pR = " + var1);
    }

    private double duel(Combatable var1, Combatable var2) {
        double var3 = var1.getCombatScore();
        double var5 = var2.getCombatScore();
        double var7 = (var3 - var5 + (double)999.0F) / (double)2000.0F;
        return var7;
    }
}
