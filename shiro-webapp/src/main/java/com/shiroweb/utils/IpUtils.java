package com.shiroweb.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: IpUtils
 * @author:zhouzhu
 * @Date: 2018/7/24 15:04
 * @Version: V1.0
 */
public class IpUtils {
    private IpUtils(){

    }
    public static String getIpAddr(HttpServletRequest request){
        if(request==null){
            return "unknown";
        }
        String ip=request.getHeader("x-forwarded-for");
        if(ip==null || ip.length()==0||"unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("Proxy-Client-IP");
        }
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("X-Forwarded-For");
        }
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
