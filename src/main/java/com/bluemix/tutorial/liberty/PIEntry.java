package com.bluemix.tutorial.liberty;

import java.util.Date;

import org.ektorp.support.CouchDbDocument;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;

@SuppressWarnings("serial")
@JsonInclude(Include.NON_EMPTY)
public class PIEntry extends CouchDbDocument {

  private String type = "PIEntry";
  private String text;
  private String description;
  private Profile profile;
  private Date createdAt;

  public String getType() {
    return type;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

}
