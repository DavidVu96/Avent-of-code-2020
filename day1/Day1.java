package day1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class Day1 {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<String> inputs = null;
        try {
            inputs = Files.readAllLines(Paths.get("E:\\Projects\\Avent of code 2020\\day1\\input.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Cannot open file");
        }
        if (null != inputs) {
            inputs.stream().map(Integer::valueOf).sorted().forEach(deque::offer);
        }

        while (true) {
            int sum = deque.getFirst() + deque.getLast();
            if (sum > 2020) {
                deque.removeLast();
            } else if (sum < 2020) {
                deque.removeFirst();
            } else {
                System.out.println(deque.getFirst() * deque.getLast());
                break;
            }
        }
    }
}