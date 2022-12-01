package _2022.day1;

import java.io.*;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("src/_2022.day1/input.txt")));
        String line;
        Long calCount = 0L;
        Stack<Long> maxStack = new Stack<>();

        while((line = br.readLine()) != null) {
            if (line.equals("")) {
                if(maxStack.isEmpty() || calCount > maxStack.peek())
                    maxStack.push(calCount);
                if (maxStack.size() > 3)
                    maxStack.remove(0);

                calCount = 0L;
                continue;
            }

            calCount += Long.parseLong(line);

        }

        System.out.println(maxStack);
    }
}
