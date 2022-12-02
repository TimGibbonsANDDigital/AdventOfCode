package _2022.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("src/_2022/day2/input.txt")));
        String line;
        int score = 0;
        while((line = br.readLine()) != null) {
            String[] scores = line.split(" ");

            score += getResult(scores);
            if (scores[1].equals("X"))
                score += 1;
            else if (scores[1].equals("Y"))
                score += 2;
            if (scores[1].equals("Z"))
                score += 3;

        }

        System.out.println(score);
    }

    private static int getResult(String[] scores) {

        if(scores[0].equals("A")) {
            if (scores[1].equals("X"))
                return 3;
            if (scores[1].equals("Y"))
                return 6;
            if (scores[1].equals("Z"))
                return 0;
        } else if(scores[0].equals("B")) {
            if (scores[1].equals("X"))
                return 0;
            if (scores[1].equals("Y"))
                return 3;
            if (scores[1].equals("Z"))
                return 6;
        } else if(scores[0].equals("C")) {
            if (scores[1].equals("X"))
                return 6;
            if (scores[1].equals("Y"))
                return 0;
            if (scores[1].equals("Z"))
                return 3;
        }


        return 0;
    }

    //Rock     (A)
    //Paper    (B)
    //Scissors (C)

    // Loose   (X)
    // Draw   (Y)
    // Win   (Z)
}
