# Tutorial for local development with Liberty for Java™ 

This project provides a walkthrough on how to develop your Liberty application locally 
while using IBM Bluemix services in the cloud or their local equivalents when available.

The sample application uses the following runtime and services:

  * [Liberty for Java™](https://www.ng.bluemix.net/docs/starters/liberty/index.html)
  * [Cloudant NoSQL DB](https://www.ng.bluemix.net/docs/services/Cloudant/index.html)
  * [Personality Insights](https://www.ng.bluemix.net/docs/services/PersonalityInsights/index.html)
   
In this application, the user submits a text for analysis, optionally providing a description.
The text is sent to Personality Insights and the results are displayed.

![Sample application screenshot](docs/images/screenshot.png)

In this tutorial, you will:
  * Retrieve a local copy of the source code
  * Configure Eclipse to run the application locally
  * Use a local CouchDB database for persistence
  * Use the Watson Personality Insights service in IBM Bluemix
  * Deploy the application to IBM Bluemix

## Before we start

1. [Sign up][bluemix_signup_url] for a Bluemix Account or use an existing account.
1. Download and install the [Cloud-foundry CLI][cloud_foundry_url] tool
1. Have your Java EE development environment ready

The tutorial uses:
  * [Eclipse IDE for Java EE developers Mars.1 4.5.1](http://www.eclipse.org/downloads/)
  * Websphere Application Server Liberty Profile Tools 8.5.5.6
  * Java 8
  * Maven
  * [Apache CouchDB](http://couchdb.apache.org/)
  * [Cloud-foundry CLI][cloud_foundry_url]
  * Git command line

## Let's get started!

1. [Import the project into the development environment](docs/001-IMPORT-SOURCE.md)
1. [Create a Liberty profile](docs/002-LIBERTY.md)
1. [Install and configure Apache CouchDB](docs/003-COUCHDB.md)
1. [Configure the Liberty profile to use Apache CouchDB](docs/004-LIBERTY-COUCHDB.md)
1. [Test Liberty and CouchDB configuration](docs/005-TEST-COUCHDB.md)
1. [Configure Personality Insights](docs/006-PI.md)
1. [Test the application locally](docs/007-TEST-APP.md)
1. [Deploy the application to Bluemix](docs/008-DEPLOY.md)

[bluemix_signup_url]: https://console.ng.bluemix.net/?cm_mmc=GitHubReadMe-_-BluemixSampleApp-_-Node-_-Workflow
[cloud_foundry_url]: https://github.com/cloudfoundry/cli
