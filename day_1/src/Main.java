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

    Vector(Vector vector){
        this.size = vector.size;
        base = new int[size];
        for(int i = 0; i < size; i++){
            base[i] = vector.get_elem(i);
        }
    }

    public int get_size(){
        return this.size;
    }

    public int get_elem(int i){
        return this.base[i];
    }

    public void set_elem(int i, int elem){
        this.base[i] = elem;
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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter The Size Of Array: ");
        int size;
        size = scanner.nextInt();
        Vector vec = new Vector(size);
        vec.input();
        vec.output();

        System.out.println("1. QuickSort || 2. MergeSort || 3. Exit");
        int choose;
        choose = scanner.nextInt();
        switch (choose) {
            case (1) -> {
                quickSort(vec, 0, vec.get_size() - 1);
                vec.output();
            }
            case (2) -> {
                mergeSort(vec, 0, vec.get_size() - 1);
                vec.output();
            }
            case (3) -> System.exit(0);
            default -> System.out.println("You Do not Choose Any Of Type Of Sorting!");
        }
    }

    public static void quickSort(Vector vector, int left, int right) {
        if(left >= right) {
            return;
        } else {
            int part = partition(vector, left, right);
            quickSort(vector, left, part - 1);
            quickSort(vector, part + 1, right);
        }
    }
    static int partition(Vector vector, int left, int right) {
        int counter = left;
        for (int i = left; i < right; i++) {
            if (vector.get_elem(i) < vector.get_elem(right)) {
                int temp = vector.get_elem(counter);
                vector.set_elem(counter, vector.get_elem(i));
                vector.set_elem(i, temp);
                counter++;
            }
        }
        int temp = vector.get_elem(right);
        vector.set_elem(right, vector.get_elem(counter));
        vector.set_elem(counter, temp);
        return counter;
    }
    public static void mergeSort(Vector vector, int left, int right) {
        if(left >= right) {
            return;
        } else {
            int middle = (right + left)/2;
            mergeSort(vector, left, middle);
            mergeSort(vector, middle + 1, right);
            merge(vector, left, middle, right);
        }
    }
    public static void merge(Vector vector, int left, int middle, int right) {
        int leftLength = middle - left + 1;
        int rightLength = right - middle;

        int[] leftVector = new int[leftLength];
        int[] rightVector = new int[rightLength];

        for(int i = 0; i < leftLength; i++){
            leftVector[i] = vector.get_elem(left + i);
        }
        for(int i = 0; i < rightLength; i++){
            rightVector[i] = vector.get_elem(middle + 1 + i);
        }

        int leftIndex = 0; int rightIndex = 0;

        for(int i = left; i < right + 1; i++){
            if(leftIndex < leftLength && rightIndex < rightLength){
                if (leftVector[leftIndex] < rightVector[rightIndex]) {
                    vector.set_elem(i, leftVector[leftIndex]);
                    leftIndex++;
                }
                else {
                    vector.set_elem(i, rightVector[rightIndex]);
                    rightIndex++;
                }
            } else if (leftIndex < leftLength) {
                vector.set_elem(i, leftVector[leftIndex]);
                leftIndex++;
            } else if (rightIndex < rightLength){
                vector.set_elem(i, rightVector[rightIndex]);
                rightIndex++;
            }
        }
    }
}
