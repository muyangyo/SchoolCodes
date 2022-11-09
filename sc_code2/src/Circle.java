import java.util.Scanner;

//自定义异常类XiaoYuLingException，当圆的半径小于0时，抛出异常
class XiaoYuLingException extends Exception {
    public String toString() {
        return "圆的半径的小于0";
    }
}

//计算圆面积的类Circle
public class Circle {
    int j;

    Circle(int j) {
        this.j = j;
    }

    static void mianji(Circle exp1) throws XiaoYuLingException {//求圆的面积
        if (exp1.j == 0) {
            XiaoYuLingException e1 = new XiaoYuLingException();
            throw e1;
        } else {
            System.out.println("面积为：" + Math.PI * exp1.j * exp1.j);
        }
    }

    public static void main(String args[]) {
        try {
            Scanner sc = new Scanner(System.in);
            int r;
            r = sc.nextInt();
            Circle c1 = new Circle(r);
            mianji(c1);
        } catch (Exception e1) {
            System.out.println("出现异常：" + e1.toString());
        }


    }
}