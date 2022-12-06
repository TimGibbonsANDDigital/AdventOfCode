package _2022.day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("src/_2022/day6/input.txt")));
        String line;


        while((line = br.readLine()) != null) {
            int marker = 3;
            String markerStr = "";
            do {
                marker++;
                markerStr = line.substring(marker-4, marker);
            }
            while (!isMarker(markerStr));

            System.out.println("first marker after character " + marker);

        }
    }

    private static boolean isMarker(String fourChars) {
        char[] chars = fourChars.toCharArray();
        if (chars[0] == chars[1] ||
                chars[0] == chars[2] ||
                chars[0] == chars[3] ||
                chars[1] == chars[2] ||
                chars[1] == chars[3] ||
                chars[2] == chars[3])
            return false;
        return true;
    }
}
