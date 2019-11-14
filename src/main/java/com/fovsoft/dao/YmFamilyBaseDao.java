package com.fovsoft.dao;

import com.fovsoft.entity.YmFamily;
import com.fovsoft.entity.YmFamilyBase;
import com.fovsoft.entity.YmFamilyBaseAndHouseHolder;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface YmFamilyBaseDao {


    @Insert("   INSERT INTO ym_family_base(city, county, town, avillage, nvillage, tel, dpst_bk, bk_num, family_attr, poverty_relief_tm, poverty_rtn_tm ,poverty_rtn_rsn, is_martyrsfamily, is_relocated, relocated_way, relocated_addr, add_time)\n" +
            "    VALUES (\n" + "#{city},#{county},#{town},#{avillage},#{nvillage},#{tel},#{dpstBk},#{bkNum},#{familyAttr},#{povertyReliefTm},#{povertyRtnTm},#{povertyRtnRsn},#{isMartyrsfamily},#{isRelocated},#{relocatedWay},#{relocatedAddr},#{addTime}" +
            "\n" +
            "    )")
    @Options(useGeneratedKeys=true, keyProperty = "id",keyColumn = "id")
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
            "FROM ym_family_base a LEFT JOIN ym_family_base_member b ON a.id = b.fid")
    List<YmFamilyBaseAndHouseHolder> list();
}
