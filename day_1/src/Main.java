import java.util.Scanner;
class Vector{
    Scanner scanner = new Scanner(System.in);
    private int size;
    private int[] base;

    Vector(){
        this.size = 10;
        base = new int[size];
    }

    Vector(int size){
        this.size = size;
        base = new int[size];
    }

    public int get_size(){
        return this.size;
    }

    public void input(){
        System.out.println("Enter Your Array");
        for(int i = 0; i < size; i++){
            base[i] = scanner.nextInt();
        }
    }

    public void output(){
        System.out.println("Your Array Is: ");
        for(int i = 0; i < size; i++){
            System.out.print(base[i] + " ");
        }
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {
        Vector vec = new Vector(3);
        vec.input();
        vec.output();
        System.out.println(vec.get_size());
    }
}
