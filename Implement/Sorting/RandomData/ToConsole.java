package Implement.Sorting.RandomData;

public class ToConsole {

    public static void main(String[] MadeWithLove_ByOskhar) {
        ShowRandomUnique();
    }

    public static void ShowRandom() {
        int[] randomArray = RandomInteger.generateRandomArray();

        for (int number : randomArray) {
            System.out.println(number);
        }
    }

    public static void ShowRandomUnique() {
        int[] randomArray = new int[RandomInteger.size];

        for (int i = 1; i <= RandomInteger.size; i++) {
            randomArray[i - 1] = i;
        }

        ShuffleArray.handle(randomArray);

        for (int number : randomArray) {
            System.out.println(number);
        }
    }
}
