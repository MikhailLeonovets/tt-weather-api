# tt-weather-api
* [Project Description](#project-description)
* [Technologies used](#project-technologies)
* [DB Scheme](#db-scheme)
* [DB init](#db-init)

# Project Description
System which monitoring weather in needed location and able to send last updated weather state, and 

# Technologies used
* Spring, Spring Boot, Spring Data JPA
* PostgreSQL
* Slf4j
* JUnit 5, Mockito

# DB Scheme
![image](https://user-images.githubusercontent.com/62715846/149124824-99e2385c-7df8-42a8-80c9-ea2c1e10affb.png)
![image](https://user-images.githubusercontent.com/62715846/149124854-a4287da2-d8e0-4f23-a40d-e65244760db5.png)

# DB init
1. To start your application you should create database with name 'tt_weather_api_db'.
2. After creating the database run sql script (db_tables_generation_script.sql) which creates all needed tables in it.
