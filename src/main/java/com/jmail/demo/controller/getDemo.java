package com.jmail.demo.controller;

import com.jmail.demo.common.*;
import com.jmail.demo.dao.model.KePRole;
import com.jmail.demo.manager.SettleManager;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangxs7   on 2017/6/22.
 */
@Controller
public class getDemo {
    private static Logger logger = LoggerFactory.getLogger(getDemo.class);

    @Autowired
    private SettleManager settleManager;

    @RequestMapping("/hi")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/page")
    public String page() {
        return "demo/page";
    }
    @RequestMapping("/addpage")
    public String addpage() {
        return "demo/add";
    }


    @RequestMapping(value = "/get1")
    @ResponseBody
    public String get1() {
        KePRole flow = settleManager.get1(1);
        return flow.toString();
    }

    @RequestMapping(value = "/pagedata")
    @ResponseBody
    public JqGrid queryAdBannerPage(JqGrid<KePRole> grid, String terminal,
                                          String shopid, String position, String type, String status) {
        JqGrid dateGrid = new JqGrid<>();

        Map map = new HashMap();
        this.strToMap(map, "shopid", shopid);
        this.strToMap(map, "position", position);
        this.strToMap(map, "type", type);
        this.strToMap(map, "terminal", terminal);
        this.strToMap(map, "status", status);

        try {
            RemoteResult<PageModel<KePRole>> result = settleManager.queryPage(grid.getPageQuery(), map);
            if (result.isSuccess()) {
                dateGrid.setPageModel(result.getData());
            }
        } catch (Exception e) {
            logger.error("queryAdBannerPage errror:{} ", e.getMessage(), e);
        }

        return dateGrid;
    }

    public Map strToMap(Map map, String key, Object value) {
        if (map == null) {
            map = new HashMap();
        }
        if (value instanceof String) {
            if (StringUtils.isNotBlank(String.valueOf(value)))
                map.put(key, String.valueOf(value).trim());
        } else {
            if (value != null) {
                map.put(key, value);
            }
        }
        return map;
    }
}
