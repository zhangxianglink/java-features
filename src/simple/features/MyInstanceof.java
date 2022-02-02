package simple.features;

/**
 * @author xiangzhang
 * @since 2022-02-02 22:02
 */
class Computer{
    private Integer price;
    public Computer(Integer price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "price=" + price +
                '}';
    }
}
public class MyInstanceof {

    public static void main(String[] args) {
         Object computer = new Computer(4399);
        if (computer instanceof Computer c2) {
            System.out.println(c2);
        }
    }
}
