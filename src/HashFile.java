import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HashFile {

    class Line {
        String line;
        int hashcode;
        public Line(String line, int hashcode) {
            this.line = line;
            this.hashcode = hashcode;
        }
    }

    private String filename;
    private List<Line> lines;

    public HashFile(String filename) {
        this.filename = filename;
        lines = new ArrayList<>();
    }

    public List<Line> getlines() {
        Path path = Paths.get(filename);
        List<String> slines = new ArrayList<>();
        try {
            slines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : slines) {
            lines.add(new Line(s, new Hash10(s).hashCode10()));
        }
        return lines;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Argument number error.");
            System.exit(0);
        }
        HashFile hf = new HashFile(args[0]);
        List<Line> lines = hf.getlines();
        for (Line line : lines) {
            System.out.println(line.hashcode);
        }
    }
}
