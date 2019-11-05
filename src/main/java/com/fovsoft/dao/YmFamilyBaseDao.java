package com.fovsoft.dao;

import com.fovsoft.entity.YmFamily;
import com.fovsoft.entity.YmFamilyBase;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface YmFamilyBaseDao {


    @Insert("   INSERT INTO ym_family_base(city, county, town, avillage, nvillage, tel, dpst_bk, bk_num, family_attr, poverty_relief_tm, poverty_rtn_tm ,poverty_rtn_rsn, is_martyrsfamily, is_relocated, relocated_way, relocated_addr, add_time)\n" +
            "    VALUES (\n" + "#{city},#{county},#{town},#{avillage},#{nvillage},#{tel},#{dpstBk},#{bkNum},#{familyAttr},#{povertyReliefTm},#{povertyRtnTm},#{povertyRtnRsn},#{isMartyrsfamily},#{isRelocated},#{relocatedWay},#{relocatedAddr},#{addTime}" +
            "\n" +
            "    )")
    @Options(useGeneratedKeys=true, keyProperty = "id",keyColumn = "id")
    int add(YmFamilyBase ymFamilyBase);
}
