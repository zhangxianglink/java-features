package simple.features;

/**
 * @author xiangzhang
 */
public interface  MyInterface {
    /**
     * 抽象类：无法实例化，依靠继承，子类实现抽象方法
     *        抽象类可以内部实现方法，字段，
     * 接口： 依靠实现类实现抽象方法
     *       目前除了没有 属性字段，其他都很像抽象类
     */

    void design();

    private void jack(){
        System.out.println("jack is young");
    }

    default void show(){
        count();
        jack();
    }
    // 默认 public final
    String number = "232";
    static void count() {
        System.out.println("static" + number);
    }

}
