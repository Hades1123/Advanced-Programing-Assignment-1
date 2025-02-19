//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Human {
    private int mBaseHp;

    public Human(int baseHp) {
        this.mBaseHp = baseHp;
    }

    public int getBaseHp() {
        return this.mBaseHp;
    }

    public String toString() {
        return String.format("%s{%d}", this.getClass().getName(), this.getBaseHp());
    }
}
