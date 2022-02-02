package simple.features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author xiangzhang
 * @since 2022-02-02 22:21
 */
public class MyStrings {
    public static void main(String[] args) {
        // java 11
        System.out.println("".isBlank());
        System.out.println("   ".isBlank());

        final Stream<String> lines = "a\nb\n".lines();
        System.out.println(lines.toList());

        final List<String> transform = "UPPER".transform(e -> Arrays.asList(e.split("")));
        System.out.println(transform);

        // java 15
        System.out.println("my name is %s, my age is %d".formatted("will", 25));
    }
}
