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
![photo_2023-03-22_23-13-48](https://user-images.githubusercontent.com/74506536/227030602-4f4d4048-e3a6-4db6-8312-7b2800d10b8b.jpg)

# DB init
1. To start your application you should create database with name 'tt_weather_api_db'.
2. After creating the database run sql script (db_tables_generation_script.sql) which creates all needed tables in it.
