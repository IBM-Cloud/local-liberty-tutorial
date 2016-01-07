package com.bluemix.tutorial.liberty;

import javax.naming.InitialContext;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;

public class Database {

  private static final String DATABASE_JNDI = "java:comp/env/couchdb/cloudant-for-liberty";
  private static final String DATABASE_NAME = "local-liberty-tutorial";
  
  private static CouchDbConnector db = null;

  public static CouchDbConnector instance() {
    if (db != null) {
      return db;
    }

    synchronized (Database.class) {
      try {
        CouchDbInstance db_lookup = (CouchDbInstance) new InitialContext().lookup(DATABASE_JNDI);
        db = db_lookup.createConnector(DATABASE_NAME, true);
        return db;
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }

}
