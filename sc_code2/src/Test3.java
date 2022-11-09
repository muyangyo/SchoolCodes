import java.io.*;
import java.util.*;

public class Test3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean data_right = true;//假定为有问题，直接赋值为true
        do {
            try {
                System.out.print("请输入一个浮点数: ");
                double numberx = sc.nextDouble();
                System.out.println(numberx);
                data_right = false;
            } catch (InputMismatchException e) {
                System.out.println("数据无效，请重新输入！");
                String cuowuhang = sc.nextLine();
            }
        }
        while (data_right);
    }
}
