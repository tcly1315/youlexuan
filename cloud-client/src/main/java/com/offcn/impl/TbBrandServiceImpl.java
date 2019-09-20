package com.offcn.impl;

import com.offcn.dao.TbBrandMapper;
import com.offcn.pojo.TbBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TbBrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(null);
    }

    @Override
    @Transactional
    @CachePut(value = "redisCache", key = "'redis_user'+#result.id")
    public TbBrand add(TbBrand brand) {
        tbBrandMapper.insertSelective(brand);
        return brand;
    }

    @Override
    public void update(TbBrand brand) {
        tbBrandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    @Cacheable(value = "redisCache", key = "'redis_user'+#id")
    //@CachEvict (beforeinvocation = false) 移除缓存
    public TbBrand findOne(Long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(Long[] ids) {
    }
}
