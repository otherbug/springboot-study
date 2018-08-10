package priv.ys.exception;

import priv.ys.bean.WxError;

public class WxErrorException extends Exception {
    private WxError error;

    public WxErrorException(WxError error) {
        super(error.toString());
        this.error = error;
    }

    public WxErrorException(String message) {
        super(message);
    }

    public WxError getError() {
        return error;
    }

    public void setError(WxError error) {
        this.error = error;
    }
}
