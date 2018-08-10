package priv.ys.api;

import priv.ys.exception.WxErrorException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WxConfig {
    public static final String configFile = "/wx.properties";
    private static WxConfig config = null;
    private volatile String appId;
    private volatile String appSecret;
    private volatile String token;

    private WxConfig() {
        Properties properties = new Properties();
        InputStream inputStream = this.getClass().getResourceAsStream(configFile);
        if (inputStream == null) {
            try {
                throw new WxErrorException("Can't find file");
            } catch (WxErrorException wxErrorException) {
                wxErrorException.printStackTrace();
            }
        }

        try {
            properties.load(inputStream);
            this.appId = properties.getProperty("wx.appId");
            this.appSecret = properties.getProperty("wx.appSecret");
            this.token = properties.getProperty("wx.token");

            inputStream.close();
        } catch (IOException e) {
            try {
                throw new WxErrorException("load wx.properties error,class, can't find wx.properties");
            } catch (WxErrorException wxErrorException) {
                wxErrorException.printStackTrace();
            }
        }
    }

    public static synchronized WxConfig getInstance() {
        if (config == null) {
            config = new WxConfig();
        }
        return config;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "WxConfig{" +
                "appId='" + appId + '\'' +
                ", appSecret='" + appSecret + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
