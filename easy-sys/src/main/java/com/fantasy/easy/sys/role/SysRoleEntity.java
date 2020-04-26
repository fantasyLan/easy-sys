package com.fantasy.easy.sys.role;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fantasy.easy.core.entity.BaseEntity;

import java.util.List;

/**
 * Created by fantasy on 2020/2/25.
 */
@TableName("sys_role")
public class SysRoleEntity extends BaseEntity{

    @TableId(type= IdType.AUTO)
    private Long roleId;

    private String roleName;

    private String roleDesc;

    @TableField(exist = false)
    private List<Long> auths;

    @TableField(exist = false)
    private List<Long> userIds;

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public List<Long> getAuths() {
        return auths;
    }

    public void setAuths(List<Long> auths) {
        this.auths = auths;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
