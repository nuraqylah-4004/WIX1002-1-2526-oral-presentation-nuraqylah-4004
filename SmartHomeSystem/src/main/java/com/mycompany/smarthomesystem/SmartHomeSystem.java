/*
* Oral Presentation: WIX 1002 - Fundamentals of Programming
* System Name   : Smart Home Automation System
* Name          : Raja Nur Aqylah Natasha binti Raja Zazman Shah
* Matric Number : 25004004
* Date          : 08/01/2026
*/

package com.mycompany.smarthomesystem;

import java.util.ArrayList;
import java.util.List;

// interface for controllable devices
interface Controllable {
    void turnOn();
    void turnOff();
}

// abstract base class for devices
abstract class Device implements Controllable {
    protected String deviceName;
    protected boolean status; // true = ON, false = OFF

    // constructor
    public Device(String deviceName) {
        this.deviceName = deviceName;
        this.status = false; // default OFF
    }

    // display current status
    public void displayStatus() {
        System.out.println(deviceName + " is " + (status ? "ON" : "OFF"));
    }
}

// subclass for light
class Light extends Device {
    private int brightness; // brightness level 0-100

    // constructor
    public Light(String deviceName, int brightness) {
        super(deviceName);
        this.brightness = brightness;
    }

    @Override
    public void turnOn() {
        status = true;
        System.out.println(deviceName + " is turned ON. Brightness: " + brightness + "%");
    }

    @Override
    public void turnOff() {
        status = false;
        System.out.println(deviceName + " is turned OFF.");
    }
}

// subclass for fan
class Fan extends Device {
    private int speed; // fan speed 1-5

    // constructor
    public Fan(String deviceName, int speed) {
        super(deviceName);
        this.speed = speed;
    }

    @Override
    public void turnOn() {
        status = true;
        System.out.println(deviceName + " is turned ON. Speed: " + speed);
    }

    @Override
    public void turnOff() {
        status = false;
        System.out.println(deviceName + " is turned OFF.");
    }
}

// subclass for thermostat
class Thermostat extends Device {
    private double temperature; // desired temperature in °C

    // constructor
    public Thermostat(String deviceName, double temperature) {
        super(deviceName);
        this.temperature = temperature;
    }

    @Override
    public void turnOn() {
        status = true;
        System.out.println(deviceName + " is turned ON. Temperature: " + temperature + "°C");
    }

    @Override
    public void turnOff() {
        status = false;
        System.out.println(deviceName + " is turned OFF.");
    }
}

// main class
public class SmartHomeSystem {
    public static void main(String[] args) {
        System.out.println("=== Smart Home Automation System ===");

        // devices
        Device light1 = new Light("Living Room Light", 80);
        Device fan1 = new Fan("Bedroom Fan", 2);
        Device thermostat1 = new Thermostat("Hall Thermostat", 24.0);

        // put devices in a list for polymorphism
        List<Device> devices = new ArrayList<>();
        devices.add(light1);
        devices.add(fan1);
        devices.add(thermostat1);

        // turn on all devices
        System.out.println("\nTurning on all devices:");
        for (Device d : devices) d.turnOn();

        // display status of all devices
        System.out.println("\nDevice status:");
        for (Device d : devices) d.displayStatus();

        // turn off all devices
        System.out.println("\nTurning off all devices:");
        for (Device d : devices) d.turnOff();

        // final status
        System.out.println("\nFinal device status:");
        for (Device d : devices) d.displayStatus();
    }
}
