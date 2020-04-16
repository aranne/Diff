import org.junit.Test;

public class TestHash10 {
    @Test
    public void test1() {
        String s1 = "Hello!";
        String s2 = "";
        String s3 = "\n\n\n";
        System.out.println(new Hash10(s1).hashCode10());
        System.out.println(new Hash10(s2).hashCode10());
        System.out.println(new Hash10(s3).hashCode10());
    }
}
