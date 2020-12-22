public class CircleApp {

    public static void main(String[] args) {

        Circle[] circles = new Circle[2];
        double rd = 12.3;
        System.out.println("半径 = " + rd);

        Circle circle1 = new Circle(rd);
        double cir = circle1.calPerimeter();
        double area = circle1.calArea();

        System.out.println("周长：" + cir);
        System.out.println("面积：" + area);

        Circle circle2 = new Circle(circle1);
        // false，两个对象的地址不一致
        System.out.println(circle2 == circle1);
        System.out.println(circle2.calArea() == circle1.calArea());
        System.out.println("周长：" + circle2.calArea());
        System.out.println("面积：" + circle2.calPerimeter());

        circle1.setRadius(1);
        circle2.setRadius(2);
        System.out.println(circle2.calArea());
        System.out.println(circle1.calArea());

        circles[0] = circle1;
        circles[1] = circle2;

        circles[1].setRadius(100);
        System.out.println(circle2.calArea());

        circle1 = null;
        // System.out.println(circle1.calArea());
        System.out.println(circles[0].calArea());

    }

}