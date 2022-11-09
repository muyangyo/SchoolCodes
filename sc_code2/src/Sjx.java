import java.util.Scanner;

class MyException extends Exception {
    public String toString() {
        return "错误：不能构成三角形 ";
    }
}

public class Sjx {
    int a, b, c;

    Sjx(int x, int y, int z) {
        this.a = x;
        this.b = y;
        this.c = z;
    }

    public static void main(String[] args) {
        try {
            Sjx exp1 = new Sjx(6, 1, 2);
            zhouchang(exp1);
        } catch (MyException e1) {
            System.out.println(e1.toString());
        }


    }

    static void zhouchang(Sjx exp1) throws MyException {
        if (exp1.a + exp1.b < exp1.c || exp1.a + exp1.c < exp1.b || exp1.b + exp1.c < exp1.a) {
            MyException e1 = new MyException();
            throw e1;
        } else {
            int c = exp1.a + exp1.b + exp1.c;
            System.out.println("周长为：" + c);
        }
    }
}