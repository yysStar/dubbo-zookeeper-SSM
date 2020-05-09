package com.qiyun.model2;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Permission implements Serializable {

    private String role_name;
    private String role_desc;
    private Integer role_id;
    private String permissions;

    private List<Map> child_premission;

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_desc() {
        return role_desc;
    }

    public void setRole_desc(String role_desc) {
        this.role_desc = role_desc;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public List<Map> getChild_premission() {
        return child_premission;
    }

    public void setChild_premission(List<Map> child_premission) {
        this.child_premission = child_premission;
    }

    public Permission() {
    }

    public Permission(String role_name, String role_desc, Integer role_id, String permissions, List<Map> child_premission) {
        this.role_name = role_name;
        this.role_desc = role_desc;
        this.role_id = role_id;
        this.permissions = permissions;
        this.child_premission = child_premission;
    }
}
