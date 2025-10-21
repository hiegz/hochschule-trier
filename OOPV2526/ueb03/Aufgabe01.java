interface I {}
interface J extends I {}
class A implements I {}
class B extends A implements J {}

public class Aufgabe01 {
    public static void main(String[] args) {
        A a1 = new B();
        // B b1 = new A();
        I i1 = new A();
        I i2 = new B();
        // A a2 = new I();
        // B b2 = new I();
        // J j1 = new A();
        J j2 = new B();
        // A a3 = new J();
        // B b3 = new J();

        // (c)
        parameteruebergabe(new B());

        // (d)
        A a2 = rueckgabewert();

        // (e)
        J j = (J)Dummy.createObject();
    }

    // (c)
    static void parameteruebergabe(A parameter) {}

    // (d)
    static A rueckgabewert() {
        return new B();
    }
}

// (e)
class Dummy {
    public static I createObject() {
        // (f)
        return new B();
    }
}
