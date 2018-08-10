package priv.ys.service;

public interface WxService {
    //校验
    boolean checkSignature(String signature, String timestamp, String nonce);
}
