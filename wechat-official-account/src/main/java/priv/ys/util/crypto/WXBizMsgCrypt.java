//package priv.ys.util.crypto;
//
//import org.apache.commons.codec.binary.Base64;
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
//import java.nio.charset.Charset;
//import java.util.Arrays;
//import java.util.Random;
//
//public class WXBizMsgCrypt {
//    static Charset CHARSET = Charset.forName("utf-8");
//    Base64 base64 = new Base64();
//    byte[] aesKey;
//    String token;
//    String appId;
//
//    public WXBizMsgCrypt(String token, String encodingAesKey, String appId) throws AesException {
//        if (encodingAesKey.length() != 43) {
//            throw new AesException(-40004);
//        } else {
//            this.token = token;
//            this.appId = appId;
//            this.aesKey = Base64.decodeBase64(encodingAesKey + "=");
//        }
//    }
//
//    byte[] getNetworkBytesOrder(int sourceNumber) {
//        byte[] orderBytes = new byte[]{(byte)(sourceNumber >> 24 & 255), (byte)(sourceNumber >> 16 & 255), (byte)(sourceNumber >> 8 & 255), (byte)(sourceNumber & 255)};
//        return orderBytes;
//    }
//
//    int recoverNetworkBytesOrder(byte[] orderBytes) {
//        int sourceNumber = 0;
//
//        for(int i = 0; i < 4; ++i) {
//            sourceNumber <<= 8;
//            sourceNumber |= orderBytes[i] & 255;
//        }
//
//        return sourceNumber;
//    }
//
//    String getRandomStr() {
//        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//        Random random = new Random();
//        StringBuffer sb = new StringBuffer();
//
//        for(int i = 0; i < 16; ++i) {
//            int number = random.nextInt(base.length());
//            sb.append(base.charAt(number));
//        }
//
//        return sb.toString();
//    }
//
//    String encrypt(String randomStr, String text) throws AesException {
//        ByteGroup byteCollector = new ByteGroup();
//        byte[] randomStrBytes = randomStr.getBytes(CHARSET);
//        byte[] textBytes = text.getBytes(CHARSET);
//        byte[] networkBytesOrder = this.getNetworkBytesOrder(textBytes.length);
//        byte[] appidBytes = this.appId.getBytes(CHARSET);
//        byteCollector.addBytes(randomStrBytes);
//        byteCollector.addBytes(networkBytesOrder);
//        byteCollector.addBytes(textBytes);
//        byteCollector.addBytes(appidBytes);
//        byte[] padBytes = PKCS7Encoder.encode(byteCollector.size());
//        byteCollector.addBytes(padBytes);
//        byte[] unencrypted = byteCollector.toBytes();
//
//        try {
//            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
//            SecretKeySpec keySpec = new SecretKeySpec(this.aesKey, "AES");
//            IvParameterSpec iv = new IvParameterSpec(this.aesKey, 0, 16);
//            cipher.init(1, keySpec, iv);
//            byte[] encrypted = cipher.doFinal(unencrypted);
//            String base64Encrypted = this.base64.encodeToString(encrypted);
//            return base64Encrypted;
//        } catch (Exception var15) {
//            var15.printStackTrace();
//            throw new AesException(-40006);
//        }
//    }
//
//    String decrypt(String text) throws AesException {
//        byte[] original;
//        byte[] networkOrder;
//        try {
//            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
//            SecretKeySpec key_spec = new SecretKeySpec(this.aesKey, "AES");
//            IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(this.aesKey, 0, 16));
//            cipher.init(2, key_spec, iv);
//            networkOrder = Base64.decodeBase64(text);
//            original = cipher.doFinal(networkOrder);
//        } catch (Exception var9) {
//            var9.printStackTrace();
//            throw new AesException(-40007);
//        }
//
//        String xmlContent;
//        String from_appid;
//        try {
//            byte[] bytes = PKCS7Encoder.decode(original);
//            networkOrder = Arrays.copyOfRange(bytes, 16, 20);
//            int xmlLength = this.recoverNetworkBytesOrder(networkOrder);
//            xmlContent = new String(Arrays.copyOfRange(bytes, 20, 20 + xmlLength), CHARSET);
//            from_appid = new String(Arrays.copyOfRange(bytes, 20 + xmlLength, bytes.length), CHARSET);
//        } catch (Exception var8) {
//            var8.printStackTrace();
//            throw new AesException(-40008);
//        }
//
//        if (!from_appid.equals(this.appId)) {
//            throw new AesException(-40005);
//        } else {
//            return xmlContent;
//        }
//    }
//
//    public String encryptMsg(String replyMsg, String timeStamp, String nonce) throws AesException {
//        String encrypt = this.encrypt(this.getRandomStr(), replyMsg);
//        if (timeStamp == "") {
//            timeStamp = Long.toString(System.currentTimeMillis());
//        }
//
//        String signature = SHA1.getSHA1(this.token, timeStamp, nonce, encrypt);
//        String result = XMLParse.generate(encrypt, signature, timeStamp, nonce);
//        return result;
//    }
//
//    public String decryptMsg(String msgSignature, String timeStamp, String nonce, String postData) throws AesException {
//        Object[] encrypt = XMLParse.extract(postData);
//        String signature = SHA1.getSHA1(this.token, timeStamp, nonce, encrypt[1].toString());
//        if (!signature.equals(msgSignature)) {
//            throw new AesException(-40001);
//        } else {
//            String result = this.decrypt(encrypt[1].toString());
//            return result;
//        }
//    }
//
//    public String verifyUrl(String msgSignature, String timeStamp, String nonce, String echoStr) throws AesException {
//        String signature = SHA1.getSHA1(this.token, timeStamp, nonce, echoStr);
//        if (!signature.equals(msgSignature)) {
//            throw new AesException(-40001);
//        } else {
//            String result = this.decrypt(echoStr);
//            return result;
//        }
//    }
//}
