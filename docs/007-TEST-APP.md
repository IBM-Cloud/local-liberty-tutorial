## Test the application locally

We have a local Liberty profile, a local database and we have referenced the Personality Insights service.
It's time to test our application.

1. Start the server

1. Navigate to the application (the link is shown in the Liberty console)

1. Click the "Use sample text" link. This fills the textarea and the description with sample data.

1. Click "Submit". This calls Personality Insights, persists the results in the database and finally reloads the list of recently analyzed texts.
If all configurations went well, you should see:

  ![](images/all-configured.png)
  
Congratulations! You have a working local development environment for this application.

---

Proceed to the [next step](005-TEST-COUCHDB.md).