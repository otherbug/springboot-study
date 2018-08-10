//package priv.ys.bean;
//
//import com.thoughtworks.xstream.annotations.XStreamAlias;
//import com.thoughtworks.xstream.annotations.XStreamConverter;
//import org.apache.commons.io.IOUtils;
//import priv.ys.api.WxConfig;
//import priv.ys.util.crypto.WXBizMsgCrypt;
//import priv.ys.util.xml.XStreamCDataConverter;
//import priv.ys.util.xml.XStreamTransformer;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//@XStreamAlias("xml")
//public class WxXmlMessage {
//
//    //如果是普通消息 会包含下面的参数
//    @XStreamAlias("ToUserName")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String toUserName;//开发者微信号
//    @XStreamAlias("FromUserName")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String fromUserName;//发送方账号
//    @XStreamAlias("CreateTime")
//    private Long createTime;//消息创建时间
//
//    @XStreamAlias("MsgType")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String msgType;//text，image
//    @XStreamAlias("Content")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String content;//文本消息内容
//    @XStreamAlias("MsgId")
//    private Long msgId;//消息id 64位整数
//
//    //如果是图片消息 会包含下面的参数
//    @XStreamAlias("PicUrl")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String picUrl;//图片链接，由系统生成
//    @XStreamAlias("MediaId")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String mediaId;//图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
//    @XStreamAlias("Format")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String format;//
//    @XStreamAlias("ThumbMediaId")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String thumbMediaId;//
//    @XStreamAlias("Location_X")
//    private Double locationX;//
//    @XStreamAlias("Location_Y")
//    private Double locationY;//
//    @XStreamAlias("Scale")
//    private Double scale;//
//    @XStreamAlias("Label")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String label;//
//    @XStreamAlias("Title")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String title;//
//    @XStreamAlias("Description")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String description;//
//    @XStreamAlias("Url")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String url;//
//    @XStreamAlias("Event")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String event;//
//    @XStreamAlias("EventKey")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String eventKey;//
//    @XStreamAlias("Ticket")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String ticket;//
//    @XStreamAlias("Latitude")
//    private Double latitude;//
//    @XStreamAlias("Longitude")
//    private Double longitude;//
//    @XStreamAlias("Precision")
//    private Double precision;//
//    @XStreamAlias("Recognition")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String recognition;//
//    @XStreamAlias("ExpiredTime")
//    private String expiredTime;//
//    @XStreamAlias("FailTime")
//    private String failTime;//
//    @XStreamAlias("FailReason")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String failReason;//
//    @XStreamAlias("TransInfo")
//    private WxXmlMessage.WxKf kf;//
//    @XStreamAlias("KfAccount")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String kfAccount;//
//    @XStreamAlias("FromKfAccount")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String fromKfAccount;//
//    @XStreamAlias("ToKfAccount")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String toKfAccount;//
//    @XStreamAlias("Status")
//    @XStreamConverter(XStreamCDataConverter.class)
//    private String status;//
//    @XStreamAlias("TotalCount")
//    private Integer totalCount;//
//    @XStreamAlias("FilterCount")
//    private Integer filterCount;//
//    @XStreamAlias("SentCount")
//    private Integer sentCount;//
//    @XStreamAlias("ErrorCount")
//    private Integer errorCount;//
//    @XStreamAlias("ScanCodeInfo")
//    private WxXmlMessage.ScanCodeInfo scanCodeInfo = new WxXmlMessage.ScanCodeInfo();
//    @XStreamAlias("SendPicsInfo")
//    private WxXmlMessage.SendPicsInfo sendPicsInfo = new WxXmlMessage.SendPicsInfo();
//    @XStreamAlias("SendLocationInfo")
//    private WxXmlMessage.SendLocationInfo sendLocationInfo = new WxXmlMessage.SendLocationInfo();
//
//    public WxXmlMessage() {
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
//    public String getContent() {
//        return this.content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public Long getMsgId() {
//        return this.msgId;
//    }
//
//    public void setMsgId(Long msgId) {
//        this.msgId = msgId;
//    }
//
//    public String getPicUrl() {
//        return this.picUrl;
//    }
//
//    public void setPicUrl(String picUrl) {
//        this.picUrl = picUrl;
//    }
//
//    public String getMediaId() {
//        return this.mediaId;
//    }
//
//    public void setMediaId(String mediaId) {
//        this.mediaId = mediaId;
//    }
//
//    public String getFormat() {
//        return this.format;
//    }
//
//    public void setFormat(String format) {
//        this.format = format;
//    }
//
//    public String getThumbMediaId() {
//        return this.thumbMediaId;
//    }
//
//    public void setThumbMediaId(String thumbMediaId) {
//        this.thumbMediaId = thumbMediaId;
//    }
//
//    public Double getLocationX() {
//        return this.locationX;
//    }
//
//    public void setLocationX(Double locationX) {
//        this.locationX = locationX;
//    }
//
//    public Double getLocationY() {
//        return this.locationY;
//    }
//
//    public void setLocationY(Double locationY) {
//        this.locationY = locationY;
//    }
//
//    public Double getScale() {
//        return this.scale;
//    }
//
//    public void setScale(Double scale) {
//        this.scale = scale;
//    }
//
//    public String getLabel() {
//        return this.label;
//    }
//
//    public void setLabel(String label) {
//        this.label = label;
//    }
//
//    public String getTitle() {
//        return this.title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return this.description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getUrl() {
//        return this.url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getEvent() {
//        return this.event;
//    }
//
//    public void setEvent(String event) {
//        this.event = event;
//    }
//
//    public String getEventKey() {
//        return this.eventKey;
//    }
//
//    public void setEventKey(String eventKey) {
//        this.eventKey = eventKey;
//    }
//
//    public String getTicket() {
//        return this.ticket;
//    }
//
//    public void setTicket(String ticket) {
//        this.ticket = ticket;
//    }
//
//    public Double getLatitude() {
//        return this.latitude;
//    }
//
//    public void setLatitude(Double latitude) {
//        this.latitude = latitude;
//    }
//
//    public Double getLongitude() {
//        return this.longitude;
//    }
//
//    public void setLongitude(Double longitude) {
//        this.longitude = longitude;
//    }
//
//    public Double getPrecision() {
//        return this.precision;
//    }
//
//    public void setPrecision(Double precision) {
//        this.precision = precision;
//    }
//
//    public String getRecognition() {
//        return this.recognition;
//    }
//
//    public void setRecognition(String recognition) {
//        this.recognition = recognition;
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
//    public String getExpiredTime() {
//        return this.expiredTime;
//    }
//
//    public void setExpiredTime(String expiredTime) {
//        this.expiredTime = expiredTime;
//    }
//
//    public String getFailTime() {
//        return this.failTime;
//    }
//
//    public void setFailTime(String failTime) {
//        this.failTime = failTime;
//    }
//
//    public String getFailReason() {
//        return this.failReason;
//    }
//
//    public void setFailReason(String failReason) {
//        this.failReason = failReason;
//    }
//
//    protected static WxXmlMessage fromXml(String xml) {
//        return (WxXmlMessage) XStreamTransformer.fromXml(WxXmlMessage.class, xml);
//    }
//
//    protected static WxXmlMessage fromXml(InputStream is) {
//        return (WxXmlMessage) XStreamTransformer.fromXml(WxXmlMessage.class, is);
//    }
//
//    public static WxXmlMessage decryptMsg(String encryptedXml, WxConfig wxConfig, String timestamp, String nonce, String msgSignature) throws AesException {
//        WXBizMsgCrypt pc = new WXBizMsgCrypt(WxConfig.getInstance().getToken(), WxConfig.getInstance().getAesKey(), WxConfig.getInstance().getAppId());
//        String plainText = pc.decryptMsg(msgSignature, timestamp, nonce, encryptedXml);
//        return fromXml(plainText);
//    }
//
//    public static WxXmlMessage decryptMsg(InputStream is, WxConfig wxConfig, String timestamp, String nonce, String msgSignature) throws AesException {
//        try {
//            return decryptMsg(IOUtils.toString(is, "UTF-8"), wxConfig, timestamp, nonce, msgSignature);
//        } catch (IOException var6) {
//            throw new RuntimeException(var6);
//        }
//    }
//
//    public String getStatus() {
//        return this.status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public Integer getTotalCount() {
//        return this.totalCount;
//    }
//
//    public void setTotalCount(Integer totalCount) {
//        this.totalCount = totalCount;
//    }
//
//    public Integer getFilterCount() {
//        return this.filterCount;
//    }
//
//    public void setFilterCount(Integer filterCount) {
//        this.filterCount = filterCount;
//    }
//
//    public Integer getSentCount() {
//        return this.sentCount;
//    }
//
//    public void setSentCount(Integer sentCount) {
//        this.sentCount = sentCount;
//    }
//
//    public Integer getErrorCount() {
//        return this.errorCount;
//    }
//
//    public void setErrorCount(Integer errorCount) {
//        this.errorCount = errorCount;
//    }
//
//    public WxXmlMessage.ScanCodeInfo getScanCodeInfo() {
//        return this.scanCodeInfo;
//    }
//
//    public void setScanCodeInfo(WxXmlMessage.ScanCodeInfo scanCodeInfo) {
//        this.scanCodeInfo = scanCodeInfo;
//    }
//
//    public WxXmlMessage.SendPicsInfo getSendPicsInfo() {
//        return this.sendPicsInfo;
//    }
//
//    public void setSendPicsInfo(WxXmlMessage.SendPicsInfo sendPicsInfo) {
//        this.sendPicsInfo = sendPicsInfo;
//    }
//
//    public WxXmlMessage.SendLocationInfo getSendLocationInfo() {
//        return this.sendLocationInfo;
//    }
//
//    public void setSendLocationInfo(WxXmlMessage.SendLocationInfo sendLocationInfo) {
//        this.sendLocationInfo = sendLocationInfo;
//    }
//
//    public WxXmlMessage.WxKf getKf() {
//        return this.kf;
//    }
//
//    public void setKf(WxXmlMessage.WxKf kf) {
//        this.kf = kf;
//    }
//
//    public String getKfAccount() {
//        return this.kfAccount;
//    }
//
//    public void setKfAccount(String kfAccount) {
//        this.kfAccount = kfAccount;
//    }
//
//    public String getFromKfAccount() {
//        return this.fromKfAccount;
//    }
//
//    public void setFromKfAccount(String fromKfAccount) {
//        this.fromKfAccount = fromKfAccount;
//    }
//
//    public String getToKfAccount() {
//        return this.toKfAccount;
//    }
//
//    public void setToKfAccount(String toKfAccount) {
//        this.toKfAccount = toKfAccount;
//    }
//
//    public String toString() {
//        return "WxXmlMessage [toUserName=" + this.toUserName + ", fromUserName=" + this.fromUserName + ", createTime=" + this.createTime + ", msgType=" + this.msgType + ", content=" + this.content + ", msgId=" + this.msgId + ", picUrl=" + this.picUrl + ", mediaId=" + this.mediaId + ", format=" + this.format + ", thumbMediaId=" + this.thumbMediaId + ", locationX=" + this.locationX + ", locationY=" + this.locationY + ", scale=" + this.scale + ", label=" + this.label + ", title=" + this.title + ", description=" + this.description + ", url=" + this.url + ", event=" + this.event + ", eventKey=" + this.eventKey + ", ticket=" + this.ticket + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", precision=" + this.precision + ", recognition=" + this.recognition + ", expiredTime=" + this.expiredTime + ", failTime=" + this.failTime + ", failReason=" + this.failReason + ", status=" + this.status + ", totalCount=" + this.totalCount + ", filterCount=" + this.filterCount + ", sentCount=" + this.sentCount + ", errorCount=" + this.errorCount + ", scanCodeInfo=" + this.scanCodeInfo + ", sendPicsInfo=" + this.sendPicsInfo + ", sendLocationInfo=" + this.sendLocationInfo + "]";
//    }
//
//    @XStreamAlias("SendLocationInfo")
//    public static class SendLocationInfo {
//        @XStreamAlias("Location_X")
//        @XStreamConverter(XStreamCDataConverter.class)
//        private String locationX;
//        @XStreamAlias("Location_Y")
//        @XStreamConverter(XStreamCDataConverter.class)
//        private String locationY;
//        @XStreamAlias("Scale")
//        @XStreamConverter(XStreamCDataConverter.class)
//        private String scale;
//        @XStreamAlias("Label")
//        @XStreamConverter(XStreamCDataConverter.class)
//        private String label;
//        @XStreamAlias("Poiname")
//        @XStreamConverter(XStreamCDataConverter.class)
//        private String poiname;
//
//        public SendLocationInfo() {
//        }
//
//        public String getLocationX() {
//            return this.locationX;
//        }
//
//        public void setLocationX(String locationX) {
//            this.locationX = locationX;
//        }
//
//        public String getLocationY() {
//            return this.locationY;
//        }
//
//        public void setLocationY(String locationY) {
//            this.locationY = locationY;
//        }
//
//        public String getScale() {
//            return this.scale;
//        }
//
//        public void setScale(String scale) {
//            this.scale = scale;
//        }
//
//        public String getLabel() {
//            return this.label;
//        }
//
//        public void setLabel(String label) {
//            this.label = label;
//        }
//
//        public String getPoiname() {
//            return this.poiname;
//        }
//
//        public void setPoiname(String poiname) {
//            this.poiname = poiname;
//        }
//    }
//
//    @XStreamAlias("SendPicsInfo")
//    public static class SendPicsInfo {
//        @XStreamAlias("Count")
//        private Long count;
//        @XStreamAlias("PicList")
//        protected final List<Item> picList = new ArrayList();
//
//        public SendPicsInfo() {
//        }
//
//        public Long getCount() {
//            return this.count;
//        }
//
//        public void setCount(Long count) {
//            this.count = count;
//        }
//
//        public List<WxXmlMessage.SendPicsInfo.Item> getPicList() {
//            return this.picList;
//        }
//
//        @XStreamAlias("Item")
//        public static class Item {
//            @XStreamAlias("PicMd5Sum")
//            @XStreamConverter(XStreamCDataConverter.class)
//            private String PicMd5Sum;
//
//            public Item() {
//            }
//
//            public String getPicMd5Sum() {
//                return this.PicMd5Sum;
//            }
//
//            public void setPicMd5Sum(String picMd5Sum) {
//                this.PicMd5Sum = picMd5Sum;
//            }
//        }
//    }
//
//    @XStreamAlias("ScanCodeInfo")
//    public static class ScanCodeInfo {
//        @XStreamAlias("ScanType")
//        @XStreamConverter(XStreamCDataConverter.class)
//        private String scanType;
//        @XStreamAlias("ScanResult")
//        @XStreamConverter(XStreamCDataConverter.class)
//        private String scanResult;
//
//        public ScanCodeInfo() {
//        }
//
//        public String getScanType() {
//            return this.scanType;
//        }
//
//        public void setScanType(String scanType) {
//            this.scanType = scanType;
//        }
//
//        public String getScanResult() {
//            return this.scanResult;
//        }
//
//        public void setScanResult(String scanResult) {
//            this.scanResult = scanResult;
//        }
//    }
//
//    public static class WxKf {
//        @XStreamAlias("KfAccount")
//        @XStreamConverter(XStreamCDataConverter.class)
//        private String kfAccount;
//
//        public WxKf() {
//        }
//
//        public String getKfAccount() {
//            return this.kfAccount;
//        }
//
//        public void setKfAccount(String kfAccount) {
//            this.kfAccount = kfAccount;
//        }
//
//        public String toString() {
//            return "WxKf [kfAccount=" + this.kfAccount + "]";
//        }
//    }
//}
