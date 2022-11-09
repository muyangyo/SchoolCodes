public class Test1 {
    public static void main(String[] args) {
        char[] ch = new char[5];
        try {
            ch[6] = 'm';
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组下标越界:" + e.getMessage());
        } finally {
            System.out.println("已经检查出了问题");
        }
    }
}
