package simple.features;


/**
 * @author xiangzhang
 * @since 2022-01-31 17:25
 */
public class MySwitch {

    public static void main(String[] args) throws IllegalAccessException {
        // java 14, 没有break, 不会产生穿透执行
        int day = 0;
        String dayOfWeek = switch (day) {
            case 0  -> {
                day ++ ;
                yield  String.valueOf(day);
            }
            case 1,2  -> "monday";
            case 4,5  -> "tuesday";
            default -> throw new IllegalAccessException("Invalid Option: " + day);
        };
        System.out.println(dayOfWeek);
    }
}
