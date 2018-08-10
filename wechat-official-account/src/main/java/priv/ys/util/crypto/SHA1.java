package priv.ys.util.crypto;


import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

public class SHA1 {

    public static String gen(String token, String timestamp, String nonce) {
        String[] arr = new String[]{token, timestamp, nonce};
        Arrays.sort(arr);
        //生成字符串
        StringBuffer sb = new StringBuffer();

        for (String s : arr) {
            sb.append(s);
        }
        return DigestUtils.sha1Hex(sb.toString());
    }
}
