public class A04 {
    public static void main(String[] args) {
        int n = 0, jahr = 1980;
        while (jahr <= 1989) {
            if (jahr % 4 == 0)
                n++;
            jahr++;
        }
        System.out.println(n);
    }
}
