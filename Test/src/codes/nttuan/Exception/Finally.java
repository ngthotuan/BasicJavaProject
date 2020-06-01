package codes.nttuan.Exception;

public class Finally {
    public static void main(String[] args) {
        try{
            int a = 45/0;
            System.out.println(a);
        } catch (NullPointerException e){
            System.out.println(e);
        } finally {
            System.out.println("Finally block");
        }
        System.out.println("inside try catch");
    }
}
