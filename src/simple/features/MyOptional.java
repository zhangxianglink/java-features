package simple.features;

import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author xiangzhang
 * @since 2022-01-28 10:24
 */
public class MyOptional {
    public static void main(String[] args) {
        //java9 Optional 新方法 ifPresentOrElse
        DoubleStream.of(1,2,3).filter(e -> e > 3).findAny()
                .ifPresentOrElse(System.out::println, () -> System.out.println(5));

        final Optional<Object> empty = Optional.empty();
        empty.ifPresentOrElse(x -> System.out.println(x), () -> System.out.println("not Found"));
        final Optional<Object> optional = Optional.of(0);
        optional.ifPresentOrElse(x -> System.out.println(x) , () -> System.out.println("not Found"));

        // or()
        System.out.println(
                empty.or(
                        () -> Optional.of("msg")
                ).get());

    }
}
