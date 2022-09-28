public class MainMerge {
    public static void main(String[] args) {
        int[] inputArr = {23, 12, 34, 66, 10, 65, 8};
        System.out.println("Array Sebelum di Sorting");
        MergeSort ms = new MergeSort(inputArr);
        ms.print(inputArr);
        ms.sorting(0, inputArr.length - 1);
        System.out.println("==========");
        System.out.println("Array Setelah di Sorting");
        ms.print(inputArr);
    }
}
