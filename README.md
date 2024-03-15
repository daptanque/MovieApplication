![image](https://github.com/daptanque/MovieApplication/assets/42044692/0b219176-8435-4e4a-98ab-21280806b690)

A) *Justify why you chose this codebase and do a little analysis from the architectural point of view.*

This project is a benchmark of excellence when it comes to code quality, architecture, and adoption of best development practices.

The project has the goal of showing the popular movies in IMDB. For that uses an API (TMDB) to get data, but also once it gets data it loads on Cache and on Room Database so for further use enables offline operability.

In terms of organization it's divided in Data, Domain and Presentation Layer.
- Presentation: to display the Activity (list of movies, load - progress bar -, refresh menu, image of the poster and text - title and description)
- Domain: to set the Repositories (to connect Data with Domain) and Use Cases to Get Movies and Update Movies
- Data: to set the Model, API Service Interface, DB/DAO, Data Source from Remote, Cache and Local

In terms of acquiring data follows the sequence Cache, RoomDB, API, to ensure acquisition through fastest approach just in last option uses API. 

Uses Dependecy Injection - Dagger - to avoid boilerplate share instances accross application ensuring Singleton design pattern, simplifies the provisioning of dependencies accross the app where those are needed.

Uses databinding to faster load information to user, live data to notify when data changes occur like new movie dataset.

Uses coroutine to run in background the save of movies on DB and clear all movies from DB.


B) *Identify improvement points of the indicated codebase.*

One improvement technically is the Bearer Token should have a parameter on BuildConfigurations.

Another point is Testing, Unit and Mock testing.

In term of usability an extra feature could be onClick on top of an item (movie) display a page only about the movie, with the poster image, title, description and trailer if available.
