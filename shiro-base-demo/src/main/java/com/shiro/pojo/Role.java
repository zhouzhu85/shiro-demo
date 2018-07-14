package com.shiro.pojo;

import java.io.Serializable;

public class Role implements Serializable{
    private Long id;
    private String role;
    private String desciption;
    private Boolean available;


    public Role() {
    }

    public Role(String role, String desciption, Boolean available) {
        this.role = role;
        this.desciption = desciption;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null || getClass()!=obj.getClass()) return false;
        Role role=(Role) obj;
        if (id!=null?!id.equals(role.id):role.id!=null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        return id!=null?id.hashCode():0;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", desciption='" + desciption + '\'' +
                ", available=" + available +
                '}';
    }
}
