package com.edison.restful.service;

import com.edison.restful.api.ao.ProductPararmeterAO;
import com.edison.restful.api.ao.ProductSignParameterAO;
import com.edison.restful.entity.ProductParameter;
import com.edison.restful.entity.ProductSignParameter;
import java.util.List;

public interface ProductService {

  ProductParameter getParametersForDependOn(ProductPararmeterAO productPararmeterAO,
      List<String> parmas);

  ProductParameter getParametersForRaw(ProductPararmeterAO productPararmeterAO) throws Exception;

  ProductParameter getParametersForCity(ProductPararmeterAO productPararmeterAO) throws Exception;

  ProductParameter getParametersDefault(ProductPararmeterAO productPararmeterAO) throws Exception;

  ProductSignParameter getSign(ProductSignParameterAO productSignParameterAO) throws Exception;


}
