//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public abstract class Monster {
    private Complex mMana;

    public Monster(Complex mana) {
        this.mMana = mana;
    }

    public String toString() {
        return String.format("%s{%s}", this.getClass().getName(), this.mMana);
    }

    public Complex getMana() {
        return this.mMana;
    }
}
