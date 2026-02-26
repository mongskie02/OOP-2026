package activity7;

public class SmartLight extends SmartDevice {

    private int brightness;

    public SmartLight(String deviceName) {
        super(deviceName);
        this.brightness = 0;
    }

    public void setBrightness(int level) {
        if (!isOn) {
            System.out.println("Light is off. Turn it on first.");
            return;
        }

        if (level >= 0 && level <= 100) {
            this.brightness = level;
        } else {
            System.out.println("Brightness must be between 0 and 100.");
        }
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Brightness: " + brightness);
    }
}
