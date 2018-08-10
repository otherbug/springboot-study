//package priv.ys.api;
//
//
//
//import priv.ys.bean.WxXmlMessage;
//import priv.ys.bean.WxXmlOutMessage;
//import priv.ys.exception.WxErrorExceptionHandler;
//import priv.ys.service.WxService;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class WxMessageRouter {
//    private final List<WxMessageRouterRule> rules = new ArrayList();
//    private final WxService wxService;
//    private WxErrorExceptionHandler exceptionHandler;
//
//    public WxMessageRouter(WxService wxService) {
//        this.wxService = wxService;
//    }
//
//    public void setExceptionHandler(WxErrorExceptionHandler exceptionHandler) {
//        this.exceptionHandler = exceptionHandler;
//    }
//
//    List<WxMessageRouterRule> getRules() {
//        return this.rules;
//    }
//
//    public WxMessageRouterRule rule() {
//        return new WxMessageRouterRule(this);
//    }
//
//    public WxXmlOutMessage route(WxXmlMessage wxMessage) {
//        List<WxMessageRouterRule> matchRules = new ArrayList();
//        Iterator var3 = this.rules.iterator();
//
//        while(var3.hasNext()) {
//            WxMessageRouterRule rule = (WxMessageRouterRule)var3.next();
//            if (rule.test(wxMessage)) {
//                matchRules.add(rule);
//                if (!rule.isReEnter()) {
//                    break;
//                }
//            }
//        }
//
//        if (matchRules.size() == 0) {
//            return null;
//        } else {
//            WxXmlOutMessage res = null;
//
//            WxMessageRouterRule rule;
//            for(Iterator var7 = matchRules.iterator(); var7.hasNext(); res = rule.service(wxMessage, this.wxService, this.exceptionHandler)) {
//                rule = (WxMessageRouterRule)var7.next();
//            }
//
//            return res;
//        }
//    }
//}
