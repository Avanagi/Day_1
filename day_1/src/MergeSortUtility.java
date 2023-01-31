public class MergeSortUtility {

    /**
     * @param vector отвечает за массив, который отправляется на обработку
     * @param left с какого индекса сортировать
     * @param right по какой индекс сортировать
     */
    public static void mergeSort(Vector vector, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (right + left) / 2;
        mergeSort (vector, left, middle);
        mergeSort (vector, middle + 1, right);
        merge (vector, left, middle, right);
    }

    public static void merge(Vector vector, int left, int middle, int right) {
        int leftLength = middle - left + 1;
        int rightLength = right - middle;

        int[] leftVector = new int[leftLength];
        int[] rightVector = new int[rightLength];

        for (int i = 0; i < leftLength; i++) {
            leftVector[i] = vector.getElem (left + i);
        }
        for (int i = 0; i < rightLength; i++) {
            rightVector[i] = vector.getElem (middle + 1 + i);
        }

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = left; i < right + 1; i++) {
            if (leftIndex < leftLength && rightIndex < rightLength) {
                if (leftVector[leftIndex] < rightVector[rightIndex]) {
                    vector.setElem (i, leftVector[leftIndex]);
                    leftIndex++;
                }else {
                    vector.setElem (i, rightVector[rightIndex]);
                    rightIndex++;
                }
            }else if (leftIndex < leftLength) {
                vector.setElem (i, leftVector[leftIndex]);
                leftIndex++;
            }else if (rightIndex < rightLength) {
                vector.setElem (i, rightVector[rightIndex]);
                rightIndex++;
            }
        }
    }

}
