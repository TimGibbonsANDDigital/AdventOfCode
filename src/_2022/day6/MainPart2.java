package _2022.day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MainPart2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("src/_2022/day6/input.txt")));
        String line;


        while((line = br.readLine()) != null) {
            int marker = 14;

            while (!isMessageMarker(line.substring(marker-14, marker))) {
                marker++;
            };

            System.out.println("first marker after character " + marker);
        }
    }

    private static boolean isMessageMarker(String fourteenChars) {
        char[] chars = fourteenChars.toCharArray();
        int pos = 0;
        while (pos < chars.length){
            for (int i = pos; i < chars.length-1; i++) {
                if (chars[pos] == chars[i+1])
                    return false;
            }
            pos++;
        }
        return true;
    }
}
