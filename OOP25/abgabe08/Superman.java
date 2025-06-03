public class Superman implements vergesslich {
    private String realName;
    private int knowledge;
    private Mission personalMission;
    private double personalTime;

    private static int superheroes = 0;

    public Superman(String realName, int knowledge, Mission personalMission, double personalTime) {
        this.realName = realName;
        this.knowledge = knowledge;
        this.personalMission = personalMission;
        this.personalTime = personalTime;

        superheroes += 1;
    }

    public void kaempfen(int zeit) {
        zeit *= this.personalMission.getDifficulty() / (double) this.knowledge;

        if (zeit > this.personalTime) {
            this.personalTime = 0;
            System.out.println("Die Zeit ist abgelaufen");
        } else {
            this.personalTime -= zeit;
        }

        this.personalMission.adjustMissionTime(zeit);
    }

    public void ueben() {
        this.knowledge += 1;
    }

    public String toString() {
        return String.format(
                "Name = %s, Wissensstand = %d, Anzahl der Superhelden = %d, Zeit = %.2f",
                this.realName,
                this.knowledge,
                Superman.superheroes,
                this.personalTime);
    }

    public void vergessen() {
        this.knowledge -= 1;
    }

    public static void main(String[] args) {
        Superman superman = new Superman("Superman", 1024 / 2, new Mission(1024, 1024), 1024);
        System.out.println(superman.toString());
        System.out.println("...");
        superman.kaempfen(1024 / 2 + 1);
        System.out.println(superman.toString());
    }
}
