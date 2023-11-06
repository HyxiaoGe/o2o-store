package com.hyxiao.o2ostore.service;

import com.hyxiao.o2ostore.common.BusinessException;
import com.hyxiao.o2ostore.model.CategoryModel;

import java.util.List;

public interface CategoryService {

    CategoryModel create(CategoryModel categoryModel) throws BusinessException;
    CategoryModel get(Integer id);
    List<CategoryModel> selectAll();

    Integer countAllCategory();
}
