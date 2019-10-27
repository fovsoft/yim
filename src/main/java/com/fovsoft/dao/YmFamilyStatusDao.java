package com.fovsoft.dao;

import com.fovsoft.entity.YmFamilyStatus;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: by tpc
 * @date: 2019/10/18 9:21
 * @description:
 **/
@Mapper
public interface YmFamilyStatusDao {


    @Insert("insert into fm_family_status(jtbh,zpyy1,zpyy2,zpyy3,ncjtrks,ndjtrks,gdmj,yxggmj,ldmj,tghlmj,lgmj,smmj,mcdmj,sfyltqydd,sfycyzfdtrdd,sftscyd,sftshyd,sftgbds,yssfkn,yssfaq,zfmj,ywwscs,sfwfh,wfdj,wgnd,zfjg,sfjrnmzyhzs,yczgljl,rhllx,zyrllx,bgqksm) values (#{jtbh},#{zpyy1},#{zpyy2},#{zpyy3},#{ncjtrks},#{ndjtrks},#{gdmj},#{yxggmj},#{ldmj},#{tghlmj},#{lgmj},#{smmj},#{mcdmj},#{sfyltqydd},#{sfycyzfdtrdd},#{sftscyd},#{sftshyd},#{sftgbds},#{yssfkn},#{yssfaq},#{zfmj},#{ywwscs},#{sfwfh},#{wfdj},#{wgnd},#{zfjg},#{sfjrnmzyhzs},#{yczgljl},#{rhllx},#{zyrllx},#{bgqksm})")
    int addYmFamilyStatus(YmFamilyStatus ymFamilyStatus);

}
