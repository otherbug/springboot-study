//package priv.ys.bean;
//
//import com.thoughtworks.xstream.annotations.XStreamAlias;
//import com.thoughtworks.xstream.annotations.XStreamConverter;
//import priv.ys.util.xml.XStreamMediaIdConverter;
//
//@XStreamAlias("xml")
//public class WxXmlOutImageMessage extends WxXmlOutMessage {
//    @XStreamAlias("Image")
//    @XStreamConverter(XStreamMediaIdConverter.class)
//    private String mediaId;
//
//    public WxXmlOutImageMessage() {
//        this.msgType = "image";
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
//
