import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyAlgorithms implements Busquedas, Ordenamientos{

    private Function<int [], Integer> pivotSelectorMethod;

    public void setPivotSelectorMethod(Function<int [], Integer> pivotSelectorMethod) {
        this.pivotSelectorMethod = pivotSelectorMethod;
    }

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
        int pivoteFinal = arrayPorExplorar.length - 1;
        int pivoteInicial = 0;
        int pivoteMedio;
        int prevPivote;

        while (true){
            pivoteMedio = Math.divideExact((pivoteFinal + pivoteInicial), 2);
            prevPivote = pivoteMedio;
            if (elementoABuscar > arrayPorExplorar[pivoteMedio]) pivoteInicial = pivoteMedio;
            else if (elementoABuscar < arrayPorExplorar[pivoteMedio]) pivoteFinal = pivoteMedio;
            else return pivoteMedio;
            if (pivoteFinal == pivoteInicial) break;
            if (prevPivote == pivoteInicial) pivoteInicial++;
        }
        return -1;
    }

    @Override
    public int[] bubbleSort(int[] arrayDesordenado) {
        int memoryElement;

        for (int ii = 0; ii < arrayDesordenado.length - 1; ii++) {
            for (int i = 0; i < arrayDesordenado.length - 1 - ii; i++) {
                if (arrayDesordenado[i] > arrayDesordenado[i+1]) {
                    memoryElement = arrayDesordenado[i + 1];
                    arrayDesordenado[i + 1] = arrayDesordenado[i];
                    arrayDesordenado[i] = memoryElement;
                }
            }
        }
        System.out.println(Arrays.toString(arrayDesordenado));
        return arrayDesordenado;
    }

    @Override
    public int[] selectionSort(int[] arrayDesordenado) {
        int memoryElement;
        boolean switchExecuted = false;

        for (int ii = 0; ii < arrayDesordenado.length - 1; ii++) {
            int minorElement = arrayDesordenado[ii];
            int minorElementIndex = ii;
            for (int i = ii; i < arrayDesordenado.length; i++) {
                if (minorElement > arrayDesordenado[i]) {
                    switchExecuted = true;
                    minorElement = arrayDesordenado[i];
                    minorElementIndex = i;
                }
            }
            if (switchExecuted){
                memoryElement = arrayDesordenado[ii];
                arrayDesordenado[ii] = minorElement;
                arrayDesordenado[minorElementIndex] = memoryElement;
            }
        }

        return arrayDesordenado;
    }

    @Override
    public int[] insertionSort(int[] arrayDesordenado) {
        int[] arrayOrdenado = new int[0];
        for (int entero : arrayDesordenado) {
            int[] newArrayOrdenado = new int[arrayOrdenado.length + 1];
            boolean insertado = false;
            int ii = 0;
            for (int j : arrayOrdenado) {
                if (!insertado && entero < j) {
                    newArrayOrdenado[ii] = entero;
                    ii++;
                    insertado = true;
                }
                newArrayOrdenado[ii] = j;
                ii++;
            }
            if (!insertado) {
                newArrayOrdenado[newArrayOrdenado.length - 1] = entero;
            }
            arrayOrdenado = newArrayOrdenado;
        }
        return arrayOrdenado;
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
