package com.fovsoft.service;

import com.fovsoft.controller.rest.IncomeRestController;
import com.fovsoft.dao.*;
import com.fovsoft.entity.*;
import com.fovsoft.security.bean.SysUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;

@Service
public class IncomeSerivce {

    private static final Logger logger = LoggerFactory.getLogger(IncomeSerivce.class);

    @Resource
    private YmIncomeDao ymIncomeIncomeDao;

    /**
     * @return
     */
    public int addIncome1(Map map) {
        int exitIncome1 = ymIncomeIncomeDao.getIncome1Count(map);
        String fid = map.get("fid").toString();

        int affectRow;
        if (exitIncome1 >= 1) {
            ymIncomeIncomeDao.delIncome1(Integer.parseInt(fid));  // 删除旧数据
        }

        Map<String, Map> dataMap = new HashMap(); // 批量插入的数据
        map.remove("fid");

        // 拆分表1、表2
        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            String key = entry.getKey();

            String[] keyItemArr = key.split("_");
            logger.info(key);
            String unitKey = key.substring(3); // 形如 ： 1_1_2018_10
            if (!dataMap.containsKey(unitKey)) {

                Map tmp = new HashMap();
                tmp.put("fid", fid);

                tmp.put("type1", keyItemArr[1]);
                tmp.put("type2", keyItemArr[2]);
                tmp.put("nf", keyItemArr[3]);
                tmp.put("yf", keyItemArr[4]);

                if (!keyItemArr[0].equals("qt")) {
                    tmp.put(keyItemArr[0], entry.getValue() == null ? "" : entry.getValue());
                } else {                          // “其他” 只存金额
                    tmp.put("je", entry.getValue() == null ? "" : entry.getValue());
                    tmp.put("sl", "");
                    tmp.put("pz", "");
                }
                dataMap.put(unitKey, tmp);
            } else {
                Map tmp = dataMap.get(unitKey);
                tmp.put(keyItemArr[0], entry.getValue());
                dataMap.put(unitKey, tmp);
            }
        }

        affectRow = ymIncomeIncomeDao.addIncome1(dataMap);
        return affectRow;
    }

    public int addIncome3(Map map) {
        int exitIncome3 = ymIncomeIncomeDao.getIncome3Count(map);
        String fid = map.get("fid").toString();

        int affectRow;
        if (exitIncome3 >= 1) {
            ymIncomeIncomeDao.delIncome3(Integer.parseInt(fid));  // 删除旧数据
        }

        Map<String, Map> dataMap = new HashMap(); // 批量插入的数据
        map.remove("fid");

        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            String key = entry.getKey();

            String[] keyItemArr = key.split("_");

            // 如果类别为1 ，则用 类别_人员 作为Key
            // 否则 用 类别_ 作为key
            String unitKey;
            if (keyItemArr[0].equals("1")) {
                unitKey = key.substring(0, 3);
            } else {
                unitKey = key.substring(0, 2);
            }

            Map tmp;
            if (!dataMap.containsKey(unitKey)) {
                tmp = new HashMap();
                tmp.put("fid", fid);
                tmp.put("type1", keyItemArr[0]);
            } else {
                tmp = dataMap.get(unitKey);
            }

            // 从这里开始分三类
            // 第一类是 人员务工信息，keyItemArr[0] == 1 && keyItemArr[2] == 0
            // 第二类是 人员年月收入，keyItemArr[0] == 1 && keyItemArr[2] != 0
            // 第三类是 其他年月收入, keyItemArr[0] != 1
            if (keyItemArr[0].equals("1")) {
                tmp.put("type2", keyItemArr[1]); // 人员1-4
                if (keyItemArr[2].equals("0")) { // 第一类
                    tmp.put(keyItemArr[3], entry.getValue() == null ? "" : entry.getValue());
                } else {  // 第二类
                    tmp.put("ny" + keyItemArr[2], entry.getValue() == null ? "" : entry.getValue());
                }
            } else {  // 第三类
                tmp.put("ny" + keyItemArr[1], entry.getValue() == null ? "" : entry.getValue());
            }
            dataMap.put(unitKey, tmp);
        }
        affectRow = ymIncomeIncomeDao.addIncome3(dataMap);
        return affectRow;
    }

    public int addIncome5(Map map) {
        int exitIncome5 = ymIncomeIncomeDao.getIncome5Count(map);

        String fid = map.get("fid").toString();

        if (exitIncome5 >= 1) {
            ymIncomeIncomeDao.delIncome5(Integer.parseInt(fid));  // 删除旧数据
        }
        Map<String, Map> dataMap = new HashMap(); // 批量插入的数据
        map.remove("fid");

        int affectRow;


        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            String key = entry.getKey();

            String[] keyItemArr = key.split("_");

            // 用 5_xxx 作为key
            String unitKey = keyItemArr[0] + "_" + keyItemArr[1];

            Map tmp;
            if (!dataMap.containsKey(unitKey)) {
                tmp = new HashMap();
                tmp.put("fid", fid);
                tmp.put("type", keyItemArr[1]);
            } else {
                tmp = dataMap.get(unitKey);
            }
            tmp.put("ny" + keyItemArr[2], entry.getValue());
            dataMap.put(unitKey, tmp);
        }

        affectRow = ymIncomeIncomeDao.addIncome5(dataMap);
        return affectRow;
    }

    public int addIncome9(Map map) {

        int exitIncome9 = ymIncomeIncomeDao.getIncome9Count(map);

        String fid = map.get("fid").toString();

        if (exitIncome9 >= 1) {
            ymIncomeIncomeDao.delIncome9(Integer.parseInt(fid));  // 删除旧数据
        }

        Map<String, Map> dataMap = new HashMap(); // 批量插入的数据
        map.remove("fid");
        int affectRow;

        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            String key = entry.getKey();

            String[] keyItemArr = key.split("_");

            // 用 6_x 作为key
            String unitKey = keyItemArr[0] + "_" + keyItemArr[1];
            Map tmp;
            if (!dataMap.containsKey(unitKey)) {
                tmp = new HashMap();
                tmp.put("fid", fid);
                tmp.put("type", keyItemArr[1]);
            } else {
                tmp = dataMap.get(unitKey);
            }

            tmp.put("ny" + keyItemArr[2], entry.getValue());
            dataMap.put(unitKey, tmp);
        }

        affectRow = ymIncomeIncomeDao.addIncome9(dataMap);
        return affectRow;
    }

    public List<YmIncome1> getIncome1(int fid) {
        return ymIncomeIncomeDao.listIncome1(fid);
    }


    public List<YmIncome3> getIncome3(int fid) {
        return ymIncomeIncomeDao.listIncome3(fid);
    }

    public List<YmIncome5> getIncome5(int fid) {
        return ymIncomeIncomeDao.listIncome5(fid);
    }

    public List<YmIncome5> getIncome9(int fid) {
        return ymIncomeIncomeDao.listIncome9(fid);
    }


    // 家庭稳定总收入
    public Map getJTWDZSR(int fid) {
        Map<String,Float> result = ymIncomeIncomeDao.getJTWDZSR(fid);
        return result;
    }
}
