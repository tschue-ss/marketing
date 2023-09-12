package com.samsung.sds.emarket.marketing.service;

import org.mapstruct.Mapper;

import com.samsung.sds.emarket.marketing.repository.entity.CampaignEntity;
import com.samsung.sds.emarket.marketing.service.vo.CampaignVO;
import com.samsung.sds.emarket.marketing.service.vo.NewCampaignVO;

@Mapper(componentModel = "spring")
public interface VOMapper {
    CampaignVO toCampaignVO(CampaignEntity entity);

    CampaignEntity toCampaignEntity(NewCampaignVO newCampaign);

    CampaignEntity toCampaignEntity(CampaignVO campaignVO);
}