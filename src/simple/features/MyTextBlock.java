package simple.features;

/**
 * @author xiangzhang
 * @since 2022-01-31 17:47
 */
public class MyTextBlock {
    public static void main(String[] args) {
        // old
        String s = "line1\n\tline2\n\t\tline3";
        System.out.println(s);
        // java 15
        String str = """
           line%d
                line%d
                     line%d
                """.formatted(1,2,3);
        System.out.println(str);
    }
}
