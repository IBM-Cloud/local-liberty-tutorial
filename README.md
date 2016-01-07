# Tutorial for local development with Liberty for Java™ 

This project provides a walkthrough on how to develop your Liberty application locally on your machine
while using IBM Bluemix services in the cloud or their local equivalents when available.

The sample application uses the following runtime and services:

  * Liberty for Java™
  * Cloudant NoSQL DB
  * Personality Insights
   
In this sample, the user submits a text for analysis, optionally providing a description. The text is sent to Watson Personality Insights

![Sample application screenshot](docs/screenshot.png)

In this walkthrough, you will:
  * Retrieve a local copy of the source code
  * Configure Eclipse to run the application locally
  * Use a local CouchDB database for persistence
  * Use the Watson Personality Insights service in IBM Bluemix
  * Deploy the application to IBM Bluemix

## Before we start

1. Create a Bluemix Account

  [Sign up][bluemix_signup_url] for Bluemix, or use an existing account.
1. Download and install the [Cloud-foundry CLI][cloud_foundry_url] tool
1. Prepare your JavaEE development environment

In this walkthrough, we use:
  * [Cloud-foundry CLI][cloud_foundry_url]
  * Git command line
  * Eclipse IDE for Java EE developers Mars.1
  * Websphere Application Server Liberty Profile Tools 8.5.5.6
  * Java 8
  * Maven
  * Apache CouchDB

Let's get started.

## Configuring the development environment

1. Retrieve the source code on your local machine

```
$ git clone https://github.com/IBM-Bluemix/local-liberty-tutorial.git
```

[bluemix_signup_url]: https://console.ng.bluemix.net/?cm_mmc=GitHubReadMe-_-BluemixSampleApp-_-Node-_-Workflow
[cloud_foundry_url]: https://github.com/cloudfoundry/cli
