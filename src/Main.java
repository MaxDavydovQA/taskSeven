interface Shape {

    double calculatePerimeter();
    double calculateArea();

    String getFillColor();
    String getBorderColor();

    default double calculatePerimeter(double... sides) {
        double perimeter = 0;
        for (double side : sides) {
            perimeter += side;
        }
        return perimeter;
    }

    default double calculateArea(double... sides) {
        return sides[0] * sides[1];
    }
}

class Circle implements Shape {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return calculatePerimeter(width, height);
    }

    @Override
    public double calculateArea() {
        return calculateArea(width, height);
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Triangle implements Shape {
    private double side1;
    private double side2;
    private double side3;
    private String fillColor;
    private String borderColor;

    public Triangle(double side1, double side2, double side3, String fillColor, String borderColor) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return calculatePerimeter(side1, side2, side3);
    }

    @Override
    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5, "Red", "Black");
        Rectangle rectangle = new Rectangle(3, 4, "Blue", "Green");
        Triangle triangle = new Triangle(3, 4, 5, "Yellow", "Orange");

        System.out.println("Круг:");
        System.out.println("Периметр: " + circle.calculatePerimeter());
        System.out.println("Площадь: " + circle.calculateArea());
        System.out.println("Цвет заливки: " + circle.getFillColor());
        System.out.println("Цвет границы: " + circle.getBorderColor());

        System.out.println("\nПрямоугольник:");
        System.out.println("Периметр: " + rectangle.calculatePerimeter());
        System.out.println("Площадь: " + rectangle.calculateArea());
        System.out.println("Цвет заливки: " + rectangle.getFillColor());
        System.out.println("Цвет границы: " + rectangle.getBorderColor());

        System.out.println("\nТреугольник:");
        System.out.println("Периметр: " + triangle.calculatePerimeter());
        System.out.println("Площадь: " + triangle.calculateArea());
        System.out.println("Цвет заливки: " + triangle.getFillColor());
        System.out.println("Цвет границы: " + triangle.getBorderColor());
    }
}
