package sorting;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Arrays;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 2)
@Measurement(iterations = 3)
@Fork(1)
public class SortingBenchmark {

    private int[] array;

    @Setup
    public void setup() {
        array = new Random()
                .ints(1000, 0, 10000)
                .toArray();
    }

    @Benchmark
    public void bubbleSort() {
        SortingAlgorithms.bubbleSort(array.clone());
    }

    @Benchmark
    public void selectionSort() {
        SortingAlgorithms.selectionSort(array.clone());
    }

    @Benchmark
    public void insertionSort() {
        SortingAlgorithms.insertionSort(array.clone());
    }

    @Benchmark
    public void mergeSort() {
        int[] copy = array.clone();
        SortingAlgorithms.mergeSort(copy, 0, copy.length - 1);
    }

    @Benchmark
    public void javaBuiltInSort() {
        int[] copy = array.clone();
        Arrays.sort(copy);
    }
}