package activity7;

public class SmartThermostat extends SmartDevice {

    private double temperature;

    public SmartThermostat(String deviceName) {
        super(deviceName);
        this.temperature = 20.0;
    }

    public void setTemperature(double temp) {

        if (!isOn) {
            System.out.println("Thermostat is off. Turn it on first.");
            return;
        }

        if (temp >= 10 && temp <= 30) {
            this.temperature = temp;
            System.out.println("Temperature set to " + temperature + "°C");
        } else {
            System.out.println("Temperature must be between 10°C and 30°C.");
        }
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Current Temperature: " + temperature + "°C");
    }
}
