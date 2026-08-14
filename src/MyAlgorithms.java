import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyAlgorithms implements Busquedas, Ordenamientos{

    private Function<int [], Integer> pivotSelectorMethod;

    public void setPivotSelectorMethod(Function<int [], Integer> pivotSelectorMethod) {
        this.pivotSelectorMethod = pivotSelectorMethod;
    };

    public static int selectPivotHalf(int [] arrayEntered){
        return arrayEntered[Math.divideExact(arrayEntered.length, 2)];
    }

    public static int selectPivotLast(int [] arrayEntered){
        return arrayEntered[arrayEntered.length - 1];
    }

    public static int selectPivotFirst(int [] arrayEntered){
        return arrayEntered[0];
    }

    @Override
    public int linearSearch(int[] arrayPorExplorar, int elementoABuscar) {
        for (int i = 0; i < arrayPorExplorar.length; i++) {
            if (arrayPorExplorar[i] == elementoABuscar){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int binarySearch(int[] arrayPorExplorar, int elementoABuscar) {
        return 0;
    }

    @Override
    public int[] bubbleSort(int[] arrayDesordenado) {
        return new int[0];
    }

    @Override
    public int[] selectionSort(int[] arrayDesordenado) {
        return new int[0];
    }

    @Override
    public int[] insertionSort(int[] arrayDesordenado) {
        return new int[0];
    }

    @Override
    public int[] mergeSort(int[] arrayDesordenado) {
        return new int[0];
    }

    @Override
    public int[] quickSort(int[] arrayDesordenado) {

        if (arrayDesordenado.length <= 1){
            return arrayDesordenado;
        }

        int pivot = pivotSelectorMethod.apply(arrayDesordenado);
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> center = new ArrayList<>();

        for (int num : arrayDesordenado){

            if (num > pivot){
                right.add(num);
            }

            if (num < pivot){
                left.add(num);
            }
            if (num == pivot){
                center.add(num);
            }
        }

        ArrayList<Integer> newLeft = Arrays.stream(this.quickSort(left.stream().mapToInt(i -> i).toArray()))
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        newLeft.addAll(Arrays.stream(this.quickSort(center.stream().mapToInt(i -> i).toArray()))
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new)));
        newLeft.addAll(Arrays.stream(this.quickSort(right.stream().mapToInt(i -> i).toArray()))
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new)));

        return newLeft.stream().mapToInt(Integer::intValue).toArray();
    }
}
