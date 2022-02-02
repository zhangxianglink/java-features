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
        final Path path = Path.of("C:/Users/xiangzhang/IdeaProjects/seventeen/out/production/seventeen/simple/resources/java11");
        final String string = Files.readString(path);
        System.out.println(string);

        final Path path1 = Path.of("C:/Users/xiangzhang/IdeaProjects/seventeen/out/production/seventeen/simple/resources/java17");
//        final String replace = string.replace("java11", "java17");
//        Files.writeString(path1,replace);

        //java 12
        System.out.println("---------------");
        System.out.println(Files.mismatch(path, path1));
    }
}
