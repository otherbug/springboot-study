//package priv.ys.api;
//
//import priv.ys.bean.WxXmlMessage;
//import priv.ys.bean.WxXmlOutMessage;
//import priv.ys.exception.WxErrorException;
//import priv.ys.exception.WxErrorExceptionHandler;
//import priv.ys.service.WxService;
//
//import java.util.*;
//import java.util.regex.Pattern;
//
//public class WxMessageRouterRule {
//    private final WxMessageRouter routerBuilder;
//    private String fromUser;
//    private String msgType;
//    private String event;
//    private String eventKey;
//    private String content;
//    private String rContent;
//    private WxMessageMatcher matcher;
//    private boolean reEnter = false;
//    private List<WxMessageHandler> handlers = new ArrayList();
//    private List<WxMessageInterceptor> interceptors = new ArrayList();
//
//    protected WxMessageRouterRule(WxMessageRouter routerBuilder) {
//        this.routerBuilder = routerBuilder;
//    }
//
//    public WxMessageRouterRule msgType(String msgType) {
//        this.msgType = msgType;
//        return this;
//    }
//
//    public WxMessageRouterRule event(String event) {
//        this.event = event;
//        return this;
//    }
//
//    public WxMessageRouterRule eventKey(String eventKey) {
//        this.eventKey = eventKey;
//        return this;
//    }
//
//    public WxMessageRouterRule content(String content) {
//        this.content = content;
//        return this;
//    }
//
//    public WxMessageRouterRule rContent(String regex) {
//        this.rContent = regex;
//        return this;
//    }
//
//    public WxMessageRouterRule fromUser(String fromUser) {
//        this.fromUser = fromUser;
//        return this;
//    }
//
//    public WxMessageRouterRule matcher(WxMessageMatcher matcher) {
//        this.matcher = matcher;
//        return this;
//    }
//
//    public WxMessageRouterRule interceptor(WxMessageInterceptor interceptor) {
//        return this.interceptor(interceptor, (WxMessageInterceptor[])null);
//    }
//
//    public WxMessageRouterRule interceptor(WxMessageInterceptor interceptor, WxMessageInterceptor... otherInterceptors) {
//        this.interceptors.add(interceptor);
//        if (otherInterceptors != null && otherInterceptors.length > 0) {
//            WxMessageInterceptor[] var3 = otherInterceptors;
//            int var4 = otherInterceptors.length;
//
//            for(int var5 = 0; var5 < var4; ++var5) {
//                WxMessageInterceptor i = var3[var5];
//                this.interceptors.add(i);
//            }
//        }
//
//        return this;
//    }
//
//    public WxMessageRouterRule handler(WxMessageHandler handler) {
//        return this.handler(handler, (WxMessageHandler[])null);
//    }
//
//    public WxMessageRouterRule handler(WxMessageHandler handler, WxMessageHandler... otherHandlers) {
//        this.handlers.add(handler);
//        if (otherHandlers != null && otherHandlers.length > 0) {
//            WxMessageHandler[] var3 = otherHandlers;
//            int var4 = otherHandlers.length;
//
//            for(int var5 = 0; var5 < var4; ++var5) {
//                WxMessageHandler i = var3[var5];
//                this.handlers.add(i);
//            }
//        }
//
//        return this;
//    }
//
//    public WxMessageRouter end() {
//        this.routerBuilder.getRules().add(this);
//        return this.routerBuilder;
//    }
//
//    public WxMessageRouter next() {
//        this.reEnter = true;
//        return this.end();
//    }
//
//    protected boolean test(WxXmlMessage wxMessage) {
//        return (this.fromUser == null || this.fromUser.equals(wxMessage.getFromUserName())) && (this.msgType == null || this.msgType.equals(wxMessage.getMsgType())) && (this.event == null || this.event.equals(wxMessage.getEvent())) && (this.eventKey == null || this.eventKey.equals(wxMessage.getEventKey())) && (this.content == null || this.content.equals(wxMessage.getContent() == null ? null : wxMessage.getContent().trim())) && (this.rContent == null || Pattern.matches(this.rContent, wxMessage.getContent() == null ? "" : wxMessage.getContent().trim())) && (this.matcher == null || this.matcher.match(wxMessage));
//    }
//
//    protected WxXmlOutMessage service(WxXmlMessage wxMessage, WxService wxService, WxErrorExceptionHandler exceptionHandler) {
//        try {
//            Map<String, Object> context = new HashMap();
//            Iterator var5 = this.interceptors.iterator();
//
//            while(var5.hasNext()) {
//                WxMessageInterceptor interceptor = (WxMessageInterceptor)var5.next();
//                if (!interceptor.intercept(wxMessage, context, wxService)) {
//                    return null;
//                }
//            }
//
//            WxXmlOutMessage res = null;
//
//            WxMessageHandler handler;
//            for(Iterator var10 = this.handlers.iterator(); var10.hasNext(); res = handler.handle(wxMessage, context, wxService)) {
//                handler = (WxMessageHandler)var10.next();
//            }
//
//            return res;
//        } catch (WxErrorException var8) {
//            var8.printStackTrace();
//            exceptionHandler.handle(var8);
//            return null;
//        }
//    }
//
//    public void setFromUser(String fromUser) {
//        this.fromUser = fromUser;
//    }
//
//    public void setMsgType(String msgType) {
//        this.msgType = msgType;
//    }
//
//    public void setEvent(String event) {
//        this.event = event;
//    }
//
//    public void setEventKey(String eventKey) {
//        this.eventKey = eventKey;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public void setrContent(String rContent) {
//        this.rContent = rContent;
//    }
//
//    public void setMatcher(WxMessageMatcher matcher) {
//        this.matcher = matcher;
//    }
//
//    public void setHandlers(List<WxMessageHandler> handlers) {
//        this.handlers = handlers;
//    }
//
//    public void setInterceptors(List<WxMessageInterceptor> interceptors) {
//        this.interceptors = interceptors;
//    }
//
//    public boolean isReEnter() {
//        return this.reEnter;
//    }
//
//    public void setReEnter(boolean reEnter) {
//        this.reEnter = reEnter;
//    }
//}
