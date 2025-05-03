public class A32 {
    public static void main(String[] args) {
        int i = 0, sum = 0;
        while (i < 8) {
            if (i % 2 == 1) {
                i++;
                continue;
            } else {
                sum += i;
                i++;
            }
        }
        System.out.println(sum);
    }
}
