package Implement.Sorting.Bucket;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class BucketSort<T extends Number & Comparable<T>> {

    public List<T> sort(List<T> list, BiFunction<T, Integer, Integer> function) {
        int nbrOfBuckets = list.size();
        Map<Integer, List<T>> buckets = new HashMap<>();
        IntStream.range(0, nbrOfBuckets).forEach(i -> buckets.put(i, new LinkedList<>()));
        list.forEach(item -> buckets.get(function.apply(item, nbrOfBuckets)).add(item));
        buckets.values().forEach(Collections::sort);
        return buckets.values().stream().flatMap(Collection::stream).toList();
    }

}