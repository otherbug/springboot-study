package priv.ys.bean;

public class MenuMeta {
    private boolean keepalive;
    private boolean requireauth;

    public boolean isKeepalive() {
        return keepalive;
    }

    public void setKeepalive(boolean keepalive) {
        this.keepalive = keepalive;
    }

    public boolean isRequireauth() {
        return requireauth;
    }

    public void setRequireauth(boolean requireauth) {
        this.requireauth = requireauth;
    }
}
