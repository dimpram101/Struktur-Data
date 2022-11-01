package linkedlist;
public class MergeSort {

    private int[] array;
    private int[] tempMergeArr;
    private int length;

    public MergeSort(int[] array) {
        this.array = array;
        this.length = array.length;
        this.tempMergeArr = new int[length];
    }

    public void sorting(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            sorting(lowerIndex, middle);
            sorting(middle + 1, higherIndex);
            mergeSort(lowerIndex, middle, higherIndex);
        }
    }

    public void mergeSort(int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergeArr[i] = array[i];
        }

        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;

        while (i <= middle && j <= higherIndex) {
            if (tempMergeArr[i] <= tempMergeArr[j]) {
                array[k] = tempMergeArr[i];
                i++;
            } else {
                array[k] = tempMergeArr[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            array[k] = tempMergeArr[i];
            k++;
            i++;
        }
    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

