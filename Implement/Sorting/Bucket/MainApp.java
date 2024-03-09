package Implement.Sorting.Bucket;

import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(42, 32, 63, 82, 37, 17, 51, 21, 22, 75);
        System.out.println(new BucketSort<Integer>().sort(ints, (item, size) -> item / size));

        List<Float> floats = Arrays.asList(0.42F, 0.32F, 0.63F, 0.82F, 0.37F, 0.17F, 0.51F, 0.21F, 0.22F, 0.75F);
        System.out.println(new BucketSort<Float>().sort(floats, (item, size) -> (int) (item * size)));

        float[] array = new float[] { 0.42F, 0.32F, 0.63F, 0.82F, 0.37F, 0.17F, 0.51F, 0.21F, 0.22F, 0.75F };
        new BucketSortClassic().sort(array);
        System.out.println(Arrays.toString(array));

    }

}
