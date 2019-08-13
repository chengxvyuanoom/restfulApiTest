package com.edison.restful.api.ao;

public class ProductSignParameterAO {

  private String url;
  private String method;
  private String params;
  private String headers;
  private String body;

  public ProductSignParameterAO(String url, String method, String params, String headers,
      String body) {
    this.url = url;
    this.method = method;
    this.params = params;
    this.headers = headers;
    this.body = body;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getParams() {
    return params;
  }

  public void setParams(String params) {
    this.params = params;
  }

  public String getHeaders() {
    return headers;
  }

  public void setHeaders(String headers) {
    this.headers = headers;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }
}
