## Create a Liberty profile

1. Create a new Liberty server to host the project.

  In the Eclipse Servers view, create a new server:

  ![](images/ide-after-import.png)

1. Select *IBM / WebSphere Application Server Liberty Profile*:
  * Host name: *localhost*
  * Server name: *Liberty for local-liberty-tutorial*
  
  ![](images/select-liberty-profile.png)

  *Note: if this server type is not showing, go to the Eclipse Marketplace to install the Websphere Application Server Liberty Profile Tools.*
  
1. Create a new runtime environment:
  * Name: *Liberty for local development*
  * Install from an archive or a repository
  
  ![](images/create-new-runtime.png)
  
1. Select the environment options:
  * for Destination path, point to an empty directory. The Libery files will be created right under this directory.
  * Use *Download and install from ibm.com* and select *WAS Liberty V8.5.5.8 with Java EE 7 Full Platform*
  
  ![](images/install-runtime-environment.png)

1. In the addon, select CouchDB Integration 1.0:
  
  ![](images/install-couchdb.png)
  
1. Accept the license terms
  
  ![](images/accept-licenses.png)
  
1. Name the server

  ![](images/name-the-server.png)

  *Note: if this is the first server you create the default is OK.
  If you develop multiple applications, you may want to create multiple Liberty profiles to isolate
  the applications from each other and be closer to how you deploy them in the cloud. In such case,
  naming the profile like the application would be a good option*

1. Press Finish, sit back and relax. Eclipse is downloading and creating the Liberty runtime followed by the defaultServer profile:

  ![](images/wait-while-install.png)

1. Done!
  
  ![](images/install-complete.png)
  
  The new server is created:
  
  ![](images/new-server.png)

---

Proceed to the [next step](003-COUCHDB.md).