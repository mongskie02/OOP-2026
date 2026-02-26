package activity7;

public class SmartThermosat extends SmartDevice {

    private double temperature;

    public SmartThermosat(String deviceName) {
        super(deviceName);
    }

    public void displayStatus() {
        super.displayStatus();
        System.out.println("Current Temperature: " + temperature + "°C");
    }

    public void setTemperature(double temp) {
        if (temp >= 10 && temp <= 30) {
            this.temperature = temp;
            System.out.println("Temperature set to " + temperature + "°C");
        } else {
            System.out.println("Temperature must be between 10°C and 30°C");
        }
    }

}
