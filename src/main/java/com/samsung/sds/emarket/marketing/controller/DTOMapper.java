package com.samsung.sds.emarket.marketing.controller;

import javax.validation.Valid;

import org.mapstruct.Mapper;

import com.samsung.sds.emarket.marketing.api.model.CampaignDTO;
import com.samsung.sds.emarket.marketing.api.model.NewCampaignDTO;
import com.samsung.sds.emarket.marketing.service.vo.CampaignVO;
import com.samsung.sds.emarket.marketing.service.vo.NewCampaignVO;

@Mapper(componentModel = "spring")
public interface DTOMapper {   
    CampaignDTO toCampaignDTO(CampaignVO campaign);

	NewCampaignVO toNewCampaignVO(@Valid NewCampaignDTO newCampaignDTO);

	CampaignVO toCampaignVO(@Valid NewCampaignDTO newCampaignDTO);
}