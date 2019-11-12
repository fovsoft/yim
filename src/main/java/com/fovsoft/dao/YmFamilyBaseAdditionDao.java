package com.fovsoft.dao;

import com.fovsoft.entity.YmFamilyBase;
import com.fovsoft.entity.YmFamilyBaseAddition;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface YmFamilyBaseAdditionDao {


    @Insert("   INSERT INTO ym_family_base_addition(fid, poverty_causes1, poverty_causes2, poverty_causes3, household_num_Jan, household_num_Dec)\n" +
            "    VALUES (\n" + "#{fid},#{povertyCauses1},#{povertyCauses2},#{povertyCauses3},#{householdNumJan},#{householdNumDec}" +
            "\n" +
            "    )")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int add(YmFamilyBaseAddition ymFamilyBaseAddition);

    @Update("UPDATE ym_family_base_addition SET poverty_causes1 = #{povertyCauses1},poverty_causes2 = #{povertyCauses2},poverty_causes3 = #{povertyCauses3} where id = #{id}")
    int update(YmFamilyBaseAddition ymFamilyBaseAddition);
}
