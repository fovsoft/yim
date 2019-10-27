package com.fovsoft.dao;

import com.fovsoft.entity.YmPerson;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: by tpc
 * @date: 2019/10/18 9:21
 * @description:
 **/

@Mapper
public interface YmPersonDao {


    @Insert(" insert into ym_person(jtbh,xm,sex,sfzmhm,qfjg,sfzyxqs,sfzyxqz,yhzgx,mz,csrq,zzmm,whcd,zxsqk,sxhcxyy,jkqk,ldjn,sfhjpth,sfxyjr,sfcjylbx1,sfcjsybx,sfxsdb,sfcjylbx2,sfxsywbxbt,lxdh) values "+
            " (#{jtbh},#{xm},#{sex},#{sfzmhm},#{qfjg},#{sfzyxqs},#{sfzyxqz},#{yhzgx},#{mz},#{csrq},#{zzmm},#{whcd},#{zxsqk},#{sxhcxyy},#{jkqk},#{ldjn},#{sfhjpth},#{sfxyjr},#{sfcjylbx1},#{sfcjsybx},#{sfxsdb},#{sfcjylbx2},#{sfxsywbxbt},#{lxdh})")
    int addYmPerson(YmPerson ymPerson);


    @Select("select * from ym_person where xm=#{xm}")
    @Results(id = "ymPersonResultMap", value={
            @Result(property="rybh"       , column="rybh"      ),
            @Result(property="jtbh"       , column="jtbh"      ),
            @Result(property="xm"         , column="xm"        ),
            @Result(property="sex"        , column="sex"       ),
            @Result(property="sfzmhm"     , column="sfzmhm"    ),
            @Result(property="qfjg"       , column="qfjg"      ),
            @Result(property="sfzyxqs"    , column="sfzyxqs"   ),
            @Result(property="sfzyxqz"    , column="sfzyxqz"   ),
            @Result(property="yhzgx"      , column="yhzgx"     ),
            @Result(property="mz"         , column="mz"        ),
            @Result(property="csrq"       , column="csrq"      ),
            @Result(property="zzmm"       , column="zzmm"      ),
            @Result(property="whcd"       , column="whcd"      ),
            @Result(property="zxsqk"      , column="zxsqk"     ),
            @Result(property="sxhcxyy"    , column="sxhcxyy"   ),
            @Result(property="jkqk"       , column="jkqk"      ),
            @Result(property="ldjn"       , column="ldjn"      ),
            @Result(property="sfhjpth"    , column="sfhjpth"   ),
            @Result(property="sfxyjr"     , column="sfxyjr"    ),
            @Result(property="sfcjylbx1"  , column="sfcjylbx1" ),
            @Result(property="sfcjsybx"   , column="sfcjsybx"  ),
            @Result(property="sfxsdb"     , column="sfxsdb"    ),
            @Result(property="sfcjylbx2"  , column="sfcjylbx2" ),
            @Result(property="sfxsywbxbt" , column="sfxsywbxbt"),
            @Result(property="lxdh"       , column="lxdh"      )
    })
    YmPerson findYmPersonByXm(String xm);


    /*
     * @author: tpc
     * @date: 2019/10/20 16:41
     * @description: 通过人员编号查找贫困人员信息
     */
    @Select("select * from ym_person where rybh=#{rybh}")
    @ResultMap(value = {"ymPersonResultMap"})
    YmPerson findYmPersonByRybh(String rybh);

    /*
     * @author: tpc
     * @date: 2019/10/20 16:43
     * @description:  获取所有贫困人员信息
     */
    @Select("select * from ym_person order by rybh asc")
    @ResultMap(value = {"ymPersonResultMap"})
    List<YmPerson> findAllYmPerson();

}
