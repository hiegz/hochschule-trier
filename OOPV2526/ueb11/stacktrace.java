public class Program {
    public static void main(String[] args) {
        try {
            // method1();
            new Object();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void method1() throws Exception {
        System.out.println("method 1");
        method2();
    }

    public static void method2() throws Exception {
        System.out.println("method 2");
        method3();
    }

    public static void method3() throws Exception {
        System.out.println("method 3");
        throw new Exception();
    }
}

class Object {
    public Object() throws Exception {
        System.out.println("constructor");
        throw new Exception();
    }
}
