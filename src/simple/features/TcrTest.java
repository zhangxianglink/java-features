package simple.features;

import java.io.*;

/**
 * @author xiangzhang
 * @since 2022-01-27 14:08
 */
public class TcrTest {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "D:\\data\\test\\testJava9Try.txt";
        // java7， Closeable, AutoCloseable接口的实现类
        // 可以通过try-with-resources 自动关闭 close
        try(FileInputStream stream = new FileInputStream(fileName);) {
            stream.readAllBytes();
        }catch (IOException e){
            e.printStackTrace();
        }


        FileOutputStream fos = new FileOutputStream(fileName);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        // java9 语法可以参数化
        try(bw;osw;fos){
            bw.write("Java9-可以被自动调用close()方法");
            bw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
