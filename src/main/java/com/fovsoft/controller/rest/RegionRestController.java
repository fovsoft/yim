package com.fovsoft.controller.rest;

import com.fovsoft.entity.YmRegion;
import com.fovsoft.service.RegionSerivce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegionRestController {

    @Autowired
    RegionSerivce regionSerivce;

    private static final Logger logger = LoggerFactory.getLogger(RegionRestController.class);

    @RequestMapping(value = "/getRegion")
    public List getRegion(@RequestParam(name = "id", required = false)Integer id) {
        List<YmRegion> list = regionSerivce.getList(id);
        return list;
    }

}
