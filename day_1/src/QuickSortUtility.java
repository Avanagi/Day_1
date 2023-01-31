public class QuickSortUtility {

    /**
     * @param vector отвечает за массив, который отправляется на обработку
     * @param left с какого индекса сортировать
     * @param right по какой индекс сортировать
     */
    public static void quickSort( Vector vector, int left, int right ) {

        if (left >= right) {
            return;
        }
        int part = partition (vector, left, right);
        quickSort (vector, left, part - 1);
        quickSort (vector, part + 1, right);
    }

    public static int partition( Vector vector, int left, int right ) {
        int counter = left;
        for (int i = left; i < right; i++) {
            if (vector.getElem (i) < vector.getElem (right)) {
                int temp = vector.getElem (counter);
                vector.setElem (counter, vector.getElem (i));
                vector.setElem (i, temp);
                counter++;
            }
        }
        int temp = vector.getElem (right);
        vector.setElem (right, vector.getElem (counter));
        vector.setElem (counter, temp);
        return counter;
    }

}
