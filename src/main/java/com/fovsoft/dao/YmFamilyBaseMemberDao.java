package com.fovsoft.dao;

import com.fovsoft.entity.YmFamilyBaseCondition;
import com.fovsoft.entity.YmFamilyBaseMember;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface YmFamilyBaseMemberDao {


    @Insert("   INSERT INTO ym_family_base_member(fid,member_name,sex,id_num,relation,nation,political_exp,level_edu,school_status,stopedu_rsn,healthy_status,labor_skill,can_mandarin,medical_insurance,business_insurance,basic_allowances,endowment_insurance,accident_insurance,tel)\n" +
            "    VALUES (\n" + "#{fid},#{memberName},#{sex},#{idNum},#{relation},#{nation},#{politicalExp},#{levelEdu},#{schoolStatus},#{stopeduRsn},#{healthyStatus},#{laborSkill},#{canMandarin},#{medicalInsurance},#{businessInsurance},#{basicAllowances},#{endowmentInsurance},#{accidentInsurance},#{tel}" +
            "\n" +
            "    )")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int add(YmFamilyBaseMember ymFamilyBaseMember);

    @Update("UPDATE ym_family_base_condition SET fid=#{fid},name=#{memberName},sex=#{sex},id_num=#{idNum},relation=#{relation},nation=#{nation},political_exp=#{politicalExp},\n" +
            "        level_edu=#{levelEdu},school_status=#{schoolStatus},stopedu_rsn=#{stopeduRsn},\n" +
            "        healthy_status=#{healthyStatus},labor_skill=#{laborSkill},can_mandarin=#{canMandarin},\n" +
            "        medical_insurance=#{medicalInsurance},business_insurance= #{businessInsurance},basic_allowances=#{basicAllowances},endowment_insurance=#{endowmentInsurance},accident_insurance=#{accidentInsurance},tel=#{tel}\n")
    int update(YmFamilyBaseMember ymFamilyBaseMember);
}






