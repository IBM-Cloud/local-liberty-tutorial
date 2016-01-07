package com.bluemix.tutorial.liberty;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;

public class PIEntryRepository extends CouchDbRepositorySupport<PIEntry> {
  
  public PIEntryRepository(CouchDbConnector db) {
    super(PIEntry.class, db);
  }

}
