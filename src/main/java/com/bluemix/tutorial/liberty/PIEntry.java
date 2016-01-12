/**
 * Copyright 2016 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.bluemix.tutorial.liberty;

import java.util.Date;

import org.ektorp.support.CouchDbDocument;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;

/**
 * A Personality Insights entry in the database. Each entry has the original
 * text, an optional description, its creation date and the Personality Insights
 * profile.
 */
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
