void main() {
    int[] miArray = {70, 12, 19, 45, 11, 33, 26};

    MyAlgorithms myAlgorithms = new MyAlgorithms();

    myAlgorithms.setPivotSelectorMethod(MyAlgorithms::selectPivotHalf);

    int [] sortedArray = myAlgorithms.quickSort(miArray);

    IO.println(Arrays.toString(sortedArray));

    System.out.println((myAlgorithms.binarySearch(sortedArray, 33)));

    System.out.println(Arrays.toString(myAlgorithms.bubbleSort(miArray)));

}