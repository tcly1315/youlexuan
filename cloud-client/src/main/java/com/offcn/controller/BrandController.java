package com.offcn.controller;

import com.offcn.impl.BrandService;
import com.offcn.pojo.TbBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/brand/{id}")
    public Map showOne(@PathVariable Long id) {
        TbBrand one = brandService.findOne(id);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("brand", one);
        map.put("服务名", "client1");
        return map;
    }
}
