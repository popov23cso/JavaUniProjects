import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        int[][][] arr = {
                {{0, 11, 15}, {30, 18, 24}, {26, 70, 95}},
                {{1, 12, 16}, {32, 20, 25}, {28, 72, 97}},
                {{2, 13, 17}, {33, 22, 26}, {28, 72, 99}},
        };

        StringBuilder sb = new StringBuilder();

        String[] filename = {"file1", "file2","file3"};
        for (int i = 0; i < arr.length; i++) {
            Path path = Paths.get("results\\" + filename[i] +".txt");
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    String spaces = ((int) (Math.log10(arr[i][j][k]) + 1) > 1) ? " " : "  ";
                    System.out.print(arr[i][j][k] + spaces);
                    sb.append(arr[i][j][k]).append(spaces);
                }
                System.out.println();
                sb.append("\n");
            }
            System.out.println();
            sb.append("\n");
            try {
                Files.write(path, sb.toString().getBytes());
            } 
            catch (java.io.IOException e) {
                System.out.println(e);
            }
            sb = new StringBuilder();
        }
    }
}