## Test the application

We have a local Liberty profile, a local database and we have referenced the Personality Insights service. It's time to test our application.

1. Start the server

1. Navigate to the application (default URL should be http://localhost:9080/local-liberty-tutorial/)

1. Click the "Use sample text" link. This fills the textarea and description with sample data.

1. Click "Submit". This calls Personality Insights and persists the results in the database. finally it reloads the list of recently analyzed text. If all configurations went well, you should see:

  ![](images/all-configured.png)
  
Congratulations you now have a working local development environment!
