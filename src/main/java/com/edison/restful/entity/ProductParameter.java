package com.edison.restful.entity;

import java.util.Map;

/**
 * @CLassName ProductParameter
 * @Description Webservice获取参数返回模型
 * @Author goodman
 * @Date 2019-04-30 11:20
 * @Version 1.0
 **/
public class ProductParameter {

  private Map<String, Object> status;

  private Object data;

  public Map<String, Object> getStatus() {
    return status;
  }

  public void setStatus(Map<String, Object> status) {
    this.status = status;
  }

  public Object getData() {
    return data;
  }

  public void setData(
      Object data) {
    this.data = data;
  }
}
