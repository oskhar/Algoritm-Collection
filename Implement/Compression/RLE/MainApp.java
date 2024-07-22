package Implement.Compression.RLE;
 
public class MainApp {

    public static void main(String[] args) {

        String initialText = "AAAABBBBBCCCCCCDDDDDDD";
        String encodedText = RunLengthEncoding.compress(initialText);
        String decodedText = RunLengthEncoding.decompress(encodedText);

        System.out.println(initialText);
        System.out.println(encodedText);
        System.out.println(decodedText);

    }

}