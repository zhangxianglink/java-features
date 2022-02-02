package simple.features;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xiangzhang
 * @since 2022-01-27 14:31
 */
public class MyConllection {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        List<Integer> integers = List.of(1, 2, 3);
/*      java9: 使用of()的方式创建不可变对象。
        无法添加、修改和删除其元素；
        integers.add(4); UnsupportedOperationException
        不允许 null 元素
        List.of(null);  NullPointerException
 */
        System.out.println(integers);
        final Set<Integer> integers1 = Set.of(4,5,6);
        System.out.println(integers1);
        final Map<String, String> map = Map.of("2", "two", "1", "one");
        System.out.println(map);
        // 工厂方式
        final Map<String, String> stringStringMap = Map.ofEntries(Map.entry("K1", "V1"));
        System.out.println(stringStringMap);


        int[] intt = {1,2,0,3,5,7,8};
        int[] int2 = {1,2,0,4,5,7,8};
        int[] int1 = {0,0,1,2,0,4,5,6,8};
        int[] int3 = {0,1,2,3,4,5,6,8};
//      java9  两个数组之间的第一个不匹配索引
        final int mismatch = Arrays.mismatch(int2, intt);
        System.out.println(mismatch);

        final int mismatch1 = Arrays.mismatch(int3, 1, int3.length, int1, 2, int1.length);
        System.out.println(mismatch1);

        final boolean equals = Arrays.equals(int2, intt);
        System.out.println(equals);
        final boolean equals1 = Arrays.equals(int2, 0, 3, intt, 0, 3);
        System.out.println(equals1);
        final boolean equals2 = Arrays.equals(int2, 4,int2.length, intt, 4,intt.length);
        System.out.println(equals2);

        // java 11
        final List<Integer> copyOf = List.copyOf(integers);
        System.out.println(copyOf);
    }
}
