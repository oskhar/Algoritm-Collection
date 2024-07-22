package Implement.Compression.LZW;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        String initialText = "Muhamad Oskhar";
        List<Integer> compressed = LempelZivWelch.encode(initialText);
        String decompressed = LempelZivWelch.decode(compressed);
        
        System.out.println(initialText);
        System.out.println(compressed);
        System.out.println(decompressed);

    }

}