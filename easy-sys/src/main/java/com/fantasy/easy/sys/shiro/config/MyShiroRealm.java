package com.fantasy.easy.sys.shiro.config;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.fantasy.easy.core.entity.SysUserEntity;
import com.fantasy.easy.sys.menu.mapper.SysMenuMapper;
import com.fantasy.easy.sys.user.mapper.SysUserMapper;

public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private SysUserMapper userInfoService;
    @Resource
    private SysMenuMapper sysMenuMapper;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUserEntity userInfo  = (SysUserEntity)principals.getPrimaryPrincipal();
        List<String> auths = userInfoService.queryAllAuthByUserId(userInfo.getUserId());
        for (String auth : auths) {
        	authorizationInfo.addStringPermission(auth);
		}
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        SysUserEntity userInfo = userInfoService.selectOne(username);
        System.out.println("----->>userInfo="+userInfo);
        if(userInfo == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getUserPwd(), //密码
                ByteSource.Util.bytes(userInfo.getUserName() + userInfo.getUserSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

}