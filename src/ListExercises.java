import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ListExercises {
    private static List<Double> read(String fileName) {
        List<Double> list = null;
        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            list = new ArrayList<>(Arrays.stream(
                    input.readLine()
                            .replace(',', '.')
                            .split("; ")
                    )
                    .map(Double::parseDouble)
                    .toList()
            );

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public static void main(String[] args) {
        List<Double> list = read("input.txt");
        Double el;
        for (int i = 0; i < list.size(); i++) {
            el = list.get(i);
            if (el < 0) {
                list.remove(i);
                list.addFirst(el);
            }
        }
        System.out.println(list);
    }
}