//package priv.ys.util.xml;
//
//import com.thoughtworks.xstream.XStream;
//import priv.ys.bean.*;
//
//import java.io.InputStream;
//import java.util.HashMap;
//import java.util.Map;
//
//public class XStreamTransformer {
//    protected static final Map<Class, XStream> CLASS_2_XSTREAM_INSTANCE = configXStreamInstance();
//
//    public XStreamTransformer() {
//    }
//
//    public static <T> T fromXml(Class<T> clazz, String xml) {
//        T object = ((XStream)CLASS_2_XSTREAM_INSTANCE.get(clazz)).fromXML(xml);
//        return object;
//    }
//
//    public static <T> T fromXml(Class<T> clazz, InputStream is) {
//        T object = ((XStream)CLASS_2_XSTREAM_INSTANCE.get(clazz)).fromXML(is);
//        return object;
//    }
//
//    public static <T> String toXml(Class<T> clazz, T object) {
//        return ((XStream)CLASS_2_XSTREAM_INSTANCE.get(clazz)).toXML(object);
//    }
//
//    private static Map<Class, XStream> configXStreamInstance() {
//        Map<Class, XStream> map = new HashMap();
//        map.put(WxXmlMessage.class, config_WxXmlMessage());
//        map.put(WxXmlOutNewsMessage.class, config_WxXmlOutNewsMessage());
//        map.put(WxXmlOutTextMessage.class, config_WxXmlOutTextMessage());
//        map.put(WxXmlOutImageMessage.class, config_WxXmlOutImageMessage());
//        map.put(WxXmlOutVideoMessage.class, config_WxXmlOutVideoMessage());
//        map.put(WxXmlOutVoiceMessage.class, config_WxXmlOutVoiceMessage());
//        return map;
//    }
//
//    private static XStream config_WxXmlMessage() {
//        XStream xstream = XStreamInitializer.getInstance();
//        xstream.processAnnotations(WxXmlMessage.class);
//        xstream.processAnnotations(WxXmlMessage.ScanCodeInfo.class);
//        xstream.processAnnotations(WxXmlMessage.SendPicsInfo.class);
//        xstream.processAnnotations(WxXmlMessage.Item.class);
//        xstream.processAnnotations(WxXmlMessage.SendLocationInfo.class);
//        return xstream;
//    }
//
//    private static XStream config_WxXmlOutImageMessage() {
//        XStream xstream = XStreamInitializer.getInstance();
//        xstream.processAnnotations(WxXmlOutMessage.class);
//        xstream.processAnnotations(WxXmlOutImageMessage.class);
//        return xstream;
//    }
//
//    private static XStream config_WxXmlOutNewsMessage() {
//        XStream xstream = XStreamInitializer.getInstance();
//        xstream.processAnnotations(WxXmlOutMessage.class);
//        xstream.processAnnotations(WxXmlOutNewsMessage.class);
//        xstream.processAnnotations(WxXmlMessage.Item.class);
//        return xstream;
//    }
//
//    private static XStream config_WxXmlOutTextMessage() {
//        XStream xstream = XStreamInitializer.getInstance();
//        xstream.processAnnotations(WxXmlOutMessage.class);
//        xstream.processAnnotations(WxXmlOutTextMessage.class);
//        return xstream;
//    }
//
//    private static XStream config_WxXmlOutVideoMessage() {
//        XStream xstream = XStreamInitializer.getInstance();
//        xstream.processAnnotations(WxXmlOutMessage.class);
//        xstream.processAnnotations(WxXmlOutVideoMessage.class);
//        xstream.processAnnotations(WxXmlOutVideoMessage.Video.class);
//        return xstream;
//    }
//
//    private static XStream config_WxXmlOutVoiceMessage() {
//        XStream xstream = XStreamInitializer.getInstance();
//        xstream.processAnnotations(WxXmlOutMessage.class);
//        xstream.processAnnotations(WxXmlOutVoiceMessage.class);
//        return xstream;
//    }
//}