package com.offcn.impl;

import com.offcn.pojo.TbBrand;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 服务层接口
 *
 * @author Administrator
 */

public interface BrandService {

    /**
     * 返回全部列表
     *
     * @return
     */
    public List<TbBrand> findAll();

    /**
     * 增加
     */
    public TbBrand add(TbBrand brand);


    /**
     * 修改
     */
    public void update(TbBrand brand);


    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @GetMapping("/brand/{id}")
    public TbBrand findOne(Long id);


    /**
     * 批量删除
     *
     * @param ids
     */
    public void delete(Long[] ids);


}
