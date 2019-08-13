package com.edison.restful.entity;

import java.util.Map;

/**
 * @CLassName ProductParameter
 * @Description 获取签名返回模型
 * @Author goodman
 * @Date 2019-04-30 11:20
 * @Version 1.0
 **/
public class ProductSignParameter {

  private Map<String, Object> status;

  private Map<String, String> data;

  public Map<String, Object> getStatus() {
    return status;
  }

  public void setStatus(Map<String, Object> status) {
    this.status = status;
  }

  public Map<String, String> getData() {
    return data;
  }

  public void setData(Map<String, String> data) {
    this.data = data;
  }
}
