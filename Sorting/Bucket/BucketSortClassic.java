package Sorting.Bucket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSortClassic {

    void sort(float[] arr) {
        if (arr.length == 0)
            return;

        List<List<Float>> buckets = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            buckets.add(new ArrayList<>());
        }

        for (float item : arr) {
            int index = (int) item * arr.length;
            buckets.get(index).add(item);
        }

        for (List<Float> bucket : buckets) {
            Collections.sort(bucket);
        }

        int index = 0;
        for (List<Float> bucket : buckets) {
            for (Float item : bucket) {
                arr[index++] = item;
            }
        }
    }

}
