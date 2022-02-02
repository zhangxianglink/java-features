package simple.features;

import java.util.stream.Stream;

/**
 * @author xiangzhang
 * @since 2022-01-31 16:04
 */
public class MyString {
    public static void main(String[] args) {
        // java 11
        System.out.println("".isBlank());
        System.out.println("   ".isBlank());

        final Stream<String> lines = "a\nb\n".lines();
        System.out.println(lines.toList());

        final String transform = "UPPER".transform(e -> e.substring(2));
        System.out.println(transform);

        // java 15
        System.out.println("my name is %s, my age is %d".formatted("will", 25));
    }
}
