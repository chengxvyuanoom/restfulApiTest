package com.edison.restful.api.controller;

import com.edison.restful.service.DemoService;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.eclipse.jetty.client.HttpRequest;
import org.eclipse.jetty.http.HttpFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CLassName ProductController
 * @Description TODO
 * @Author goodman
 * @Date 2019-04-30 10:59
 * @Version 1.0
 **/
@RestController
@RequestMapping("/restful/api")
@Api(value = "提供常用的RestFul接口", tags = "通用Restful测试接口")
public class RestfulController {

  @Autowired
  private DemoService demoService;

  @ApiOperation(value = "接受普通GET请求(无任何限制),返回值为String类型，返回值内容与传入一致")
  @RequestMapping(value = "/get", method = RequestMethod.GET)
  public String testForGet(@RequestParam String content) {
    return content;
  }

  @ApiOperation(value = "接受普通POST请求(无任何限制),返回值为String类型，返回值内容与传入一致")
  @RequestMapping(value = "/post", method = RequestMethod.POST)
  public String testForPost(@RequestBody String content) {
    return content;
  }

  @ApiOperation(value = "接受普通PUT请求(无任何限制),返回值为String类型，返回值内容与传入一致")
  @RequestMapping(value = "/put", method = RequestMethod.PUT)
  public String testForPut(@RequestBody String content) {
    return content;
  }

  @ApiOperation(value = "接受普通路径中的携带参数(2)(无任何限制),返回值为String类型，返回值内容是传入参数的List")
  @RequestMapping(value = "/path/{params1}/{params2}", method = RequestMethod.GET)
  public List<String> testForPath(@PathVariable(value = "params1") String params1,
      @PathVariable(value = "params2") String params2) {
    List<String> objects = Lists.newArrayList();
    objects.add(params1);
    objects.add(params2);
    return objects;
  }

  @ApiOperation(value = "接受普通路径中的携带fgf参数(1)(无任何限制),返回值为String类型，返回值内容是传入参数的List")
  @RequestMapping(value = "/path/{params1}}", method = RequestMethod.GET)
  public String testForPath1(@PathVariable(value = "params1") String params1) {
    return params1;
  }

  @ApiOperation(value = "接受普通Get请求，返回值为携带自定义Header内容,Header的Key，通过Url传过来，例如 XXXX?key=id")
  @RequestMapping(value = "/header/get", method = RequestMethod.GET)
  public String testForHeader(@RequestParam(value = "key") String key, HttpRequest request) {
    HttpFields headers = request.getHeaders();
    return headers.get(key);
  }


}
