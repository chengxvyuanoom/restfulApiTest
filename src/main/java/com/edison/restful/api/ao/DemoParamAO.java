package com.edison.restful.api.ao;

/**
 * @CLassName DemoParamAO
 * @Description TODO
 * @Author goodman
 * @Date 2019-04-30 11:23
 * @Version 1.0
 **/
public class DemoParamAO {

    private String url;
    private String parameterNames;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParameterNames() {
        return parameterNames;
    }

    public void setParameterNames(String parameterNames) {
        this.parameterNames = parameterNames;
    }

    public DemoParamAO() {
    }

    public DemoParamAO(String url, String parameterNames) {
        this.url = url;
        this.parameterNames = parameterNames;
    }
}
