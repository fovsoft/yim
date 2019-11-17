package com.fovsoft.dao;

import com.fovsoft.entity.YmFamily;
import com.fovsoft.entity.YmFamilyBase;
import com.fovsoft.entity.YmFamilyBaseAndHouseHolder;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface YmFamilyBaseDao {


    @Insert("   INSERT INTO ym_family_base(city, county, town, avillage, nvillage, tel, dpst_bk, bk_num, family_attr, poverty_relief_tm, poverty_rtn_tm ,poverty_rtn_rsn, is_martyrsfamily, is_relocated, relocated_way, relocated_addr, add_time)\n" +
            "    VALUES (\n" + "#{city},#{county},#{town},#{avillage},#{nvillage},#{tel},#{dpstBk},#{bkNum},#{familyAttr},#{povertyReliefTm},#{povertyRtnTm},#{povertyRtnRsn},#{isMartyrsfamily},#{isRelocated},#{relocatedWay},#{relocatedAddr},#{addTime}" +
            "\n" +
            "    )")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int add(YmFamilyBase ymFamilyBase);


    @Results({
            @Result(property = "fpnd", column = "poverty_rtn_tm"),
            @Result(property = "sfydbqh", column = "is_relocated"),
            @Result(property = "pkhsx", column = "family_attr"),
            @Result(property = "jhtpnd", column = "poverty_relief_tm"),
            @Result(property = "hzxm", column = "member_name"),
            @Result(property = "zjhm", column = "id_num")
    })
    @Select("SELECT a.id,a.poverty_rtn_tm,a.is_relocated,a.family_attr,a.poverty_relief_tm, b.member_name, b.id_num " +
            "FROM ym_family_base a LEFT JOIN ym_family_base_member b ON a.id = b.fid AND b.`relation` = 1 ORDER BY a.id DESC")
    List<YmFamilyBaseAndHouseHolder> list();


    @Delete({"DELETE FROM ym_family_base WHERE id = #{id};" +
            "DELETE FROM ym_family_base_member WHERE fid = #{id};" +
            "DELETE FROM ym_family_base_addition WHERE fid = #{id};" +
            "DELETE FROM ym_family_base_condition WHERE fid = #{id};"
    })
    int delete(Integer id);

    @Delete({
            "DELETE FROM ym_family_base WHERE id IN ( ${inStr} );" +
            "DELETE FROM ym_family_base_member WHERE fid IN (${inStr});" +
            "DELETE FROM ym_family_base_addition WHERE fid IN ( ${inStr} );" +
            "DELETE FROM ym_family_base_condition WHERE fid IN ( ${inStr} );"
    })
    int delAll(@RequestParam(name = "inStr") String inStr);

    @Select("SELECT id,city,county,town,avillage,nvillage,tel,dpst_bk dpstBk,bk_num bkNum,family_attr familyAttr,poverty_relief_tm povertyReliefTm,poverty_rtn_tm povertyRtnTm,poverty_rtn_rsn povertyRtnRsn,is_martyrsfamily isMartyrsfamily,is_relocated isRelocated,relocated_way relocatedWay,relocated_addr relocatedAddr " +
            "FROM ym_family_base WHERE id = #{id}")
    YmFamilyBase get(int id);

    @Update("Update ym_family_base set city=#{city},county=#{county},town=#{town},avillage=#{avillage},nvillage=#{nvillage},tel=#{tel}," +
            "dpst_bk=#{dpstBk},bk_num=#{bkNum},family_attr=#{familyAttr},poverty_relief_tm=#{povertyReliefTm},poverty_rtn_tm=#{povertyRtnTm},poverty_rtn_rsn=#{povertyRtnRsn},is_martyrsfamily=#{isMartyrsfamily},is_relocated=#{isRelocated}," +
            "relocated_way=#{relocatedWay},relocated_addr=#{relocatedAddr} WHERE id = #{id}")
    int update(YmFamilyBase ymFamilyBase);
}
