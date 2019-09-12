The Teamspeak Bitmoji Viewer, is a server query tool, that finds the active users on a Teamspeak server,  
Then it checks a database to see if the user has associated their Teamspeak ID with their Bitmoji URL,  
If they have it displays their Bitmoji, if not it displays a blank Bitmoji,  
This system also includes a way for the user to associate their accounts if they haven't already.  
All data is stored on a mysql database.  
Currently the script is hosted on my Lightsail server, and can be seen by accessing this http://34.254.178.124/  
However due to Teamspeak's server flood protection,  
Sometimes the script will be inactive as the server blocks it's queries if too many are sent at once  

This upload includes, a database connection file, the main file, and a submitID file, and also the required libraries for Teamspeak.
This was built in PHP mainly, with a bit of javascript for the Teamspeak queries, and MYSQL for the database.
