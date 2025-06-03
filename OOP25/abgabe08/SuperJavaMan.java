public class SuperJavaMan extends Superman {
    public SuperJavaMan() {
        super("Super Java Man", 1024 * 1024, new Mission(1024, 1024), 1024 * 1024);
    }

    public SuperJavaMan(String realName, int knowledge, Mission personalMission, double personalTime) {
        super(realName, knowledge, personalMission, personalTime);
    }

    public static void main(String[] args) {
        Superman superJavaMan = new SuperJavaMan();
        System.out.println(superJavaMan.toString());
    }
}
