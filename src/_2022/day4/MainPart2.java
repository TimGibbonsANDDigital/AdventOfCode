package _2022.day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainPart2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("src/_2022/day4/input.txt")));
        String line;
        int fullOverlapSum = 0;
        int overlapSum = 0;
        while((line = br.readLine()) != null) {
            String[] assignments = line.split(",");

            int[] elf0Int = Arrays.stream(assignments[0].split("-")).mapToInt(Integer::parseInt).toArray();
            int[] elf1Int = Arrays.stream(assignments[1].split("-")).mapToInt(Integer::parseInt).toArray();

            if ((elf0Int[0] <= elf1Int[0] && elf0Int[1] >= elf1Int[1])
                    || (elf1Int[0] <= elf0Int[0] && elf1Int[1] >= elf0Int[1])) {
                fullOverlapSum += 1;
            }


            if ((elf0Int[0] <= elf1Int[1] && elf0Int[1] >= elf1Int[0])
                    || (elf1Int[0] <= elf0Int[1] && elf1Int[1] >= elf0Int[0])) {
                overlapSum += 1;
            }

        }

        System.out.println("fullOverlapSum: " + fullOverlapSum);
        System.out.println("overlapSum: " + overlapSum);

    }
}
