void main() {
    int[] miArray = {70, 12, 19, 45, 11, 33, 26};

    MyAlgorithms myAlgorithms = new MyAlgorithms();

    myAlgorithms.setPivotSelectorMethod(MyAlgorithms::selectPivotHalf);

    IO.println(Arrays.toString(myAlgorithms.quickSort(miArray)));

}