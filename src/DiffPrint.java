import java.util.List;

public class DiffPrint {

    private List<HashFile.Line> lines1;
    private List<HashFile.Line> lines2;
    private int[][] dp;

    public DiffPrint(String filename1, String filename2) {
        Diff diff = new Diff(filename1, filename2);
        diff.diff();
        lines1 = diff.getLines1();
        lines2 = diff.getLines2();
        dp = diff.getDp();
    }

    public void printDiff() {
        printDiffHelper(lines1.size() - 1, lines2.size() - 1);
    }

    private void printDiffHelper(int i, int j) {
        if (i < 0 && j < 0) {
            System.out.print("");
        } else if (i < 0) {
            printDiffHelper(i, j - 1);
            System.out.println("+ " + lines2.get(j).line);
        } else if (j < 0) {
            printDiffHelper(i - 1, j);
            System.out.println("- " + lines1.get(i).line);
        } else if (lines1.get(i).hashcode == lines2.get(j).hashcode && lines1.get(i).line.equals(lines2.get(j).line)) {
            printDiffHelper(i - 1, j - 1);
            System.out.println("  " + lines1.get(i).line);
        } else if (i == 0) {
            printDiffHelper(i, j - 1);
            System.out.println("+ " + lines2.get(j).line);
        } else if (j == 0) {
            printDiffHelper(i - 1, j);
            System.out.println("- " + lines1.get(i).line);
        } else if (dp[i][j - 1] >= dp[i - 1][j]) {
            printDiffHelper(i, j - 1);
            System.out.println("+ " + lines2.get(j).line);
        } else if (dp[i][j - 1] < dp[i - 1][j]) {
            printDiffHelper(i - 1, j);
            System.out.println("- " + lines1.get(i).line);
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Number of Arguments Error.");
            System.exit(0);
        }
        DiffPrint diffPrint = new DiffPrint(args[0], args[1]);
        diffPrint.printDiff();
    }
}
