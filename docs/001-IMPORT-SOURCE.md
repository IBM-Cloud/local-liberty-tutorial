## Import the project into the development environment

1. Retrieve the source code on your local machine

  ```
  $ git clone https://github.com/IBM-Bluemix/local-liberty-tutorial.git
  ```

  *Note: you can also download a ZIP file from [GitHub](https://github.com/IBM-Bluemix/local-liberty-tutorial.git).*
  
1. Import the project into your development environment.

  In Eclipse, use "Import > Existing Maven Projects" and point to the checkout directory.
  Eclipse will automatically generate the right project and classpath files by introspecting the *pom.xml*

  ![](images/import-maven-project.png)

### About the code

The application is a simple Java EE web application.

![Architecture](http://g.gravizo.com/g?
  digraph G {
    node [fontname = "helvetica"]
    ui -> liberty
    liberty -> database
    liberty -> watsonpi
    rankdir = LR;
    database [shape=box style=filled color="%234E96DB" fontcolor=white]
    watsonpi [shape=box style=filled color="%2324B643" fontcolor=white]
  }
)

* **ui** - the user interface source is under [src/main/webapp](src/main/webapp).
It is a [simple html](src/main/webapp/index.html) page using Bootstrap, Handlerbars and jQuery.
[app.js](src/main/webapp/js/app.js) holds the code to interface the ui with the backend.

* **liberty** - the backend exposes one resource through REST, [PIResource](src/main/java/com/bluemix/tutorial/liberty/PIResource.java).
It implements GET/PUT/DELETE actions to manage [PIEntry](src/main/java/com/bluemix/tutorial/PIEntry.java).
It reads/writes from the database through [PIEntryRepository](src/main/java/com/bluemix/tutorial/PIEntryRepository.java) with
the database connector obtained from [Database](src/main/java/com/bluemix/tutorial/Database.java).
When a new text is submitted (through PUT), it calls Watson Personality Insights
and persists the results in the database.

---

Proceed to the [next step](002-LIBERTY.md).