import java.awt.*;

public abstract class Car implements Movable {

    private int NrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x = 0;
    private double y = 0;
    private int direction = 0;


    public Car(int NrDoors, Color color,
               double enginePower, String modelName) {
        this.NrDoors = NrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
    }

    public int getNrDoors() {
        return NrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }


    protected void setCurrentSpeed(double speed) {
        currentSpeed = speed;
    }

    public abstract double speedFactor();

    public void incrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    public void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    @Override
    public void turnLeft() {
        direction = (direction + 3) % 4;
    }

    @Override
    public void turnRight() {
        direction = (direction + 1) % 4;
    }

    @Override
    public void move() {
        if (direction == 0) {
            x = x + currentSpeed;
        } else if (direction == 1) {
            y = y - currentSpeed;
        } else if (direction == 2) {
            x = x - currentSpeed;
        } else if (direction == 3) {
            y = y + currentSpeed;
        }
    }

}

