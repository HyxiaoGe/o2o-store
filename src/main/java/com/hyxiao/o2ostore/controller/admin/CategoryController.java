package com.hyxiao.o2ostore.controller.admin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hyxiao.o2ostore.common.AdminPermission;
import com.hyxiao.o2ostore.common.BusinessException;
import com.hyxiao.o2ostore.common.CommonUtil;
import com.hyxiao.o2ostore.common.EmBusinessError;
import com.hyxiao.o2ostore.model.CategoryModel;
import com.hyxiao.o2ostore.request.CategoryCreateReq;
import com.hyxiao.o2ostore.request.PageQuery;
import com.hyxiao.o2ostore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller("/admin/category")
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //品类列表
    @RequestMapping("/index")
    @AdminPermission
    public ModelAndView index(PageQuery pageQuery){
        PageHelper.startPage(pageQuery.getPage(),pageQuery.getSize());
        List<CategoryModel> categoryModelList = categoryService.selectAll();
        PageInfo<CategoryModel> categoryModelPageInfo = new PageInfo<>(categoryModelList);
        ModelAndView modelAndView = new ModelAndView("/admin/category/index.html");
        modelAndView.addObject("data",categoryModelPageInfo);
        modelAndView.addObject("CONTROLLER_NAME","category");
        modelAndView.addObject("ACTION_NAME","index");
        return modelAndView;
    }

    @RequestMapping("/createpage")
    @AdminPermission
    public ModelAndView createPage(){
        ModelAndView modelAndView = new ModelAndView("/admin/category/create.html");
        modelAndView.addObject("CONTROLLER_NAME","category");
        modelAndView.addObject("ACTION_NAME","create");
        return modelAndView;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @AdminPermission
    public String create(@Valid CategoryCreateReq categoryCreateReq, BindingResult bindingResult) throws BusinessException {
        if(bindingResult.hasErrors()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processErrorString(bindingResult));
        }

        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setName(categoryCreateReq.getName());
        categoryModel.setIconUrl(categoryCreateReq.getIconUrl());
        categoryModel.setSort(categoryCreateReq.getSort());

        categoryService.create(categoryModel);

        return "redirect:/admin/category/index";


    }

}
