//package priv.ys.controller;
//
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import priv.ys.api.WxConsts;
//import priv.ys.api.WxMessageRouter;
//import priv.ys.bean.WxXmlMessage;
//import priv.ys.bean.WxXmlOutMessage;
//import priv.ys.service.WxService;
//import priv.ys.util.xml.XStreamTransformer;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@RestController
//@RequestMapping("/wx")
//public class WeChatController {
//
//    @Resource
//    WxService wxService;
//
//
///**
// *    signature 微信加密签名，结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
//      timestamp 时间戳
//      nonce 随机数
//      echostr 随机字符串
// */
//    @GetMapping
//    public String check(String signature,String timestamp,String nonce,String echostr) {
//        if (wxService.checkSignature(signature, timestamp, nonce)) {
//            return echostr;
//        }
//        return null;
//    }
//
//    @PostMapping
//    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter out = response.getWriter();
//
////        // 创建一个路由器
//        WxMessageRouter router = new WxMessageRouter(wxService);
//        try {
//            // 微信服务器推送过来的是XML格式。
//            WxXmlMessage wx = XStreamTransformer.fromXml(WxXmlMessage.class, request.getInputStream());
//            System.out.println("消息：\n " + wx.toString());
////            router.rule().msgType(WxConsts.XML_MSG_TEXT).matcher(new WhoAmIMatcher()).handler(new WhoAmIHandler()).end()
////                    .rule().msgType(WxConsts.XML_MSG_TEXT).handler(ConfigHander.getInstance()).end()
////                    .rule().event(WxConsts.EVT_CLICK).eventKey(MenuKey.HELP).handler(HelpDocHandler.getInstance()).next()
////                    .rule().eventKey(MenuKey.CHANGE_NEWS).handler(ChangeNewsHandler.getInstance()).next()
////                    .rule().eventKey(MenuKey.HOT_SONG).handler(RankHandler.getInstance()).next()
////                    .rule().eventKey(MenuKey.TOP_500).handler(RankHandler.getInstance()).next()
////                    .rule().eventKey(MenuKey.NET_HOT_SONG).handler(RankHandler.getInstance()).next()
////                    .rule().eventKey(MenuKey.HUAYU_SONG).handler(RankHandler.getInstance()).next()
////                    .rule().eventKey(MenuKey.XINAO_SONG).handler(RankHandler.getInstance()).end();
//            // 把消息传递给路由器进行处理
//            WxXmlOutMessage xmlOutMsg = router.route(wx);
//            if (xmlOutMsg != null) {
//                out.print(xmlOutMsg.toXml());// 因为是明文，所以不用加密，直接返回给用户。
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            out.close();
//        }
//
//    }
//
//}
