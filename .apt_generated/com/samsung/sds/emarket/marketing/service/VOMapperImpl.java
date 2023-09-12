package com.samsung.sds.emarket.marketing.service;

import com.samsung.sds.emarket.marketing.repository.entity.CampaignEntity;
import com.samsung.sds.emarket.marketing.service.vo.CampaignVO;
import com.samsung.sds.emarket.marketing.service.vo.NewCampaignVO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-27T04:06:53+0000",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class VOMapperImpl implements VOMapper {

    @Override
    public CampaignVO toCampaignVO(CampaignEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CampaignVO campaignVO = new CampaignVO();

        campaignVO.setDescription( entity.getDescription() );
        campaignVO.setDetailsUri( entity.getDetailsUri() );
        campaignVO.setFrom( entity.getFrom() );
        campaignVO.setId( entity.getId() );
        campaignVO.setName( entity.getName() );
        campaignVO.setPictureUri( entity.getPictureUri() );
        campaignVO.setTo( entity.getTo() );

        return campaignVO;
    }

    @Override
    public CampaignEntity toCampaignEntity(NewCampaignVO newCampaign) {
        if ( newCampaign == null ) {
            return null;
        }

        CampaignEntity campaignEntity = new CampaignEntity();

        campaignEntity.setDescription( newCampaign.getDescription() );
        campaignEntity.setDetailsUri( newCampaign.getDetailsUri() );
        campaignEntity.setFrom( newCampaign.getFrom() );
        campaignEntity.setName( newCampaign.getName() );
        campaignEntity.setPictureUri( newCampaign.getPictureUri() );
        campaignEntity.setTo( newCampaign.getTo() );

        return campaignEntity;
    }

    @Override
    public CampaignEntity toCampaignEntity(CampaignVO campaignVO) {
        if ( campaignVO == null ) {
            return null;
        }

        CampaignEntity campaignEntity = new CampaignEntity();

        campaignEntity.setDescription( campaignVO.getDescription() );
        campaignEntity.setDetailsUri( campaignVO.getDetailsUri() );
        campaignEntity.setFrom( campaignVO.getFrom() );
        campaignEntity.setId( campaignVO.getId() );
        campaignEntity.setName( campaignVO.getName() );
        campaignEntity.setPictureUri( campaignVO.getPictureUri() );
        campaignEntity.setTo( campaignVO.getTo() );

        return campaignEntity;
    }
}
