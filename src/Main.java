import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] miArray = {70, 12, 19, 45, 11, 33, 26};

        MyAlgorithms myAlgorithms = new MyAlgorithms();

        myAlgorithms.setPivotSelectorMethod(MyAlgorithms::selectPivotHalf);

        System.out.println(Arrays.toString(myAlgorithms.quickSort(miArray)));

    }
}