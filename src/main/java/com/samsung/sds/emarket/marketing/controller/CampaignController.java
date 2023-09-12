package com.samsung.sds.emarket.marketing.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.samsung.sds.emarket.marketing.api.CampaignsApi;
import com.samsung.sds.emarket.marketing.api.model.CampaignDTO;
import com.samsung.sds.emarket.marketing.api.model.NewCampaignDTO;
import com.samsung.sds.emarket.marketing.service.CampaignService;
import com.samsung.sds.emarket.marketing.service.vo.CampaignVO;

import io.swagger.annotations.Api;

@Controller
@Api(tags = "Campaigns")
public class CampaignController implements CampaignsApi {

	private final CampaignService campaignService;

	private final DTOMapper dtoMapper;

	public CampaignController(CampaignService campaignService, DTOMapper dtoMapper) {
		this.campaignService = campaignService;
		this.dtoMapper = dtoMapper;
	}

	@Override
	public ResponseEntity<List<CampaignDTO>> getCampaignList() {
		List<CampaignDTO> result = new ArrayList<CampaignDTO>();

		for (CampaignVO campaignVo : campaignService.listCampaigns()) {
			result.add(dtoMapper.toCampaignDTO(campaignVo));
		}

		return ResponseEntity.ok().body(result);
	}

	@Override
	public ResponseEntity<CampaignDTO> getCampaign(Integer id) {
		CampaignVO campaignVo = campaignService.getCampaign(id);
		if (campaignVo == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(dtoMapper.toCampaignDTO(campaignVo));
		}
	}

	@Override
	public ResponseEntity<CampaignDTO> postCampaign(@Valid NewCampaignDTO newCampaignDTO) {
		CampaignVO campaignVO = campaignService.createCampaign(dtoMapper.toNewCampaignVO(newCampaignDTO));
		CampaignDTO result = dtoMapper.toCampaignDTO(campaignVO);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@Override
    public ResponseEntity<CampaignDTO> putCampaign(Integer id, @Valid NewCampaignDTO newCampaignDTO) {
        // Convert from NewCampaignDTO to CampaignVO
        CampaignVO campaign = dtoMapper.toCampaignVO(newCampaignDTO);
        campaign.setId(id);
        
        CampaignVO result = campaignService.updateCampaign(campaign);
        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {        
            return ResponseEntity.ok().body(dtoMapper.toCampaignDTO(result));
        }
    }

    @Override
    public ResponseEntity<Boolean> deleteCampaign(Integer id) {
        boolean result = campaignService.deleteCampaigns(id);
        if (result == true) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}