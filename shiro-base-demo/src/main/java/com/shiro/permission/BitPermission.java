package com.shiro.permission;

import com.alibaba.druid.util.StringUtils;
import org.apache.shiro.authz.Permission;

/**
 * @ClassName: BitPermission
 * @author:zhouzhu
 * @Date: 2018/7/10 16:29
 * @Version: V1.0
 */
public class BitPermission implements Permission{

    private String resourceIdentify;
    private int permissionBit;
    private String instanceId;

    public BitPermission(String permissionString){
        String[] array = permissionString.split("\\+");
        if(array.length>1){
            resourceIdentify=array[1];
        }
        if(StringUtils.isEmpty(resourceIdentify)){
            resourceIdentify="*";
        }
        if(array.length>2){
            permissionBit=Integer.valueOf(array[2]);
        }
        if(array.length>3){
            instanceId=array[3];
        }
        if(StringUtils.isEmpty(instanceId)){
            instanceId="*";
        }
    }

    @Override
    public boolean implies(Permission permission) {
        if(!(permission instanceof BitPermission)){
            return false;
        }
        BitPermission other=(BitPermission) permission;
        if(!("*".equals(this.resourceIdentify) || this.resourceIdentify.equals(other.resourceIdentify))){
            return false;
        }
        if(!(this.permissionBit==0 || (this.permissionBit & other.permissionBit) !=0)){
            return false;
        }
        if(!("*".equals(this.instanceId) || this.instanceId.equals(other.instanceId))){
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "BitPermission{" +
                "resourceIdentify='" + resourceIdentify + '\'' +
                ", permissionBit=" + permissionBit +
                ", instanceId='" + instanceId + '\'' +
                '}';
    }
}
