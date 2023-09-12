package com.samsung.sds.emarket.marketing.service.vo;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampaignVO {
    private int id;

    private String  name;

    private String description;

    private OffsetDateTime from;

    private OffsetDateTime to;

    private String pictureUri;

    private String detailsUri; 
}