package simple.features;

import java.util.List;
import java.util.Map;

/**
 * @author xiangzhang
 * @since 2022-01-31 17:43
 */
public class MyVar {

    public static void main(String[] args) {
        // java 10
        final var stringMap = Map.of("k1", "v1", "k2", "v2", "k3", "v3");
        for (var m:
                stringMap.entrySet()) {
            System.out.println(m.getKey());
            System.out.println(m.getValue());
        }

        final List<Integer> list = List.of(1, 2, 3, 4, 5);
        System.out.println(list.stream().map(x -> x * 2).toList());
    }
}

class Student {
    // java作为静态语言，成员变量，方法参数，方法类型等 无法使用var, 否则无法推断类型
//    private var a;
}
