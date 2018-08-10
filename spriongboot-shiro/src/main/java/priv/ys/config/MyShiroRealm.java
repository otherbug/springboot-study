package priv.ys.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import priv.ys.entity.SysPermission;
import priv.ys.entity.SysRole;
import priv.ys.entity.UserInfo;
import priv.ys.service.UserInfoService;

import javax.annotation.Resource;

/**
 * 身份校验核心类
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserInfoService userInfoService;

    /**
     * 身份验证 认证信息
     * Authentication
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("校验认证信息开始ヾ(◍°∇°◍)ﾉﾞ");

        //获取用户输入的账号
        String username = (String) authenticationToken.getPrincipal();
        System.out.println("可以相信的证明  " + authenticationToken.getCredentials());


        //通过username查找UserInfo
        //实际项目中，可以根据实际情况做缓存，如果不做。Shiro自己也是有时间间隔机制。2分钟内不会重复执行该方法
        UserInfo userInfo = userInfoService.findByUsername(username);
        System.out.println("真实的Info    " + userInfo);
        if (userInfo == null) {
            return null;
        }

        /*
         *获取权限信息：这里没有实现
         * 自行根据UserInfo，Role，Permission实现
         * 获取之后可以在前段for循环显示所有链接
         */
//        userInfo.set


        //账号判断


        //加密方式
        //交给AuthenticatingRealm是用CredentialsMatcher进行密码匹配，如果觉得不好可以自行定义
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(),
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
                getName()//realm name
        );

        //明文:若存在，将此用户放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(),
//                getName()
//        );

        return authenticationInfo;
    }


    /**
     * 此方法调用 hasRole，hasPermission的时候才会进行回调
     * <p>
     * 权限信息 授权
     * 1.如果用户正常退出，缓存自动清空
     * 2.如果用户非正常退出，缓存自动清空
     * 3.如果我们修改了权限，而用户不退出系统，修改的权限不会立即生效
     * （需要手动编程进行实现，放在Service层刁调用）
     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例
     * 调用clearCache方法；
     * Authorization是权限访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作。如访问某个链接，某个资源等。
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /*
        * 当没有使用缓存的时候，不断刷新页面的话，这个代码会不断执行，
        * 其时没必要每次都重新设置权限信息，所以需要放到缓存中进行管理
        * 当放到缓存中时，这样的话，doGetAuthorizationInfo就会执行一次了
        * 缓存过期后会再次执行
        */
        System.out.println("权限配置开始了٩ヾ(๑╹◡╹)ﾉ");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();

        //实际项目中，这里可以和根据实际情况做缓存，如果不做，shiro自己也有时间间隔机制。2分钟内不会重复执行该方法。
//        userInfo userInfo=userInfoService.findByUsername(username);

        //单个权限添加
        //或者按下面这样添加
        // 添加一个角色，不是配置意义上的添加，而是证明该用户拥有admin角色
//        authorizationInfo.addRole("admin");
        //添加权限
//        authorizationInfo.addStringPermission("userInfo:query");

        //在认证成功之后返回
        //设置角色信息
        //支持set集合
        //用户的角色对应的所有权限，如果只使用角色定义访问权限。下面的四行可以不要
//        List<Role> roleList=user.getRoleList();
//        for (Role role : roleList) {
//            info.addStringPermissions(role.getPermissionsName());
//        }

        for (SysRole role:userInfo.getRoleList()) {
            authorizationInfo.addRole(role.getRole());
            for (SysPermission permission:role.getPermissions()){
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }

        return authorizationInfo;
    }
}
