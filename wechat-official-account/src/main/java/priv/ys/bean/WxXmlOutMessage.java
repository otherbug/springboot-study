//package priv.ys.bean;
//
//
//import com.thoughtworks.xstream.annotations.XStreamAlias;
//import com.thoughtworks.xstream.annotations.XStreamConverter;
//import priv.ys.api.WxConfig;
//import priv.ys.util.crypto.WXBizMsgCrypt;
//import priv.ys.util.xml.XStreamCDataConverter;
//import priv.ys.util.xml.XStreamTransformer;
//
//@XStreamAlias("xml")
//public abstract class WxXmlOutMessage {
//    @XStreamAlias("ToUserName")
//    @XStreamConverter(XStreamCDataConverter.class)
//    protected String toUserName;
//    @XStreamAlias("FromUserName")
//    @XStreamConverter(XStreamCDataConverter.class)
//    protected String fromUserName;
//    @XStreamAlias("CreateTime")
//    protected Long createTime;
//    @XStreamAlias("MsgType")
//    @XStreamConverter(XStreamCDataConverter.class)
//    protected String msgType;
//
//    public WxXmlOutMessage() {
//    }
//
//    public String getToUserName() {
//        return this.toUserName;
//    }
//
//    public void setToUserName(String toUserName) {
//        this.toUserName = toUserName;
//    }
//
//    public String getFromUserName() {
//        return this.fromUserName;
//    }
//
//    public void setFromUserName(String fromUserName) {
//        this.fromUserName = fromUserName;
//    }
//
//    public Long getCreateTime() {
//        return this.createTime;
//    }
//
//    public void setCreateTime(Long createTime) {
//        this.createTime = createTime;
//    }
//
//    public String getMsgType() {
//        return this.msgType;
//    }
//
//    public void setMsgType(String msgType) {
//        this.msgType = msgType;
//    }
//
//    public String toXml() {
//        return XStreamTransformer.toXml(this.getClass(), this);
//    }
//
//    public static String encryptMsg(WxConfig wxconfig, String replyMsg, String timeStamp, String nonce) throws AesException {
//        WXBizMsgCrypt pc = new WXBizMsgCrypt(WxConfig.getInstance().getToken(), WxConfig.getInstance().getAesKey(), WxConfig.getInstance().getAppId());
//        return pc.encryptMsg(replyMsg, timeStamp, nonce);
//    }
//
//    public static TextBuilder TEXT() {
//        return new TextBuilder();
//    }
//
//    public static ImageBuilder IMAGE() {
//        return new ImageBuilder();
//    }
//
//    public static VoiceBuilder VOICE() {
//        return new VoiceBuilder();
//    }
//
//    public static VideoBuilder VIDEO() {
//        return new VideoBuilder();
//    }
//
//    public static NewsBuilder NEWS() {
//        return new NewsBuilder();
//    }
//
//    public static MusicBuilder MUSIC() {
//        return new MusicBuilder();
//    }
//
//    public String toString() {
//        return "WxXmlOutMessage [toUserName=" + this.toUserName + ", fromUserName=" + this.fromUserName + ", createTime=" + this.createTime + ", msgType=" + this.msgType + "]";
//    }
//}
