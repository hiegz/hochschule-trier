package shopexample.gui;

public class WindowsReporter implements Reporter {
    public void report(String message) {
        System.out.println("GUI: " + message);
    }
}
