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
