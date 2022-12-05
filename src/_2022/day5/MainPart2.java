package _2022.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class MainPart2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("src/_2022/day5/input.txt")));
        String line;

        Stack<String> inputStack = new Stack<>();
        List<Stack<String>> stacks = new ArrayList<>();


        while((line = br.readLine()) != null) {
            if(!line.startsWith("move") && !line.equals("")) {
                line = line.replace("[","");
                line = line.replace("]","");
                inputStack.push(line);
            }

            if(line.startsWith(" 1")) {
                String[] columns = inputStack.pop().split("   ");
                Arrays.stream(columns).forEach(s -> stacks.add(new Stack<>()));

                while (inputStack.size() > 0) {
                    String row = inputStack.pop().replace("    ", " ");
                    String[] rows = row.split(" ");
                    for (int i = 0; i < rows.length; i++) {
                        if(rows[i].equals(""))
                            continue;

                        stacks.get(i).push(rows[i]);
                    }

//                    printStack(stacks, Integer.toString(inputStack.size()));
                }
            }

            if(line.equals("")) {
                printStack(stacks, "Start");
            }

            if(line.startsWith("move")) {

                String instruction = line;
                instruction = instruction.replace("move ","");
                instruction = instruction.replace("from ","");
                instruction = instruction.replace("to ","");

                int[] instructions = Arrays.stream(instruction.split(" ")).mapToInt(Integer::parseInt).toArray();

                Stack<String> tempStore = new Stack<>();
                for (int i = 0; i < instructions[0]; i++) {
                    if(stacks.get(instructions[1]-1).size() == 0)
                        continue;

                    tempStore.push(stacks.get(instructions[1]-1).pop());
                }

                while (tempStore.size() > 0) {
                    stacks.get(instructions[2]-1).push(tempStore.pop());
                }
            }
        }

        printStack(stacks, "End");

        for (Stack stack : stacks) {
            if(stack.size() == 0) {
                System.out.println(" ");
                continue;
            }
            System.out.print(stack.peek());
        }

    }

    private static void printStack(List<Stack<String>> stacks, String instruction) {
        int max = 0;
        int top = 0;
        for (Stack stack: stacks) {
            if(stack.size() > top) {
                top = stack.size();
                max = stack.size();
            }
        }

        System.out.println();
        System.out.println(instruction);
        System.out.println();

        for (int i = 0; i < max; i++) {
            for (Stack stack: stacks) {

                if(stack.size() < top){
                    System.out.print("    ");
                    continue;
                }

                System.out.print("[" + stack.get(top-1) + "] ");

            }
            top--;
            System.out.println();
        }

        for (int i = 0; i < stacks.size(); i++) {
            System.out.print(" " + (i+1) + "  ");
        }
        System.out.println();

    }
}
