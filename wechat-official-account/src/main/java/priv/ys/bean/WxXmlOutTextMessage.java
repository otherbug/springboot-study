//package priv.ys.bean;
//
//import com.thoughtworks.xstream.annotations.XStreamAlias;
//import com.thoughtworks.xstream.annotations.XStreamConverter;
//import priv.ys.util.xml.XStreamCDataConverter;
//
//@XStreamAlias("xml")
//public class WxXmlOutTextMessage extends WxXmlOutMessage {
//    @XStreamAlias("Content")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String content;
//
//    public WxXmlOutTextMessage() {
//        this.msgType = "text";
//    }
//
//    public String getContent() {
//        return this.content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String toString() {
//        return "WxXmlOutTextMessage [content=" + this.content + "]";
//    }
//}
