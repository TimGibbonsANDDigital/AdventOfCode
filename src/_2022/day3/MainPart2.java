package _2022.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MainPart2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("src/_2022/day3/input.txt")));
        String line;
        int matchSum = 0;
        while((line = br.readLine()) != null) {
            matchSum += getMatchingItems(line, br.readLine(), br.readLine());
        }

        System.out.println(matchSum);

    }

    private static int getMatchingItems(String elf1, String elf2, String elf3) {

        List<Integer> filtered = elf1.chars()
                .sorted()
                .filter(p -> elf2.chars().anyMatch(s -> p == s))
                .filter(p -> elf3.chars().anyMatch(s -> p == s))
                .boxed()
                .collect(Collectors.toList());

        return filtered.get(0) - getOffset(filtered.get(0));
    }

    private static int getOffset(int i) {
        if (i >= 65 && i <= 90)
            return 64-26;
        else return 96;
    }
}
