package com.edison.restful.service;

import com.edison.restful.api.ao.DemoParamAO;
import com.edison.restful.entity.DemoParameter;

public interface DemoService {

    DemoParameter getParameters(DemoParamAO demoParamAO);
}
