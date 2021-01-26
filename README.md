# bbyGrocery
bby_project

Project Tasks:

You have been tasked with building an application for a local grocery store .The store needs to manage the inventory and price of all items. The requirements are:

The app should be built with Spring Boot
Each item in the inventory should include the following attributes – name, inventory amount, price.

The following functionality should be exposed via RESTful APIs

Get a specific item
Get N number of items (set by query parameter, max/default 100 items will be returned)

Create a new item
Updated an item (like inventory amount or price change) 
Delete an item

Items can be stored in a Java data structure. No need to integrate and save them to a database. The items don’t need to be persisted after the application stops running. 
We’ll assume that the number of inventory items will be relatively small, so we don’t need to worry about searching performance.
Tests should be included with your code.
All code should be available for review in a git repository of your choosing. Include documentation on how to run the app


 -------------------------------- -------------------------------- -------------------------------- -------------------------------- -------------------------------- -------------------------------- 
 
 
Testing:

I tried to apply all the questions with answers an examples of how to replicate locally on Postman 

HTTP METHOD


Get a specific item - 

	GET localhost:8080/products/1

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Get N number of items(set by query parameter, max/default 100 items will be returned) - PAGINATION - HAVE TO WORK ON THIS

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Create a new item- 

	POST localhost:8080/products/  

* Body -
{
    "name": "Orange",
    "quantity": 10,
    "price": 3.3
}

	GET localhost:8080/products/4

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Update an item - 

	PUT localhost:8080/products/4 
	
* Body -

{
    "id": 3,
    "name": "Pomegranate",
    "quantity": 20,
    "price": 3.5
}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Delete an item - 

	DELETE localhost:8080/products/4

localhost:8080/products
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



Steps to replicate/how I built this.

1. Start.spring.io
	a. Maven Project on Java 8, Jar packaging
	
	b. Added dependencies specific to what I thought this would need (Spring WEB for RESTful connection and Tomcat, Spring Data JPA for JPA api, and H2 Database for in-memory JDBC api support)
	
  c. I ended up with a lot of boilerplate from a rest guide, but it was old so I needed to add new dependencies apart from the spring starter like jakarta and jaxb to deal since these were deprecated in java 9 and later
  
  d. I also ran into the issue of many of the versions that should work together not working, so ended up setting the parents version and taking away the rest for the spring boot dependencies
  
2. Development 
  a. Had to re-learn which annotations to use, it's been a while
  
  b. Created Product class with name quantity and price as requested, I kept id as I like the unique identifier especially when calling api, keeps it simple
    b1. create getters/setters (would've been easier if using lombok as I later learned) 
    b2. set return string for product call
    
  c. Created Repo using jpa repository to use for products 
     c1. had to create class to pre-load data into the database using bean and repository calls
     c2. add application.properties file for h2 path and datasource url/user/pass
     
  d. Create Controller for get/post mapping for api calls
     d1. allows us to call the api and create new products, remove old ones, edit/update as well all in api body
     d2. create method for querying based on a set query parameter, max/default 100 items to be returned.
        d2a. still looking at this pagination turns out to be a harder topic to apply than to understand, but if I can't get it I'm hoping you guys can help!
