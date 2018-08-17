package com.github.zhouzhu.shiro.core;

import org.apache.shiro.web.util.SavedRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: ClientSaveRequest
 * @author:zhouzhu
 * @Date: 2018/8/16 17:32
 * @Version: V1.0
 */
public class ClientSaveRequest extends SavedRequest{
    private String scheme;
    private String domain;
    private int port;
    private String contextPath;
    private String backUrl;
    public ClientSaveRequest(HttpServletRequest request,String backUrl) {
        super(request);
        this.scheme=request.getScheme();
        this.domain=request.getServerName();
        this.port=request.getServerPort();
        this.backUrl=backUrl;
        this.contextPath=request.getContextPath();
    }

    public String getScheme() {
        return scheme;
    }

    public String getDomain() {
        return domain;
    }

    public int getPort() {
        return port;
    }

    public String getContextPath() {
        return contextPath;
    }

    public String getBackUrl() {
        return backUrl;
    }

    @Override
    public String getRequestUrl() {
        String requestURI=getRequestURI();
        if (backUrl!=null){
            if (backUrl.toLowerCase().startsWith("http://") || backUrl.toLowerCase().startsWith("https://")){
                return backUrl;
            }else if (!backUrl.startsWith(contextPath)){
                requestURI=contextPath+backUrl;
            }else {
                requestURI=backUrl;
            }
        }
        StringBuffer requestUrl=new StringBuffer(scheme);
        requestUrl.append("://");
        requestUrl.append(domain);
        if("http".equalsIgnoreCase(scheme) && port!=80){
            requestUrl.append(":").append(String.valueOf(port));
        }else if ("https:".equalsIgnoreCase(scheme) && port!=443){
            requestUrl.append(":").append(String.valueOf(port));
        }
        requestUrl.append(requestURI);
        if(backUrl==null && getQueryString()!=null){
            requestUrl.append("?").append(getQueryString());
        }

        return requestUrl.toString();
    }
}
