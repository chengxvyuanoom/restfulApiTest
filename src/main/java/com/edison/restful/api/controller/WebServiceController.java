package com.edison.restful.api.controller;

import com.edison.restful.api.ao.ProductPararmeterAO;
import com.edison.restful.api.ao.ProductSignParameterAO;
import com.edison.restful.entity.ContentType;
import com.edison.restful.entity.ProductParameter;
import com.edison.restful.entity.ProductSignParameter;
import com.edison.restful.service.ProductService;
import com.google.common.base.Splitter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CLassName WebServiceController
 * @Description WebServiceController
 * @Author goodman
 * @Date 2019-08-12 10:33
 * @Version 1.0
 **/
@RestController
@RequestMapping("/restful/api/webservice/test")
@Api(value = "提供测试WebService的接口", tags = "WebService测试接口")
public class WebServiceController {

  private static final String CITY = "city";

  @Autowired
  private ProductService productService;

  @ApiOperation(value = "获取参数")
  @RequestMapping(value = "/getParameters", method = RequestMethod.POST)
  public ProductParameter getParameters(@RequestParam String url, @RequestParam String method,
      @RequestParam String parameterNames,
      @RequestParam(required = false, defaultValue = "x-www-form-urlencoded") String bodyType)
      throws Exception {
    ProductPararmeterAO productPararmeterAO = new ProductPararmeterAO(url, method, parameterNames,
        bodyType);
    Splitter splitter = Splitter.on(",").trimResults().omitEmptyStrings();
    List<String> strings = splitter.splitToList(parameterNames);
    if (strings.size() > 1) {
      return productService.getParametersForDependOn(productPararmeterAO,strings);
    }
    if (ContentType.RAW.getAlias().equals(bodyType)) {
      return productService.getParametersForRaw(productPararmeterAO);
    }
    if (CITY.equals(parameterNames)) {
      return productService.getParametersForCity(productPararmeterAO);
    }
    return productService.getParametersForCity(productPararmeterAO);
  }

  @ApiOperation(value = "获取签名")
  @RequestMapping(value = "/getSign", method = RequestMethod.POST)
  public ProductSignParameter getSign(@RequestParam String url, @RequestParam String method,
      @RequestParam String params, @RequestParam String headers, @RequestParam String body)
      throws Exception {
    ProductSignParameterAO productSignParameterAO = new ProductSignParameterAO(url, method, params,
        headers, body);
    return productService.getSign(productSignParameterAO);
  }

}
