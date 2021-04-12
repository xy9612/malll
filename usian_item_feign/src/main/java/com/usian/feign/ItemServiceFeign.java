package com.usian.feign;

import com.usian.pojo.TbItem;
import com.usian.pojo.TbItemCat;
import com.usian.utils.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/7 21:35
 */
@FeignClient(value = "usian-item-service")
public interface ItemServiceFeign {
    @RequestMapping("/service/item/selectItemInfo")
    TbItem selectItemInfo(@RequestParam("itemId") Long itemId);

    @GetMapping("/service/item/selectTbItemAllByPage")
    PageResult selectTbItemAllByPage(@RequestParam Integer page,
                                     @RequestParam Integer rows);

    @RequestMapping("/service/itemCategory/selectItemCategoryByParentId")
    List<TbItemCat> selectItemCategoryByParentId(@RequestParam Long id);

    @GetMapping("/service/item/insertTbItem")
    Integer insertTbItem(@RequestBody TbItem tbItem,
                         @RequestParam String desc,
                         @RequestParam String itemParams);

    @RequestMapping("/service/item/preUpdateItem")
    Map<String, Object> preUpdateItem(@RequestParam("itemId") Long itemId);

}
