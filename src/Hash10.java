import com.google.common.base.Charsets;
import com.google.common.hash.*;

import java.nio.charset.Charset;

public class Hash10 {

    String s;
    HashFunction hf;

    public Hash10(String s) {
        this.s = s;
        hf = Hashing.md5();
    }

    public int hashCode10() {
        HashCode hc = hf.newHasher().putString(s, Charsets.UTF_8).hash();
        return hc.asInt() & 0x03FF;
    }
}
