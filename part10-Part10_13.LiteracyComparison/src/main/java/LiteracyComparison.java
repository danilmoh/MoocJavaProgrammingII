
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        List<LiteracyPersonUnit> literacyPersons = new ArrayList<>();
        String filePath = "literacy.csv";
        String toRemoveFromValue = " \\(%\\)";
        
        try {
            literacyPersons = Files.lines(Paths.get(filePath))
                    .map(value -> value.split(","))
                    .map(parts -> new LiteracyPersonUnit(parts[2].replaceAll(toRemoveFromValue, "").trim(), parts[3], Integer.valueOf(parts[4]), Double.valueOf(parts[5])))
                    .sorted()
                    .collect(Collectors.toCollection(ArrayList::new));
                    
        } catch (IOException e ) {
            System.out.println(e.getMessage());
        }
        
        literacyPersons.stream().forEach(person -> System.out.println(person));
    }
}
