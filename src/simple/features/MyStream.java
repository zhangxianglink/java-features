package simple.features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author xiangzhang
 * @since 2022-01-27 14:20
 */
public class MyStream {

    public static boolean isEven(Integer integer){
        return  integer % 2 ==0;
    }

    public static void main(String[] args) {
        // -- java 9
        final var list = Arrays.asList(1, 2, 3, 4, 5);
        // pridicate 为false时，跳过之后的元素
        final var integers = list.stream().takeWhile(e -> e != 4).toList();
        System.out.println(integers);
        //pridicate 为false时，返回之后的元素
        System.out.println(list.stream().dropWhile(e -> e != 4).toList());

        // 将单个元素生成stream
        final Stream<Integer> objectStream = Stream.ofNullable(5);
        final Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        final var concat = Stream.concat(integerStream, objectStream);
        System.out.println(concat.toList());

        //pridicate 为false时 结束运行，返回数据流
        Stream.iterate(0, e -> e < 6, e -> e + 2).forEach(System.out::println);

        System.out.println("java 11 (Pridicate not) ");
        // 静态方法，底层还是negate
        final List<Integer> list1 = List.of(1, 2, 453, 75783, 33, 5, 6, 8);
        System.out.println(list1.stream().filter(Predicate.not(MyStream::isEven)).toList());

        //java9
        Predicate<Integer> pre = e -> e % 2 == 0;
        System.out.println(list1.stream().filter(pre.negate()).toList());
    }
}
