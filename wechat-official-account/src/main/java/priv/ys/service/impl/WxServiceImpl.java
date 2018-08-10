package priv.ys.service.impl;

import org.springframework.stereotype.Service;
import priv.ys.api.WxConfig;
import priv.ys.service.WxService;
import priv.ys.util.crypto.SHA1;

@Service("wxService")
public class WxServiceImpl implements WxService {

    @Override
    public boolean checkSignature(String signature, String timestamp, String nonce) {
        return SHA1.gen(WxConfig.getInstance().getToken(),timestamp,nonce).equals(signature);
    }
}
