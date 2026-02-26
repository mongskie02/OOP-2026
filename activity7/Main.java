package activity7;

public class Main {

    public static void main(String[] args) {
        SmartLight light = new SmartLight("LIving Room Light");

        light.setBrightness(80);

        light.togglePower();
        light.setBrightness(80);
        light.displayStatus();

        System.out.println();

        SmartThermosat thermosat = new SmartThermosat("Home Thermostat");

        thermosat.togglePower();
        thermosat.setTemperature(32);
        thermosat.displayStatus();

    }

}
