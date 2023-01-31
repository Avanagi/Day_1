import java.util.Scanner;

public class Vector {
    Scanner scanner = new Scanner (System.in);
    private int size;
    private int[] elem;

    Vector(int size) {
        this.size = size;
        elem = new int[size];
    }

    public int getSize() {
        return size;
    }

    public int getElem(int i) {
        return elem[i];
    }

    public void setElem(int i, int elem) {
        this.elem[i] = elem;
    }

    public void input() {
        System.out.println ("Enter Your Array");
        for (int i = 0; i < size; i++) {
            elem[i] = scanner.nextInt ();
        }
    }

    public void output() {
        System.out.println ("Your Array Is: ");
        for (int i = 0; i < size; i++) {
            System.out.print (elem[i] + " ");
        }
        System.out.println ();
    }
}