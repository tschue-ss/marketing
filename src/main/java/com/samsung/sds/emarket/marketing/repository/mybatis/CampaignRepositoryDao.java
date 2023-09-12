package com.samsung.sds.emarket.marketing.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.samsung.sds.emarket.marketing.repository.CampaignRepository;
import com.samsung.sds.emarket.marketing.repository.entity.CampaignEntity;

@Mapper
public interface CampaignRepositoryDao extends CampaignRepository {
    @Select("select id, `name`, description, `From`, `to`, pictureUri, detailsUri from campaigns")
    public List<CampaignEntity> listCampaigns();
    
    @Select("select id, `name`, description, `From`, `to`, pictureUri, detailsUri from campaigns where id = #{id}")
    public CampaignEntity getCampaign(int id);
    
    @Insert(
            "insert into `campaigns` (`name`, description, `From`, `to`, pictureUri, detailsUri)" +
            "values (#{name}, #{description}, #{from}, #{to}, #{pictureUri}, #{detailsUri})"
            )
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int createCampaign(CampaignEntity entity);
    
    @Update(
            "update `campaigns` set "
            + "`name` = #{name},"
            + "description = #{description},"
            + "`From` = #{from},"
            + "`to` = #{to},"
            + "pictureUri = #{pictureUri},"
            + "detailsUri = #{detailsUri}" 
            + "where id = #{id}"
            )
    public int updateCampaign(CampaignEntity entity);
    
    @Delete("delete from campaigns where id = #{id}")
    public int deleteCampaigns(int id);
}