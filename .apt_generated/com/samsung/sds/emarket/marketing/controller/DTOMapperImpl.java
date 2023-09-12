package com.samsung.sds.emarket.marketing.controller;

import com.samsung.sds.emarket.marketing.api.model.CampaignDTO;
import com.samsung.sds.emarket.marketing.api.model.NewCampaignDTO;
import com.samsung.sds.emarket.marketing.service.vo.CampaignVO;
import com.samsung.sds.emarket.marketing.service.vo.NewCampaignVO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-27T04:06:52+0000",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class DTOMapperImpl implements DTOMapper {

    @Override
    public CampaignDTO toCampaignDTO(CampaignVO campaign) {
        if ( campaign == null ) {
            return null;
        }

        CampaignDTO campaignDTO = new CampaignDTO();

        campaignDTO.setId( campaign.getId() );
        campaignDTO.setName( campaign.getName() );
        campaignDTO.setDescription( campaign.getDescription() );
        campaignDTO.setFrom( campaign.getFrom() );
        campaignDTO.setTo( campaign.getTo() );
        campaignDTO.setPictureUri( campaign.getPictureUri() );
        campaignDTO.setDetailsUri( campaign.getDetailsUri() );

        return campaignDTO;
    }

    @Override
    public NewCampaignVO toNewCampaignVO(NewCampaignDTO newCampaignDTO) {
        if ( newCampaignDTO == null ) {
            return null;
        }

        NewCampaignVO newCampaignVO = new NewCampaignVO();

        newCampaignVO.setDescription( newCampaignDTO.getDescription() );
        newCampaignVO.setDetailsUri( newCampaignDTO.getDetailsUri() );
        newCampaignVO.setFrom( newCampaignDTO.getFrom() );
        newCampaignVO.setName( newCampaignDTO.getName() );
        newCampaignVO.setPictureUri( newCampaignDTO.getPictureUri() );
        newCampaignVO.setTo( newCampaignDTO.getTo() );

        return newCampaignVO;
    }

    @Override
    public CampaignVO toCampaignVO(NewCampaignDTO newCampaignDTO) {
        if ( newCampaignDTO == null ) {
            return null;
        }

        CampaignVO campaignVO = new CampaignVO();

        campaignVO.setDescription( newCampaignDTO.getDescription() );
        campaignVO.setDetailsUri( newCampaignDTO.getDetailsUri() );
        campaignVO.setFrom( newCampaignDTO.getFrom() );
        campaignVO.setName( newCampaignDTO.getName() );
        campaignVO.setPictureUri( newCampaignDTO.getPictureUri() );
        campaignVO.setTo( newCampaignDTO.getTo() );

        return campaignVO;
    }
}
