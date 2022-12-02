package _2022.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainPart2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("src/_2022/day2/input.txt")));
        String line;
        int score = 0;
        while((line = br.readLine()) != null) {
            String[] scores = line.split(" ");

            if (scores[1].equals("X"))
                score += 0 + getLoss(scores[0]);
            else if (scores[1].equals("Y"))
                score += 3 + getDraw(scores[0]);
            if (scores[1].equals("Z"))
                score += 6 + getWin(scores[0]);
        }

        System.out.println(score);
    }

    private static int getWin(String play) {
        if(play.equals("A")) {
            return 2;// Paper - (B)
        } if(play.equals("B")) {
            return 3;// Scissors - (C)
        } if(play.equals("C")) {
            return 1;// Rock - (A)
        }
        return 0;
    }

    private static int getDraw(String play) {
        if(play.equals("A")) {
            return 1;// Rock - (A)
        } if(play.equals("B")) {
            return 2;// Paper - (B)
        } if(play.equals("C")) {
            return 3;// Scissors - (C)
        }
        return 0;
    }

    private static int getLoss(String play) {
        if(play.equals("A")) {
            return 3;// Scissors - (C)
        } if(play.equals("B")) {
            return 1;// Rock - (A)
        } if(play.equals("C")) {
            return 2;// Paper - (B)
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
