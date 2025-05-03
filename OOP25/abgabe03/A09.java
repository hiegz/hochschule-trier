public class A09 {

    public static void main(String[] args) {
        int fact = 1, i = 1;
        do {
            fact *= i;
            i++;
        } while (i < 6);
        System.out.println(fact);
    }
}
