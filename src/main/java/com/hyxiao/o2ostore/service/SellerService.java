package com.hyxiao.o2ostore.service;


import com.hyxiao.o2ostore.common.BusinessException;
import com.hyxiao.o2ostore.model.SellerModel;

import java.util.List;

public interface SellerService {

    SellerModel create(SellerModel sellerModel);
    SellerModel get(Integer id);
    List<SellerModel> selectAll();
    SellerModel changeStatus(Integer id,Integer disabledFlag) throws BusinessException;

}
