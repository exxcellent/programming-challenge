package de.exxcellent.challenge;

import java.util.Collections;
import java.util.List;
import static java.util.Arrays.asList;

/**
 * The entry class for your solution. This class is only aimed as starting
 * point and not intended as baseline for your implementation.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static final List<Object> EXAMPLE_NESTED_LIST = Collections.unmodifiableList(
            asList(1, asList(2, 3), asList(4, asList(5, 6)))
    );


    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        List<Integer> result = asList(-1, -2); // yourFunction(EXAMPLE_NESTED_LIST)

        System.out.print(EXAMPLE_NESTED_LIST);
        System.out.print(" -> ");
        System.out.println(result);
    }
}
