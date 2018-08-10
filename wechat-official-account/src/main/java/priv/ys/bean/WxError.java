package priv.ys.bean;

public class WxError {
    private int errcode;
    private String errmsg;

    public WxError() {
    }

    public WxError(int errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "WxError{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
