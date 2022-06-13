# Call-A-Cab System

## Description
- The Call-A-Cab System provides a console interface for the user to interact, allowing they to book either one or more cabs for various trips.
- This project uses a DBMS to store and manage its data, that's because of the large query combinations we can use.

## Application execution requirements
### Database Creation
- Before running *please* in your mySQL server run the [Initialize_DB.sql](assets/Database_configuration/Initialize_DB.sql) file located in the directory [Database_configuration](assets/Database_configuration)
- Now *please* in the [DataBase](src/Model/DataBase.java) class, update the `loginUser()` method with your user login information.
- And you are good to go.

### Interface interaction
- Please while typing your location or destination in the interface don't use spaces because the program does not support it.
  - Correct way to insert data:
    - Location: Street_Oquendo
    - Destination: Street_Aroma
  - Incorrect:
    - Location: Street Oquendo
    - Destination: Street Aroma

## Extra Features
#### Post trip reservation
- Traveling animation.
- Give the conductor a tip interaction.
- Write your opinion about the travel feature.
#### Database Implementation
- A mySQL DBMS.

## Authors
Made with love by:
- Salet Yasmin Gutierrez Nava
- Elvis Jose Castro Huanca
- Emanuel Javier Galindo Corpa
- Carlos Antonio Ballester Paniagua
- Gabriel Santiago Concha Saavedra
