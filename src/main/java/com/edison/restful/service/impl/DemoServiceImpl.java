package com.edison.restful.service.impl;

import com.google.common.collect.Maps;
import com.edison.restful.api.ao.DemoParamAO;
import com.edison.restful.entity.DemoParameter;
import com.edison.restful.service.DemoService;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * @CLassName DemoServiceImpl
 * @Description TODO
 * @Author goodman
 * @Date 2019-04-30 11:14
 * @Version 1.0
 **/
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public DemoParameter getParameters(DemoParamAO demoParamAO) {
        DemoParameter demoParameter = new DemoParameter();
        Map<String, Object> objectObjectHashMap = Maps.newHashMap();
        objectObjectHashMap.put("name", "value1");
        objectObjectHashMap.put("name1", true);
        demoParameter.setStatus(objectObjectHashMap);
        return demoParameter;
    }
}
