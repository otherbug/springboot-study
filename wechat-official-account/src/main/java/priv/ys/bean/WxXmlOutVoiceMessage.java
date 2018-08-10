//package priv.ys.bean;
//
//import com.thoughtworks.xstream.annotations.XStreamAlias;
//import com.thoughtworks.xstream.annotations.XStreamConverter;
//import priv.ys.util.xml.XStreamMediaIdConverter;
//
//@XStreamAlias("xml")
//public class WxXmlOutVoiceMessage extends WxXmlOutMessage {
//    @XStreamAlias("Voice")
//    @XStreamConverter(XStreamMediaIdConverter.class)
//    private String mediaId;
//
//    public WxXmlOutVoiceMessage() {
//        this.msgType = "voice";
//    }
//
//    public String getMediaId() {
//        return this.mediaId;
//    }
//
//    public void setMediaId(String mediaId) {
//        this.mediaId = mediaId;
//    }
//}
