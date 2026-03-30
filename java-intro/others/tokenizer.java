package others;

import java.util.StringTokenizer;

public class tokenizer {
    public static void main(String[] args) {
        String fataiTatoo = "fatai";
        StringTokenizer ft = new StringTokenizer(fataiTatoo);

        while (ft.hasMoreTokens()) {
            System.out.println(ft.nextToken());

        }
    }
}