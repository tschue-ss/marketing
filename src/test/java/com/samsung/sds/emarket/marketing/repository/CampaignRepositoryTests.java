package com.samsung.sds.emarket.marketing.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.TestPropertySource;

import com.samsung.sds.emarket.marketing.repository.entity.CampaignEntity;

@MybatisTest
@TestPropertySource(properties = { "spring.config.location=classpath:application-test.properties" })
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CampaignRepositoryTests {
	@Autowired
	private CampaignRepository campaignRepository;

	@Test
	public void test_listCampaigns() {
		List<CampaignEntity> list = campaignRepository.listCampaigns();
		assertThat(list).extracting("id", "name", "description").contains(
				tuple(1, "campaign 1", "campaign description 1"), tuple(2, "campaign 2", "campaign description 2"));
	}

	@Test
	public void test_createCampaign() {
		String name = "test";
		String desc = "desc";
		String picUri = "/banner1.png";
		String detailPicUri = "/detail-banner1.png";

		Date date = new Date();
		OffsetDateTime from = date.toInstant().atOffset(ZoneOffset.UTC);
		OffsetDateTime to = from.plusMonths(3);

		CampaignEntity newCampaign = new CampaignEntity();
		newCampaign.setName(name);
		newCampaign.setDescription(desc);
		newCampaign.setPictureUri(picUri);
		newCampaign.setDetailsUri(detailPicUri);
		newCampaign.setFrom(from);
		newCampaign.setTo(to);

		campaignRepository.createCampaign(newCampaign);

		assertThat(newCampaign.getId()).isNotEqualTo(0);

		CampaignEntity actualCampaign = campaignRepository.getCampaign(newCampaign.getId());

		assertThat(newCampaign.getName()).isEqualTo(actualCampaign.getName());
		assertThat(newCampaign.getDescription()).isEqualTo(actualCampaign.getDescription());
		assertThat(newCampaign.getDetailsUri()).isEqualTo(actualCampaign.getDetailsUri());
		assertThat(newCampaign.getFrom()).isEqualTo(actualCampaign.getFrom());
		assertThat(newCampaign.getTo()).isEqualTo(actualCampaign.getTo());
		assertThat(newCampaign.getPictureUri()).isEqualTo(actualCampaign.getPictureUri());
	}
	
	
	@Test
    public void test_updateCampaign() {
        String name = "test";
        String desc = "desc";
        String picUri = "/banner1.png";
        String detailPicUri = "/detail-banner1.png";
        
        Date date = new Date();                
        OffsetDateTime from = date.toInstant().atOffset(ZoneOffset.UTC);
        OffsetDateTime to = from.plusMonths(3);
        
        
        CampaignEntity newCampaign = new CampaignEntity();
        newCampaign.setId(20);
        newCampaign.setName(name);
        newCampaign.setDescription(desc);
        newCampaign.setPictureUri(picUri);
        newCampaign.setDetailsUri(detailPicUri);
        newCampaign.setFrom(from);
        newCampaign.setTo(to);
        
        assertThat(campaignRepository.updateCampaign(newCampaign)).isEqualTo(1);        
        
        CampaignEntity actualCampaign = campaignRepository.getCampaign(newCampaign.getId());
        
        assertThat(newCampaign.getName()).isEqualTo(actualCampaign.getName());
        assertThat(newCampaign.getDescription()).isEqualTo(actualCampaign.getDescription());
        assertThat(newCampaign.getDetailsUri()).isEqualTo(actualCampaign.getDetailsUri());
        assertThat(newCampaign.getFrom()).isEqualTo(actualCampaign.getFrom());
        assertThat(newCampaign.getTo()).isEqualTo(actualCampaign.getTo());
        assertThat(newCampaign.getPictureUri()).isEqualTo(actualCampaign.getPictureUri());
    }

}