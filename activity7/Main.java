package activity7;

public class Main {

    public static void main(String[] args) {

        SmartLight light = new SmartLight("Living Room Light");

        light.setBrightness(80);
        light.togglePower();
        light.setBrightness(80);
        light.displayStatus();

        System.out.println();

        SmartThermostat thermostat = new SmartThermostat("Home Thermostat");

        thermostat.togglePower();
        thermostat.setTemperature(25);
        thermostat.displayStatus();
    }
}
