import java.util.ArrayList;
import java.util.List;

public class Diff {

    private List<HashFile.Line> lines1;
    private List<HashFile.Line> lines2;
    private List<Integer> indices1;
    private List<Integer> indices2;
    private int[][] dp;

    public Diff(String filename1, String filename2) {
        lines1 = new HashFile(filename1).getlines();
        lines2 = new HashFile(filename2).getlines();
        indices1 = new ArrayList<>();
        indices2 = new ArrayList<>();
        dp = new int[lines1.size()][lines2.size()];
    }

    public void diff() {
        for (int i = 0; i < lines1.size(); i++) {
            for (int j = 0; j < lines2.size(); j++) {
                if (lines1.get(i).hashcode == lines2.get(j).hashcode) {
                    if (lines1.get(i).line.equals(lines2.get(j).line)) {  // handle collisions
                        if (i == 0 || j == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = dp[i - 1][j - 1] + 1;
                        }
                        indices1.add(i + 1);
                        indices2.add(j + 1);
                    }
                } else {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 0;
                    } else if (i == 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (j == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
    }

    public void printDiffIndices() {
        for (int i : indices1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : indices2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public List<HashFile.Line> getLines1() {
        return lines1;
    }

    public List<HashFile.Line> getLines2() {
        return lines2;
    }

    public List<Integer> getIndices1() {
        return indices1;
    }

    public List<Integer> getIndices2() {
        return indices2;
    }

    public int[][] getDp() {
        return dp;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Argument number error.");
            System.exit(0);
        }
        Diff diff = new Diff(args[0], args[1]);
        diff.diff();
        diff.printDiffIndices();
    }
}
