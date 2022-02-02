package simple.features;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;

/**
 * @author xiangzhang
 * @since 2022-01-31 15:04
 */
public class MyFiles {

    public static void main(String[] args) throws IOException {
        // java 11
        final Path path = Path.of("C:/Users/xiangzhang/IdeaProjects/seventeen/src/simple/resources/java11");
        final String string = Files.readString(path);
        System.out.println(string);

        final Path path1 = Path.of("C:/Users/xiangzhang/IdeaProjects/seventeen/src/simple/resources/java17");
        String replace = string.replace("java11", "java17");
        Files.writeString(path1,"\n"+replace,StandardOpenOption.APPEND);

        //java 12
        System.out.println("--------文件比对-------");
        System.out.println(Files.mismatch(path, path1));
        final Path copy = Path.of("C:/Users/xiangzhang/IdeaProjects/seventeen/src/simple/resources/java11_2");
        System.out.println(Files.mismatch(path, copy));

    }
}
