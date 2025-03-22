package adapter;

/*
Implement the Adapter design pattern.

The Adapter is a structural design pattern that allows incompatible interfaces to work together. 
It wraps an existing class with a new interface so that it becomes compatible with the client's interface. 
You are given completed SquareHole, Square and Circle classes. 
A Square fits into a SquareHole if the Square's side length is less than or equal to the SquareHole's length. 
A Circle has a radius and a Circle fits into a SquareHole if the Circle's diameter is less than or equal to the SquareHole's length.
Complete the implementation of the CircleToSquareAdapter class such that it adapts a Circle to a Square.
 */

/**
 * The SquareHole class represents a square hole with a specific side length.
 * It provides a method to check if a given square can fit into the hole.
 */
class SquareHole {
    private double sideLength;

    public SquareHole(double sideLength) {
        this.sideLength = sideLength;
    }

    public boolean canFit(Square square) {
        return this.sideLength >= square.getSideLength();
    }
}

/**
 * The Square class represents a square with a specific side length.
 */
class Square {
    private double sideLength;

    public Square() {
    }

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return this.sideLength;
    }
}

/**
 * The Circle class represents a circle with a specific radius.
 */
class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }
}

/**
 * The CircleToSquareAdapter class adapts a Circle to be used as a Square.
 * It extends the Square class and overrides the getSideLength method to
 * provide the equivalent side length for the circle.
 */
class CircleToSquareAdapter extends Square {
    Circle circle;

    public CircleToSquareAdapter(Circle circle) {
        this.circle = circle;
    }

    @Override
    public double getSideLength() {
        return this.circle.getRadius() * 2;
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        SquareHole squareHole = new SquareHole(5);

        Square square = new Square(5);
        System.out.println("Square fits: " + squareHole.canFit(square));

        Circle circle = new Circle(5);
        CircleToSquareAdapter circleAdapter = new CircleToSquareAdapter(circle);
        System.out.println("Circle fits: " + squareHole.canFit(circleAdapter));
    }
}