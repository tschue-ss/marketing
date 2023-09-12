package com.samsung.sds.emarket.marketing.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.samsung.sds.emarket.marketing.repository.CampaignRepository;
import com.samsung.sds.emarket.marketing.repository.entity.CampaignEntity;
import com.samsung.sds.emarket.marketing.service.vo.CampaignVO;
import com.samsung.sds.emarket.marketing.service.vo.NewCampaignVO;

@ExtendWith(MockitoExtension.class)
public class CampaignServiceTests {
    @Mock
    private CampaignRepository campaignRepository;
    
    @Test
    public void test_listCampaigns() {
        // campaignRepository.listCampaigns() 호출 시 반환 할 객체 생성
        List<CampaignEntity> result = new ArrayList<>();

        // 내용 1
        CampaignEntity campaign = new CampaignEntity();
        campaign.setId(3);
        campaign.setName("test name 3");
    	result.add(campaign);

        // 내용 2
    	campaign = new CampaignEntity();
        campaign.setId(4);
        campaign.setName("test name 4");
    	result.add(campaign);

        // campaignRepository.listCampaigns()을 호출하면 result를 반환 해 준다. 
    	when(campaignRepository.listCampaigns()).thenReturn(result);
    	
    	CampaignService campaignService = new CampaignServiceImpl(campaignRepository, new VOMapperImpl());
        
        List<CampaignVO> list = campaignService.listCampaigns();  // campaignService.listCampaigns()의 호출 결과 저장
        assertThat(list).extracting("id", "name").contains(
                tuple(3, "test name 3"),  // id가 3이고 name이 test name 3인 데이터가 존재 해야함
                tuple(4, "test name 4")   // id가 4이고 name이 test name 4인 데이터가 존재 해야함
                );
    }
    
    @Test
    public void test_createCampaign() {
        String name = "test name";
        OffsetDateTime from = OffsetDateTime.now();
        OffsetDateTime to = from.plusMonths(3); 
        
        NewCampaignVO newCampaign = new NewCampaignVO();
        newCampaign.setName(name);
        newCampaign.setDescription("desc");
        newCampaign.setDetailsUri("detailUri");
        newCampaign.setFrom(from);
        newCampaign.setTo(to);    
        
        when(campaignRepository.createCampaign(any(CampaignEntity.class)))
            .thenAnswer(
                (InvocationOnMock invocation) -> {
                    ((CampaignEntity)invocation.getArguments()[0]).setId(100);
                    return 1;
        });
      
        CampaignService campaignService = new CampaignServiceImpl(campaignRepository, new VOMapperImpl());
        assertThat(campaignService.createCampaign(newCampaign))
          .hasFieldOrPropertyWithValue("id", 100)
          .hasFieldOrPropertyWithValue("name", name)
          ;
    }
    
    @Test
    public void test_updateCampaign() {
        String name = "test name";
        OffsetDateTime from = OffsetDateTime.now();
        OffsetDateTime to = from.plusMonths(3); 
        
        CampaignVO newCampaign = new CampaignVO();
        newCampaign.setId(300);
        newCampaign.setName(name);
        newCampaign.setDescription("desc");
        newCampaign.setDetailsUri("detailUri");
        newCampaign.setFrom(from);
        newCampaign.setTo(to);    
        
        when(campaignRepository.getCampaign(300)).thenReturn(new CampaignEntity());
        
        CampaignService campaignService = new CampaignServiceImpl(campaignRepository, new VOMapperImpl());
        assertThat(campaignService.updateCampaign(newCampaign))
            .hasFieldOrPropertyWithValue("id", 300)
            .hasFieldOrPropertyWithValue("name", name)
            ;
    }
}