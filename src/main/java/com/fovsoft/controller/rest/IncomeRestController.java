package com.fovsoft.controller.rest;

import com.fovsoft.common.JsonResult;
import com.fovsoft.entity.YmIncome1;
import com.fovsoft.entity.YmIncome3;
import com.fovsoft.entity.YmIncome5;
import com.fovsoft.entity.YmRegion;
import com.fovsoft.security.bean.SysUser;
import com.fovsoft.service.IncomeSerivce;
import com.fovsoft.service.RegionSerivce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/income")
public class IncomeRestController {

    @Autowired
    IncomeSerivce incomeSerivce;

    private static final Logger logger = LoggerFactory.getLogger(IncomeRestController.class);

    @RequestMapping(value = "/addIncome1", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonResult addIncome1(@RequestBody Map<String,String> map) {
        int id = incomeSerivce.addIncome1(map);
        return new JsonResult(Integer.valueOf(id));
    }

    @RequestMapping(value = "/addIncome3", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonResult addIncome3(@RequestBody Map<String,String> map) {
        int id = incomeSerivce.addIncome3(map);
        return new JsonResult(Integer.valueOf(id));
    }

    @RequestMapping(value = "/addIncome5", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonResult addIncome5(@RequestBody Map<String,String> map) {
        int id = incomeSerivce.addIncome5(map);
        return new JsonResult(Integer.valueOf(id));
    }

    @RequestMapping(value = "/addIncome9", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonResult addIncome9(@RequestBody Map<String,String> map) {
        int id = incomeSerivce.addIncome9(map);
        return new JsonResult(Integer.valueOf(id));
    }


    @RequestMapping(value="/getIncome1")
    public JsonResult getIncome1(Integer fid) {
        Map data = new HashMap();

        List<YmIncome1> income1List = incomeSerivce.getIncome1(fid);
        for (YmIncome1 item :
                income1List) {

            // 逐个拼接成键值对，返回到前端
            if(item.getType2() != 4) {
                data.put("pz" + "_" + item.getType1() + "_" + item.getType2() + "_" + item.getNf() + "_" + item.getYf(), item.getPz());
                data.put("sl" + "_" + item.getType1() + "_" + item.getType2() + "_" + item.getNf() + "_" + item.getYf(), item.getSl());
                data.put("je" + "_" + item.getType1() + "_" + item.getType2() + "_" + item.getNf() + "_" + item.getYf(), item.getJe());
            }
            else {
                data.put("qt" + "_" + item.getType1() + "_" + item.getType2() + "_" + item.getNf() + "_" + item.getYf(), item.getJe());
            }

        }
        return new JsonResult(data);
    }


    @RequestMapping(value = "/getIncome3")
    public JsonResult getIncome3(Integer fid) {
        Map data = new HashMap();
        List<YmIncome3> income3List = incomeSerivce.getIncome3(fid);
        for (YmIncome3 item:
             income3List) {
            if(item.getType1() == 1) {
                data.put(item.getType1() + "_" + item.getType2() + "_0_xm", item.getXm());
                data.put(item.getType1() + "_" + item.getType2() + "_0_wggz", item.getWggz());
                data.put(item.getType1() + "_" + item.getType2() + "_0_wgdz", item.getWgdz());
                data.put(item.getType1() + "_" + item.getType2() + "_0_wgqymc", item.getWgqymc());
                data.put(item.getType1() + "_" + item.getType2() + "_0_wgljsj", item.getWgljsj());

                data.put(item.getType1() + "_" + item.getType2() + "_201810", item.getNy201810());
                data.put(item.getType1() + "_" + item.getType2() + "_201811", item.getNy201811());
                data.put(item.getType1() + "_" + item.getType2() + "_201812", item.getNy201812());
                data.put(item.getType1() + "_" + item.getType2() + "_201913", item.getNy201913());
                data.put(item.getType1() + "_" + item.getType2() + "_201946", item.getNy201946());
                data.put(item.getType1() + "_" + item.getType2() + "_201979", item.getNy201979());
                data.put(item.getType1() + "_" + item.getType2() + "_201910", item.getNy201910());
                data.put(item.getType1() + "_" + item.getType2() + "_201911", item.getNy201911());
                data.put(item.getType1() + "_" + item.getType2() + "_201912", item.getNy201912());
            }
            else {
                data.put(item.getType1() + "_201810", item.getNy201810());
                data.put(item.getType1() + "_201811", item.getNy201811());
                data.put(item.getType1() + "_201812", item.getNy201812());
                data.put(item.getType1() + "_201913", item.getNy201913());
                data.put(item.getType1() + "_201946", item.getNy201946());
                data.put(item.getType1() + "_201979", item.getNy201979());
                data.put(item.getType1() + "_201910", item.getNy201910());
                data.put(item.getType1() + "_201911", item.getNy201911());
                data.put(item.getType1() + "_201912", item.getNy201912());
            }
        }
        return new JsonResult(data);
    }

    @RequestMapping(value = "/getIncome5")
    public JsonResult getIncome5(Integer fid) {
        Map data = new HashMap();
        List<YmIncome5> income5List = incomeSerivce.getIncome5(fid);
        for (YmIncome5 item:
                income5List) {
                data.put("5_" + item.getType1() + "_201810", item.getNy201810());
                data.put("5_" + item.getType1() + "_201811", item.getNy201811());
                data.put("5_" + item.getType1() + "_201812", item.getNy201812());
                data.put("5_" + item.getType1() + "_201913", item.getNy201913());
                data.put("5_" + item.getType1() + "_201946", item.getNy201946());
                data.put("5_" + item.getType1() + "_201979", item.getNy201979());
                data.put("5_" + item.getType1() + "_201910", item.getNy201910());
                data.put("5_" + item.getType1() + "_201911", item.getNy201911());
                data.put("5_" + item.getType1() + "_201912", item.getNy201912());
        }
        return new JsonResult(data);
    }

    @RequestMapping(value = "/getIncome9")
    public JsonResult getIncome9(Integer fid) {
        Map data = new HashMap();
        List<YmIncome5> income9List = incomeSerivce.getIncome9(fid);
        for (YmIncome5 item:
                income9List) {
            data.put("6_" + item.getType1() + "_201810", item.getNy201810());
            data.put("6_" + item.getType1() + "_201811", item.getNy201811());
            data.put("6_" + item.getType1() + "_201812", item.getNy201812());
            data.put("6_" + item.getType1() + "_201913", item.getNy201913());
            data.put("6_" + item.getType1() + "_201946", item.getNy201946());
            data.put("6_" + item.getType1() + "_201979", item.getNy201979());
            data.put("6_" + item.getType1() + "_201910", item.getNy201910());
            data.put("6_" + item.getType1() + "_201911", item.getNy201911());
            data.put("6_" + item.getType1() + "_201912", item.getNy201912());
        }
        return new JsonResult(data);
    }
}
