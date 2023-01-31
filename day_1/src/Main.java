import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter The Size Of Array: ");
        int size;
        size = scanner.nextInt();
        if (size < 0){
            System.out.println("Wrong Value");
            return;
        }

        Vector vec = new Vector(size);
        vec.input();

    }
}
