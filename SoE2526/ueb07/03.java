public class Main {
    public static void main(String[] args) {
        System.out.println();
        KitchenDevice.test(new Toster());
        System.out.println();
        KitchenDevice.test(new CoffeeMachine());
        System.out.println();
        KitchenDevice.test(new Oven());
        System.out.println();
        KitchenDevice.test(new Mixer());
        System.out.println();
        KitchenDevice.test(new KitchenMachine());
    }
}

interface KitchenDevice {
    void on();

    void off();

    static void test(KitchenDevice device) {
        System.out.println(device.getClass().getSimpleName());

        System.out.println("================================");
        System.out.println("Turning on ...");
        device.on();

        System.out.println("================================");
        System.out.println("Turning off ...");
        device.off();

        System.out.println("================================");
    }
}

abstract class AbstractKitchenDevice implements KitchenDevice {
    private boolean isOn = false;
    private LightIndicator lightIndicator = new LightIndicator();

    @Override
    public final void on() {
        if (isOn) {
            return;
        }

        isOn = true;
        lightIndicator.on();
        onActivation();
    }

    @Override
    public final void off() {
        if (!isOn) {
            return;
        }

        isOn = false;
        lightIndicator.off();
        onDeactivation();
    }

    public abstract void onActivation();

    public abstract void onDeactivation();
}

class LightIndicator {
    public void on() {
        System.out.println("Indicator Light: on");
    }

    public void off() {
        System.out.println("Indicator Light: off");
    }
}

abstract class HeatingDevice extends AbstractKitchenDevice {
    HeatingElement heatingElement = new HeatingElement();

    @Override
    public void onActivation() {
        heatingElement.on();
    }

    @Override
    public void onDeactivation() {
        heatingElement.off();
    }
}

class HeatingElement {
    public void on() {
        System.out.println("Heating Element : on");
    }

    public void off() {
        System.out.println("Heating Element : off");
    }
}

abstract class MotorDevice extends AbstractKitchenDevice {
    Motor motor = new Motor();

    @Override
    public void onActivation() {
        motor.on();
    }

    @Override
    public void onDeactivation() {
        motor.off();
    }
}

class Motor {
    public void on() {
        System.out.println("Motor : on");
    }

    public void off() {
        System.out.println("Motor : off");
    }
}

final class Toster extends HeatingDevice {
}

final class CoffeeMachine extends HeatingDevice {
}

final class Oven extends HeatingDevice {
}

final class Mixer extends MotorDevice {
}

final class KitchenMachine extends MotorDevice {
}
