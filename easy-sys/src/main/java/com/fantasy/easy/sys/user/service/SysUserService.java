/**
 * SysUserService.java
 * @author Fantasy Lan
 */
package com.fantasy.easy.sys.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fantasy.easy.sys.role.SysRoleEntity;
import com.fantasy.easy.sys.user.mapper.SysUserMapper;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fantasy.easy.core.entity.SysMenuEntity;
import com.fantasy.easy.core.entity.SysUserEntity;
import com.fantasy.easy.core.exception.EasyApplicationException;
import com.fantasy.easy.core.util.ShiroUtils;
import com.fantasy.easy.sys.menu.service.SysMenuService;

/**
 * @author Fantasy Lan
 * @since 2019年11月5日 : 下午10:39:01
 */
@RestController
@RequestMapping("user")
public class SysUserService {
	
	@Autowired
	private SysMenuService sysMenuService;
	@Autowired
    private SysUserMapper sysUserMapper;

    @RequestMapping("list")
    public IPage<SysUserEntity> list(SysUserEntity userEntity, Page<SysUserEntity> p){
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(userEntity);
        return sysUserMapper.selectPage(p, queryWrapper);
    }

    @RequestMapping("getUserByRole")
    public IPage<SysUserEntity> getUserByRole(SysRoleEntity roleEntity, Page<SysUserEntity> p){
        return sysUserMapper.getUserByRole(p, roleEntity);
    }

    @PostMapping("save")
    public int save(SysUserEntity userEntity){
        if(userEntity.getUserId() != null && userEntity.getUserId() != 0){
            return sysUserMapper.updateById(userEntity);
        }
        return sysUserMapper.insert(userEntity);
    }
	
    /**
     * 登录
     * @throws EasyApplicationException 
     */
    @RequestMapping("/login")
    public String login (HttpServletRequest request, Map<String, Object> map) throws EasyApplicationException{
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "登录成功";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
                throw new EasyApplicationException("账号不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
                throw new EasyApplicationException("密码不正确");
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
                throw new EasyApplicationException("验证码错误");
            } else {
                msg = "else >> "+exception;
                throw new EasyApplicationException("未知错误！" + exception);
            }
        }
        SysUserEntity user = ShiroUtils.getUserEntity();
        user.setName(user.getUserName());
        user.setUserPwd("");
        user.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        user.setMenuList(getUserMenu());
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return msg;
    }
    
    /**
     * 退出测试
     */
    @RequestMapping("/logout")
    public @ResponseBody String logout (){
        ShiroUtils.logout();
        return "success" ;
    }

	@GetMapping
	@RequestMapping("info")
	public SysUserEntity getUserInfo() {
		// 'admin-token': {
		// roles: ['admin'],
		// introduction: 'I am a super administrator',
		// avatar:
		// 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
		// name: 'Super Admin'
		// }
		return ShiroUtils.getUserEntity();
	}
	
	@GetMapping
	@RequestMapping("menu")
	public List<SysMenuEntity> getUserMenu() {
		List<SysMenuEntity> menus = sysMenuService.getUserMenu();
		return menus;
	}
}
