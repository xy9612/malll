package com.usian.controller;

import com.usian.feign.ItemServiceFeign;
import com.usian.pojo.TbItemParam;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/13 11:17
 */
@RestController
@RequestMapping("/backend/itemParam")
public class ItemParamController {
    @Autowired
    private ItemServiceFeign itemServiceFeign;

    /**
     * 根据商品分类 ID 查询规格参数模板
     */
    @RequestMapping("/selectItemParamByItemCatId/{itemCatId}")
    public Result selectItemParamByItemCatId(@PathVariable("itemCatId") Long itemCatId) {
        TbItemParam tbItemParam =
                this.itemServiceFeign.selectItemParamByItemCatId(itemCatId);
        if (tbItemParam != null) {
            return Result.ok(tbItemParam);
        }
        return Result.error("查无结果");
    }
}
