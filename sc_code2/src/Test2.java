import java.util.Scanner;

public class Test2 {

    public static void methodOne() throws ArithmeticException {
        int a = 5 / 0;
        ArithmeticException exp1 = new ArithmeticException("抛着玩的，不是真错了：除数为0");
        throw exp1;
    }


    public static void main(String[] args) {
        try {
            methodOne();
        } catch (ArithmeticException exp1) {
            System.out.println("出现异常：" + exp1.getMessage());
        }
    }
}
