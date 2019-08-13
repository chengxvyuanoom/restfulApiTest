package com.edison.restful.service.impl;

import com.edison.restful.api.ao.ProductPararmeterAO;
import com.edison.restful.api.ao.ProductSignParameterAO;
import com.edison.restful.entity.ProductParameter;
import com.edison.restful.entity.ProductSignParameter;
import com.edison.restful.service.ProductService;
import com.edison.restful.util.SignUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @CLassName ProductServiceImpl
 * @Description TODO
 * @Author goodman
 * @Date 2019-04-30 11:14
 * @Version 1.0
 **/
@Service
public class ProductServiceImpl implements ProductService {

  private final Logger log = LoggerFactory.getLogger(getClass());

  /**
   * [ { "name": "api_key", "value": "test1" }, { "name": "passphrase", "value": "test1_passphrase"
   * }, { "name": "passphrase_desc", "value": "test1_passphrase_desc" } ], [ { "name": "api_key",
   * "value": "test2" }, { "name": "passphrase", "value": "test2_passphrase" }, { "name":
   * "passphrase_desc", "value": "test2_passphrase_desc" } ]
   **/
  @Override
  public ProductParameter getParametersForDependOn(ProductPararmeterAO productPararmeterAO,
      List<String> params) {
    log.info("==getParameters");
    List<String> list = Lists.newArrayListWithCapacity(params.size());
    //排除第一个非DependOn的
    for (int i = 1; i < params.size(); i++) {
      list.add("我是DependOn类型的数据" + i);
    }
    String[] dependOnData = {"测试DependOn成功数据第一条", "测试DependOn成功数据第二条", "测试DependOn成功数据第三条",
        "测试DependOn成功数据第四条"};
    List<List<Map<String, Object>>> data = Lists.newArrayList();

    for (String content : dependOnData) {
      List<Map<String, Object>> listGroup = Lists.newArrayList();
      for (int i = 0; i < params.size(); i++) {
        Map<String, Object> eachParameters = Maps.newHashMap();
        eachParameters.put("name", params.get(i));
        if (i > 0) {
          eachParameters.put("value", list.get(i - 1));
        } else {
          eachParameters.put("value", content);
        }
        listGroup.add(eachParameters);
      }
      data.add(listGroup);
    }
    return wrapServicePojo(true, data);
  }

  @Override
  public ProductParameter getParametersForRaw(ProductPararmeterAO productPararmeterAO)
      throws Exception {
    if (productPararmeterAO == null) {
      throw new Exception("请求参数为空，请查看");
    }
    String[] rawContents = {"测试Raw成功数据第一条", "测试Raw成功数据第二条", "测试Raw成功数据第三条",
        "测试Raw成功数据第四条"};
    return wrapServicePojo(true, generateParam(productPararmeterAO, rawContents));
  }

  @Override
  public ProductParameter getParametersForCity(ProductPararmeterAO productPararmeterAO)
      throws Exception {
    if (productPararmeterAO == null) {
      throw new Exception("请求参数为空，请查看");
    }
    String[] cityArray = {"110000", "130000", "140000", "150100"};
    return wrapServicePojo(true, generateParam(productPararmeterAO, cityArray));
  }

  @Override
  public ProductParameter getParametersDefault(ProductPararmeterAO productPararmeterAO)
      throws Exception {
    String[] s = {""};
    return wrapServicePojo(false, generateParam(productPararmeterAO, s));
  }

  @Override
  public ProductSignParameter getSign(ProductSignParameterAO productSignParameterAO)
      throws Exception {
    log.info("==getSign");
    ProductSignParameter productSignParameter = new ProductSignParameter();
    String paramsStr = productSignParameterAO.getParams();
    String[] params = paramsStr.split("&");
    HashMap<String, String> hm = Maps.newHashMap();
    for (String eachParam : params) {
      String[] eachParams = eachParam.split("=");
      hm.put(eachParams[0], eachParams[1]);
    }
    //获取签名
    String signValue = SignUtils.getSign("B62265BBA2095A75B8993536CDA33A31", hm, "MD5");
    String signValueCorrect = "ABF65673E24845CAE6C8C7D03083D683";
    Map<String, Object> status = Maps.newHashMap();
    status.put("isSuccess", true);
    status.put("message", "success");
    productSignParameter.setStatus(status);
    Map<String, String> data = Maps.newHashMap();
    data.put("signValue", signValueCorrect);
    productSignParameter.setData(data);
    return productSignParameter;
  }

  private List<List<Map<String, Object>>> generateParam(ProductPararmeterAO productPararmeterAO,
      String[] paramArray) {
    List<List<Map<String, Object>>> data = Lists.newArrayList();
    for (String rawContent : paramArray) {
      List<Map<String, Object>> listGroup = Lists.newArrayList();
      Map<String, Object> eachParameters = Maps.newHashMap();
      eachParameters.put("name", productPararmeterAO.getParameterNames());
      eachParameters.put("value", rawContent);
      listGroup.add(eachParameters);
      data.add(listGroup);
    }
    return data;
  }

  private ProductParameter wrapServicePojo(Boolean flag, Object data) {
    ProductParameter productParameter = new ProductParameter();
    Map<String, Object> status = Maps.newHashMap();
    status.put("isSuccess", flag);
    status.put("message", "productPararmeterAO");
    productParameter.setStatus(status);
    productParameter.setData(data);
    return productParameter;
  }
}
