package lesson2;

import com.sun.org.apache.xml.internal.utils.StringComparable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by rtsy on 25.07.2015.
 */
public class FileReader {

    public static List<String> readFile(String fileFolder, String fileName)
            throws IOException {
//        BufferedReader reader = new BufferedReader(new java.io.FileReader(new File("C:/home/bazaarvoice/logs/diagnostic/bv.log")));
        Stream<String> stringStream = Files.lines(Paths.get(fileFolder, fileName));
        List<String> result = stringStream.filter(string -> string.contains("ERROR")).onClose(() -> System.out.println("Closed."))
//                .peek(System.out::println)
                .skip(6)
                .limit(10)
                .collect(Collectors.<String>toList());
        return result;
    }
}
