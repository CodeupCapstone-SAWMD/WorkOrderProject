package SandBox;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class PathTest {

    public static void main(String[] args) {
        Path path = Paths.get("../");
        Path fileName = Paths.get(".", "newFile.txt");
        List<String> lines = new ArrayList<>();
        lines.add("Hello");
        lines.add("Hola");
        lines.add("Guten Tag");
        lines.add("Bonjour");


        try{
            Path file = Files.createFile(fileName);
            Files.write(file, lines);
        }
        catch (IOException e){
            System.out.println(e);
        }
        System.out.println(path.toAbsolutePath());
    }
}
