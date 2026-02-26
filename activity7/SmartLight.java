package activity7;

public class SmartLight extends SmartDevice {

    private int brightness;
    private boolean on;

    public SmartLight(String deviceName) {
        super(deviceName);
        this.brightness = 0;
        this.on = false;
    }

    public boolean isOn() {
        return on;
    }

    public void turnOn() {
        this.on = true;
    }

    public void turnOff() {
        this.on = false;
    }

    public void displayStatus() {
        System.out.println("Light is " + (isOn() ? "On" : "Off") + ", Brightness: " + brightness);
    }

    public void setBrightness(int level) {
        if (isOn()) {
            this.brightness = level;
        }

    }

}
