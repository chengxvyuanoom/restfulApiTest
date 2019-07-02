package com.edison.restful.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CLassName RawTestController
 * @Description TODO
 * @Author goodman
 * @Date 2019-06-12 14:24
 * @Version 1.0
 **/
@RestController
@RequestMapping("/restful/api/raw")
@Api(value = "测试Raw类型的Controller", tags = "测试Raw类型的Controller")
public class RawTestController {

  @ApiOperation(value = "测试'application/json'类型")
  @RequestMapping(value = "/application/json", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public String getRawTest(@RequestBody String json) {
    return json;
  }

  @ApiOperation(value = "测试'text/plain'类型")
  @RequestMapping(value = "/text/plain", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
  public String getRawTextTest(@RequestBody String json) {
    return json;
  }

  @ApiOperation(value = "测试'text/xml'类型")
  @RequestMapping(value = "/text/xml", method = RequestMethod.POST, consumes = MediaType.TEXT_XML_VALUE)
  public String getRawTestXmlTest(@RequestBody String json) {
    return json;
  }

  @ApiOperation(value = "测试'text/html'类型")
  @RequestMapping(value = "/text/html", method = RequestMethod.POST, consumes = MediaType.TEXT_HTML_VALUE)
  public String getRawHtmlTest(@RequestBody String json) {
    return json;
  }

  @ApiOperation(value = "测试'application/xml'类型")
  @RequestMapping(value = "/application/xml", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
  public String getApplicationXmlTest(@RequestBody String json) {
    return json;
  }

}
