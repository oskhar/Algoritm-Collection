package Implement.StringMatching.RabinKarpPercen;

public class MainApp {
    // d is the number of characters in the input alphabet
    public final static int d = 256;

    /* pat -> pattern
       txt -> text
       q -> A prime number
    */
    static void search(String pat, String txt, int q) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;
        int maxMatchedChars = 0; // maximum number of matched characters in any substring

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < M && i < N; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {
            // Check the hash values of current window of text and pattern
            int matchCount = 0;
            for (j = 0; j < M && (i + j) < N; j++) {
                if (txt.charAt(i + j) == pat.charAt(j))
                    matchCount++;
            }

            // Update the maximum matched characters
            if (matchCount > maxMatchedChars) {
                maxMatchedChars = matchCount;
            }

            // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
            if (matchCount == M) {
                System.out.println("Pola ditemukan pada index ke = " + i);
            }

            // Calculate hash value for next window of text:
            // Remove leading digit, add trailing digit
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;

                // We might get negative value of t, converting it to positive
                if (t < 0)
                    t = (t + q);
            }
        }

        // Calculate and print the match percentage
        double matchPercentage = (double) maxMatchedChars / M * 100;
        System.out.printf("Persentase kecocokan: %.2f%%\n", matchPercentage);
    }

    /* Driver Code */
    public static void main(String[] args) {
        String txt1 = "oakokOskharbarok";
        String pat1 = "Oskhar";
        search(pat1, txt1, 101);
    }
}
