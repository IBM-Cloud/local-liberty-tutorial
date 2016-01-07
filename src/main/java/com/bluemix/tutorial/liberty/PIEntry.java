package com.bluemix.tutorial.liberty;

import java.util.Date;
import java.util.List;

import org.ektorp.support.CouchDbDocument;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Trait;

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
    fixTrait(profile.getTree());
  }

  /**
   * Circumvent an issue when the "Trait" class currently has "double" return
   * types for some "Double" objects that might be null. It throws NPE when
   * unboxing the value during serialization by Jackson as Jackson will call the
   * getter.
   * 
   * @see https://github.com/watson-developer-cloud/java-sdk/issues/151
   */
  private static void fixTrait(Trait trait) {
    try {
      trait.getRawSamplingError();
    } catch (NullPointerException e) {
      trait.setRawSamplingError(0);
    }
    try {
      trait.getRawScore();
    } catch (NullPointerException e) {
      trait.setRawScore(0);
    }
    List<Trait> children = trait.getChildren();
    if (children != null) {
      for (Trait child : children) {
        fixTrait(child);
      }
    }
  }
}
