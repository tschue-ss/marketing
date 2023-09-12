package com.samsung.sds.emarket.marketing.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;

import com.samsung.sds.emarket.marketing.service.CampaignService;
import com.samsung.sds.emarket.marketing.service.vo.CampaignVO;
import com.samsung.sds.emarket.marketing.service.vo.NewCampaignVO;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CampaignController.class)
@ComponentScan(basePackageClasses = { DTOMapper.class })
@AutoConfigureMockMvc(addFilters = false)
public class CampaignControllerTests {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private CampaignService campaignService;

	@Test
	public void test_getCampaignList() throws Exception {

		// campaignService.listCampaigns() 호출 시 반환 할 값 생성
		List<CampaignVO> result = new ArrayList<CampaignVO>();
		// 내용 1
		CampaignVO campaignVo = new CampaignVO();
		campaignVo.setId(1);
		campaignVo.setName("test campaign 1");
		result.add(campaignVo);

		// 내용 2
		campaignVo = new CampaignVO();
		campaignVo.setId(2);
		campaignVo.setName("test campaign 2");
		result.add(campaignVo);

		// campaignService.listCampaigns()을 호출하면 위에서 만든 result를 반환 하도록 한다.
		when(campaignService.listCampaigns()).thenReturn(result);

		this.mvc.perform(get("/api/v1/campaigns")) // /api/v1/campaigns 주소의 GET method호출
				.andExpect(status().isOk()) // HTTP Status는 200(OK) 응답이 와야 한다.
				.andExpect(jsonPath("$.[0].id", is(1))) // 0번째줄의 id는 1이어야 함
				.andExpect(jsonPath("$.[0].name", is("test campaign 1"))) // 0번째줄의 name은 test campaign 1 이어야 함
				.andExpect(jsonPath("$.[1].id", is(2))) // 1번째줄의 id는 2이어야 함
				.andExpect(jsonPath("$.[1].name", is("test campaign 2"))) // 1번째줄의 name은 test campaign 2 이어야 함
		;
	}

	@Test
	public void test_postCampaign() throws Exception {
		String name = "test campaign 1";

		JSONObject json = new JSONObject();
		json.put("name", name);
		json.put("description", "campaign description 1");
		json.put("From", "2022-05-18T05:01:43+09:00");
		json.put("to", "2022-06-17T05:01:43+09:00");
		json.put("pictureUri", "/images/banner1.png");
		json.put("detailsUri", "/images/detail1.png");

		CampaignVO campaignVO = new CampaignVO();
		campaignVO.setId(100);
		campaignVO.setName(name);

		when(campaignService.createCampaign(any(NewCampaignVO.class))).thenReturn(campaignVO);

		this.mvc.perform(post("/api/v1/campaigns").contentType("application/json").content(json.toString()))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.id", is(100)))
				.andExpect(jsonPath("$.name", is(name)));
	}

	@Test
	public void test_postCampaign_only_required() throws Exception {
		String name = "test campaign 1";

		JSONObject json = new JSONObject();
		json.put("name", name);
		json.put("description", "campaign description 1");

		CampaignVO campaignVO = new CampaignVO();
		campaignVO.setId(100);
		campaignVO.setName(name);

		when(campaignService.createCampaign(any(NewCampaignVO.class))).thenReturn(campaignVO);

		this.mvc.perform(post("/api/v1/campaigns").contentType("application/json").content(json.toString()))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.id", is(100)))
				.andExpect(jsonPath("$.name", is(name)));
	}

	@Test
	public void test_postCampaign_without_required() throws Exception {
		// without name field
		JSONObject json = new JSONObject();
		// json.put("name", "campaign 1");
		json.put("description", "campaign description 1");

		this.mvc.perform(post("/api/v1/campaigns").contentType("application/json").content(json.toString()))
				.andExpect(status().is(400));

		// without description field
		json = new JSONObject();
		json.put("name", "campaign 1");
		// json.put("description", "campaign description 1");

		this.mvc.perform(post("/api/v1/campaigns").contentType("application/json").content(json.toString()))
				.andExpect(status().is(400));
	}

    @Test
    public void test_putCampaign() throws Exception {
        int id = 300;
        String name = "campaign 1";
        
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("description", "campaign description 1");
        json.put("From", "2021-05-27T05:01:43+09:00");
        json.put("to", "2021-06-03T05:01:43+09:00");
        json.put("pictureUri", "/images/banner1.png");
        json.put("detailsUri", "/images/detail1.png");        
        
        when(campaignService.updateCampaign(any(CampaignVO.class))).thenAnswer(
                    (InvocationOnMock invocation) -> { 
                        return ((CampaignVO)invocation.getArguments()[0]);
                    }                         
                );
        
        this.mvc.perform(put("/api/v1/campaigns/" + id).contentType("application/json").content(json.toString()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(id)))
            .andExpect(jsonPath("$.name", is(name)))
        ;
    }
}