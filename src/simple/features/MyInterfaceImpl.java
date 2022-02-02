package simple.features;

/**
 * @author xiangzhang
 * @since 2022-02-02 23:49
 */
public class MyInterfaceImpl implements MyInterface{

    public static void main(String[] args) {
        final MyInterfaceImpl myInterface = new MyInterfaceImpl();
        myInterface.show();
        myInterface.design();
    }

    @Override
    public void design() {
        System.out.println("接口实现");
    }


}
