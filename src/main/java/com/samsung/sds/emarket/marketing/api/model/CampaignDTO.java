package com.samsung.sds.emarket.marketing.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CampaignDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class CampaignDTO   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("From")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime from;

  @JsonProperty("to")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime to;

  @JsonProperty("pictureUri")
  private String pictureUri;

  @JsonProperty("detailsUri")
  private String detailsUri;

  public CampaignDTO id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Campaign ID
   * @return id
  */
  @ApiModelProperty(example = "100", required = true, value = "Campaign ID")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public CampaignDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Campaign name
   * @return name
  */
  @ApiModelProperty(example = "Campaign 2022", required = true, value = "Campaign name")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CampaignDTO description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Campaign description
   * @return description
  */
  @ApiModelProperty(example = "New Sale Campaign in 2022", required = true, value = "Campaign description")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CampaignDTO from(OffsetDateTime from) {
    this.from = from;
    return this;
  }

  /**
   * Campaign start date/time
   * @return from
  */
  @ApiModelProperty(example = "2022-05-18T05:01:43+09:00", value = "Campaign start date/time")

  @Valid

  public OffsetDateTime getFrom() {
    return from;
  }

  public void setFrom(OffsetDateTime from) {
    this.from = from;
  }

  public CampaignDTO to(OffsetDateTime to) {
    this.to = to;
    return this;
  }

  /**
   * Campaign end date/time
   * @return to
  */
  @ApiModelProperty(example = "2022-06-17T05:01:43+09:00", value = "Campaign end date/time")

  @Valid

  public OffsetDateTime getTo() {
    return to;
  }

  public void setTo(OffsetDateTime to) {
    this.to = to;
  }

  public CampaignDTO pictureUri(String pictureUri) {
    this.pictureUri = pictureUri;
    return this;
  }

  /**
   * Campaign banner image URL
   * @return pictureUri
  */
  @ApiModelProperty(example = "/images/banner-2.png", value = "Campaign banner image URL")


  public String getPictureUri() {
    return pictureUri;
  }

  public void setPictureUri(String pictureUri) {
    this.pictureUri = pictureUri;
  }

  public CampaignDTO detailsUri(String detailsUri) {
    this.detailsUri = detailsUri;
    return this;
  }

  /**
   * Campaign detail image URL
   * @return detailsUri
  */
  @ApiModelProperty(example = "/images/detail-2.png", value = "Campaign detail image URL")


  public String getDetailsUri() {
    return detailsUri;
  }

  public void setDetailsUri(String detailsUri) {
    this.detailsUri = detailsUri;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CampaignDTO campaignDTO = (CampaignDTO) o;
    return Objects.equals(this.id, campaignDTO.id) &&
        Objects.equals(this.name, campaignDTO.name) &&
        Objects.equals(this.description, campaignDTO.description) &&
        Objects.equals(this.from, campaignDTO.from) &&
        Objects.equals(this.to, campaignDTO.to) &&
        Objects.equals(this.pictureUri, campaignDTO.pictureUri) &&
        Objects.equals(this.detailsUri, campaignDTO.detailsUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, from, to, pictureUri, detailsUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CampaignDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    pictureUri: ").append(toIndentedString(pictureUri)).append("\n");
    sb.append("    detailsUri: ").append(toIndentedString(detailsUri)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

