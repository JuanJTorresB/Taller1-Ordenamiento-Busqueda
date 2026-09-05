void main() {
    int[] miArray = {70, 12, 19, 45, 11, 33, 26};

    MyAlgorithms myAlgorithms = new MyAlgorithms();

    myAlgorithms.setPivotSelectorMethod(MyAlgorithms::selectPivotHalf);

    int [] sortedArray = myAlgorithms.quickSort(miArray);

    myAlgorithms.setPivotSelectorMethod(MyAlgorithms::selectPivotFirst);

    miArray = new int[]{70, 12, 19, 45, 11, 33, 26};

    int [] sortedArray2 = myAlgorithms.quickSort(miArray);

    myAlgorithms.setPivotSelectorMethod(MyAlgorithms::selectPivotLast);

    miArray = new int[]{70, 12, 19, 45, 11, 33, 26};

    int [] sortedArray3 = myAlgorithms.quickSort(miArray);

    IO.println(Arrays.toString(sortedArray));

    System.out.println((myAlgorithms.binarySearch(sortedArray, 33)));

    System.out.println((myAlgorithms.linearSearch(sortedArray, 33)));

    System.out.println(Arrays.toString(myAlgorithms.bubbleSort(miArray)));

    miArray = new int[]{70, 12, 19, 45, 11, 33, 26};

    System.out.println("---");

    System.out.println(Arrays.toString(miArray));

    System.out.println(Arrays.toString(myAlgorithms.selectionSort(miArray)));

    miArray = new int[]{3, 1, 2};

    System.out.println("---");

    System.out.println(Arrays.toString(miArray));

    System.out.println(Arrays.toString(myAlgorithms.selectionSort(miArray)));

    miArray = new int[]{70, 12, 19, 45, 11, 33, 26};

    System.out.println("---");

    System.out.println(Arrays.toString(miArray));

    System.out.println(Arrays.toString(myAlgorithms.insertionSort(miArray)));

    miArray = new int[]{70, 12, 19, 45, 11, 33, 26};

    System.out.println("---");

    System.out.println(Arrays.toString(miArray));

    System.out.println(Arrays.toString(myAlgorithms.mergeSort(miArray)));


}