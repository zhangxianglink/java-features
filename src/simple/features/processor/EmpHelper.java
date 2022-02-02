package simple.features.processor;

import java.util.List;

/**
 * @author xiangzhang
 * @since 2022-01-31 22:34
 */
public class EmpHelper {
    public static List<Employee> getEmps() {
        return List.of(
                new Employee(1, "我没有三颗心脏"),
                new Employee(2, "三颗心脏"),
                new Employee(3, "心脏")
        );
    }
}
