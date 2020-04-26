/**
 * ShiroController.java
 * @author Fantasy Lan
 */
package com.fantasy.easy.sys.shiro.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fantasy.easy.core.entity.SysMenuEntity;
import com.fantasy.easy.sys.menu.mapper.SysMenuMapper;

/**
 * @author Fantasy Lan
 * @since 2019年11月5日 : 下午10:42:39
 * Shrio 权限控制层
 */
@RestController
@RequestMapping("shiroService")
public class ShiroService {
    private static Logger LOGGER = LoggerFactory.getLogger(ShiroService.class) ;


	@Resource
    private SysMenuMapper sysMenuMapper ;

    /**
     * 服务器每次重启请求该接口之前必须先请求上面登录接口
     * http://localhost:7011/menu/list 获取所有菜单列表
     * 权限要求：sys:user:shiro
     */
    @RequestMapping("/menu/list")
    @RequiresPermissions("sys:user:shiro")
    public @ResponseBody List<SysMenuEntity> list(){
        return sysMenuMapper.selectList() ;
    }

    /**
     * 用户没有该权限，无法访问
     * 权限要求：ccc:ddd:bbb
     */
    @RequestMapping("/menu/list2")
    @RequiresPermissions("ccc:ddd:bbb")
    public @ResponseBody List list2(){
        return sysMenuMapper.selectList() ;
    }

}