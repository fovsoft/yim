package com.fovsoft.dao;

import com.fovsoft.entity.YmFamily;
import com.fovsoft.entity.YmIncome1;
import com.fovsoft.entity.YmIncome3;
import com.fovsoft.entity.YmIncome5;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author: by tpc
 * @date: 2019/10/18 9:20
 * @description:
 **/
@Mapper
public interface YmIncomeDao {

    /*
     *
     * 新增
     *
     */
    @Insert({
            "<script>",
            "insert into ym_income1(fid, type1, type2, nf , yf, pz, sl, je) values ",
            "<foreach collection='param' item='item' index='index' separator=','>",
            "(#{item.fid}, #{item.type1}, #{item.type2}, #{item.nf}, #{item.yf}, #{item.pz}, #{item.sl}, #{item.je})",
            "</foreach>",
            "</script>"
    })
    int addIncome1(@Param(value = "param") Map param);

    @Insert({
            "<script>",
            "insert into ym_income3(fid, type1,type2, xm, wggz , wgdz , wgqymc, wgljsj, ny201810, ny201811, ny201812,ny201913, ny201946,ny201979,ny201910,ny201911,ny201912) values ",
            "<foreach collection='param' item='item' index='index' separator=','>",
            "(#{item.fid}, #{item.type1}, #{item.type2}, #{item.xm}, #{item.wggz}, #{item.wgdz}, #{item.wgqymc}, #{item.wgljsj}, #{item.ny201810}, #{item.ny201811}, #{item.ny201812}, #{item.ny201913}, #{item.ny201946}, #{item.ny201979}" +
                    ", #{item.ny201910}, #{item.ny201911}, #{item.ny201912})",
            "</foreach>",
            "</script>"
    })
    int addIncome3(@Param(value = "param") Map param);

    @Insert({
            "<script>",
            "insert into ym_income5(fid, type, ny201810, ny201811, ny201812,ny201913, ny201946,ny201979,ny201910,ny201911,ny201912) values ",
            "<foreach collection='param' item='item' index='index' separator=','>",
            "(#{item.fid}, #{item.type}, #{item.ny201810}, #{item.ny201811}, #{item.ny201812}, #{item.ny201913}, #{item.ny201946}, #{item.ny201979}, #{item.ny201910}, #{item.ny201911}, #{item.ny201912})",
            "</foreach>",
            "</script>"
    })
    int addIncome5(@Param(value = "param") Map param);

    @Insert({
            "<script>",
            "insert into ym_income9(fid, type, ny201810, ny201811, ny201812,ny201913, ny201946,ny201979,ny201910,ny201911,ny201912) values ",
            "<foreach collection='param' item='item' index='index' separator=','>",
            "(#{item.fid}, #{item.type}, #{item.ny201810}, #{item.ny201811}, #{item.ny201812}, #{item.ny201913}, #{item.ny201946}, #{item.ny201979}" +
                    ", #{item.ny201910}, #{item.ny201911}, #{item.ny201912})",
            "</foreach>",
            "</script>"
    })
    int addIncome9(@Param(value = "param") Map param);

    /*
     *
     * 删除
     *
     */
    @Delete("DELETE FROM ym_income1 WHERE fid = #{fid}")
    int delIncome1(@Param(value = "fid") int fid);

    @Delete("DELETE FROM ym_income3 WHERE fid = #{fid}")
    int delIncome3(@Param(value = "fid") int fid);

    @Delete("DELETE FROM ym_income5 WHERE fid = #{fid}")
    int delIncome5(@Param(value = "fid") int fid);

    @Delete("DELETE FROM ym_income9 WHERE fid = #{fid}")
    int delIncome9(@Param(value = "fid") int fid);
    /*
     *
     * 查有
     *
     */
    // map方式传参
    @Select("SELECT COUNT(1) FROM ym_income1 WHERE fid = #{fid}")
    int getIncome1Count(Map map);

    @Select("SELECT COUNT(1) FROM ym_income3 WHERE fid = #{fid}")
    int getIncome3Count(Map map);

    @Select("SELECT COUNT(1) FROM ym_income5 WHERE fid = #{fid}")
    int getIncome5Count(Map map);

    @Select("SELECT COUNT(1) FROM ym_income9 WHERE fid = #{fid}")
    int getIncome9Count(Map map);
    /*
     *
     * 查询
     *
     */
    @Select("SELECT type1,type2,nf,yf,pz,sl,je FROM ym_income1 where fid = #{fid}")
    List<YmIncome1> listIncome1(@Param(value = "fid") int fid);

    @Select("SELECT type1,type2,xm,wggz,wgdz,wgqymc,wgljsj,ny201810,ny201811, ny201812, ny201913, ny201946, ny201979, ny201910, ny201911, ny201912 FROM ym_income3 where fid = #{fid}")
    List<YmIncome3> listIncome3(@Param(value = "fid") int fid);

    @Select("SELECT type,ny201810,ny201811, ny201812, ny201913, ny201946, ny201979, ny201910, ny201911, ny201912 FROM ym_income5 where fid = #{fid}")
    List<YmIncome5> listIncome5(@Param(value = "fid") int fid);

    @Select("SELECT type,ny201810,ny201811, ny201812, ny201913, ny201946, ny201979, ny201910, ny201911, ny201912 FROM ym_income9 where fid = #{fid}")
    List<YmIncome5> listIncome9(@Param(value = "fid") int fid);
}
