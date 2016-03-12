package datatype.string;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by oserna on 28/2/16.
 */
public class StringVariations {

    public static void main(String[] args) {

        String input = "12345";
        int taken = 3;

        final String[] elements = Arrays.copyOfRange(input.split(""), 1, input.length() + 1);
        final String[] vars = variationsWithRepetitions(elements, taken);
        System.out.println("Number of variation:" + vars.length);

    }

    public static String[] variationsWithRepetitions(String[] elements, int taken){

        Queue<String> queue = new ArrayDeque<>();

        for (String element : elements) {
            queue.add(element);
        }

        while(queue.peek().length() < taken){

            final String polled = queue.poll();
            for (int i = 0; i < elements.length; i++) {
                queue.add(polled + elements[i]);
            }

        }

        return queue.toArray(new String[queue.size()]);

    }
}
