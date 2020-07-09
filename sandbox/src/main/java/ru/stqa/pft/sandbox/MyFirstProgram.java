package ru.stqa.pft.sandbox;

public class MyFirstProgram {

	/*public static void main(String[] args) {

		hello("world");
		hello("user");
		hello("Andrey");

		Square s = new Square(5);
    System.out.println("Плошадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4,6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
    }

	public static void hello (String somebody) {

    System.out.println("Hello, " + somebody + "!");
  }*/

  public static void main(String[] args) {

    Point p1 = new Point(1,2);
    Point p2 = new Point(3,4);

    System.out.println("Расстояние между одной точкой с координатами " + p1.x + " и " + p1.y + " и другой точкой с координатами " + p2.x + " и " + p2.y + " = " + p1.distance(p2));

  }

}



