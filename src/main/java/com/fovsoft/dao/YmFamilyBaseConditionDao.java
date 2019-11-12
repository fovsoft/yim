package com.fovsoft.dao;

import com.fovsoft.entity.YmFamilyBaseAddition;
import com.fovsoft.entity.YmFamilyBaseCondition;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface YmFamilyBaseConditionDao {


    @Insert("   INSERT INTO ym_family_base_condition(fid,area_cultivated,area_woodland,area_turninto,area_fruit,area_foragegrass,area_waters,is_cooperative,get_leaded,get_pioneer,get_electric,get_television,get_potablewater,get_toilet,distance_mainroad,type_road,area_housing,is_dilapidated,level_dilapidated,year_reform,type_fuel,type_fuel_other)\n" +
            "    VALUES (\n" + "#{fid},#{areaCultivated},#{areaWoodland},#{areaTurninto},#{areaFruit},#{areaForagegrass},#{areaWaters},#{isCooperative},#{getLeaded},#{getPioneer},#{getElectric},#{getTelevision},#{getPotablewater},#{getToilet},#{distanceMainroad},#{typeRoad},#{areaHousing},#{isDilapidated},#{levelDilapidated},#{yearReform},#{typeFuel},#{typeFuelOther}" +
            "\n" +
            "    )")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int add(YmFamilyBaseCondition ymFamilyBaseCondition);

    @Update("UPDATE ym_family_base_condition SET area_cultivated = #{areaCultivated}, area_woodland = #{areaWoodland},area_turninto = #{areaTurninto},area_fruit = #{areaFruit},\n" +
            "        area_foragegrass = #{areaForagegrass},area_waters = #{areaWaters},is_cooperative = #{isCooperative},\n" +
            "        get_leaded = #{getLeaded}, get_leaded = #{getPioneer},get_electric = #{getElectric},get_television = #{getTelevision},\n" +
            "        get_potablewater = #{getPotablewater},\n" +
            "        get_toilet = #{getToilet},distance_mainroad = #{distanceMainroad}, type_road = #{typeRoad},area_housing =#{areaHousing},is_dilapidated = #{isDilapidated},level_dilapidated = #{levelDilapidated},year_reform = #{yearReform},type_fuel = #{typeFuel},type_fuel_other = #{typeFuelOther} where id = #{id}")
    int update(YmFamilyBaseCondition ymFamilyBaseCondition);
}


