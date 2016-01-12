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

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.ektorp.DocumentNotFoundException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ibm.watson.developer_cloud.personality_insights.v2.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;

/**
 * Implements GET/PUT/DELETE verbs for PIEntry. Endpoint is available at /api/pi.
 */
@Path("pi")
public class PIResource {

  private static Logger LOGGER = Logger.getLogger(PIResource.class.getName());

  private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

  public PIResource() {
  }

  /**
   * Creates a new PIEntry. It calls Watson Personality Insights before persisting the entry.
   * 
   * @param text the text to analyze
   * @param description an optional description
   * @return the persisted entry in JSON.
   */
  @POST
  public Response create(@FormParam("text") String text, @FormParam("description") String description)
      throws Exception {

    // call Watson to get PersonalityInsights
    LOGGER.info("Analyzing text...");
    PersonalityInsights pi = new PersonalityInsights();
    Profile profile = pi.getProfile(text);

    // persist the results
    LOGGER.info("Persisting analysis results...");
    PIEntry piEntry = new PIEntry();
    piEntry.setText(text);
    piEntry.setDescription(description);
    piEntry.setProfile(profile);
    piEntry.setCreatedAt(new Date());
    
    PIEntryRepository repo = new PIEntryRepository(Database.instance());
    repo.add(piEntry);

    return Response.ok(gson.toJson(piEntry), MediaType.APPLICATION_JSON_TYPE).build();
  }

  /**
   * @return all existing entries.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response get() {
    LOGGER.info("Retrieving all analysis");

    PIEntryRepository repo = new PIEntryRepository(Database.instance());
    List<PIEntry> entries = repo.getAll();
    Collections.sort(entries, new Comparator<PIEntry>() {
      @Override
      public int compare(PIEntry o1, PIEntry o2) {
        return o2.getCreatedAt().compareTo(o1.getCreatedAt());
      }
    });        
    return Response.ok(gson.toJson(entries)).build();
  }

  /**
   * @return the entry with the given id.
   */
  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response get(@PathParam("id") String id) {
    LOGGER.info("Retrieving analysis with id " + id);

    PIEntryRepository repo = new PIEntryRepository(Database.instance());
    try {
      return Response.ok(gson.toJson(repo.get(id))).build();
    } catch (DocumentNotFoundException e) {
      return Response.noContent().build();
    }
  }

  /**
   * Deletes the entry with the given id.
   */
  @DELETE
  @Path("{id}")
  public Response delete(@PathParam("id") String id) {
    LOGGER.info("Deleting analysis with id " + id);

    PIEntryRepository repo = new PIEntryRepository(Database.instance());
    PIEntry piEntry;
    try {
      piEntry = repo.get(id);
    } catch (DocumentNotFoundException e) {
      return Response.noContent().build();
    }

    repo.remove(piEntry);
    return Response.ok().build();
  }

}
