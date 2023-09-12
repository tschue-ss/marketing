package com.samsung.sds.emarket.marketing.service;

import java.util.List;

import com.samsung.sds.emarket.marketing.service.vo.CampaignVO;
import com.samsung.sds.emarket.marketing.service.vo.NewCampaignVO;

public interface CampaignService {
    List<CampaignVO> listCampaigns();
    CampaignVO getCampaign(Integer id);
    CampaignVO createCampaign(NewCampaignVO newCampaign);
    /**
     * @param campaignVO
     * @return
     */
    CampaignVO updateCampaign(CampaignVO campaignVO);
    boolean deleteCampaigns(int id);
}