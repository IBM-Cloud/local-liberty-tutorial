## Install and configure Apache CouchDB

Cloudant is built upon CouchDB. Having your own CouchDB installation makes it very handy to develop locally.

1. Go to [Apache CouchDB](http://couchdb.apache.org/#download) to download and install CouchDB

  *Note: for this tutorial, we use the Windows version 1.6.1 and the installer.
  The installer creates a Windows service and shortcuts.
  The Mac OS X version also does a nice job and makes it super easy to install and start CouchDB.*

1. Start CouchDB

1. Access the CouchDB web interface (running at http://127.0.0.1:5984/_utils/ by default)

  ![](images/couchdb-web-interface.png)
  
1. Create an admin user and password

  By default everyone is admin. Follow the *Fix this* link at the bottom right:

  ![](images/couchdb-create-admin.png)
  
  Make note of these credentials, we will need them later.

1. Create a database named *local-liberty-tutorial*

  ![](images/couchdb-create-database.png)

---

Proceed to the [next step](004-LIBERTY-COUCHDB.md).