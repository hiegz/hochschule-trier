import java.util.Scanner;

public class Time24 {
    private int hour;
    private int minute;

    public Time24(int hour, int minute) {
        this.setHour(hour);
        this.setMinute(minute);
    }

    public Time24() {
        this.setHour(0);
        this.setMinute(0);
    }

    public Time24(Time24 src) {
        this(src.hour, src.minute);
    }

    public void readTime() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();

        String[] input = line.split(":");
        if (input.length != 2)
            throw new RuntimeException("Falsches Zeitformat");
        this.hour = Integer.parseInt(input[0]);
        this.minute = Integer.parseInt(input[1]);

        this.normalizeTime();
    }

    public void writeTime() {
        System.out.println(this.toString());
    }

    public String toString() {
        return String.format("%02d:%02d", this.hour, this.minute);
    }

    public void addTime(int minute) {
        assert minute >= 0;

        this.minute += minute;
        this.normalizeTime();
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int hour) {
        assert hour >= 0 && hour < 60;
        this.hour = hour % 24;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setMinute(int minute) {
        assert minute >= 0 && minute < 60;
        this.minute = minute;
    }

    private void normalizeTime() {
        this.hour += this.minute / 60;
        this.hour %= 24;
        this.minute %= 60;
    }

    public static void main(String[] args) {
        Time24 sanfrancisco;
        Time24 frankfurt;
        Time24 melbourne;

        System.out.print("Die aktuelle Uhrzeit in San Francisco ist ");
        sanfrancisco = new Time24();
        sanfrancisco.readTime();

        frankfurt = new Time24(sanfrancisco);
        frankfurt.addTime(9 * 60);

        melbourne = new Time24(sanfrancisco);
        melbourne.addTime(17 * 60);

        System.out.printf("Die aktuelle Uhrzeit in Frankfurt     ist %s (+9hr)\n", frankfurt.toString());
        System.out.printf("Die aktuelle Uhrzeit in Melbourne     ist %s (+17hr)\n", melbourne.toString());
    }
}
