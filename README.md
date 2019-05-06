# DatabasesFinal
By Alexis Hale and Jacob Curley

# Set up database 
To set up the database, edit the "Insert.java" file to have DB_URL set to your database's URL, and update the USERNAME and PASSWORD variables to be accurate for your database as well. Also add the mysql-connector jar file to your classpath or project dependencies, or install your own version of mysql connector for JDBC. Update the DRIVER variable in Insert.java if you do the latter.

Run the CreateDatabase.sql statements for your MySQL database. 

Compile and run Insert.java either in command line or in your IDE. Make sure the .csv files are in the same directory that the java class file runs in. 

The test-sample.sql statements can be run on your database to see some of the things our database can return.

# Run front end
First, have python installed. Install Django as well. Create project location in a folder labeled "Dev". Edit settings.py file and make sure engine is set to MySQL, enter name of database, username, and password. Make sure MySQL port setting on this page is 3306. Navigate to folder with manage.py in terminal or virtual environment and run "python manage.py startserver", then "python manage.py makemigrations", then "python manage.py migrate" if no errors arise from the previous command. Now go to a browser and put "localhost:8000" as the URL and hit enter. Be sure it is accessing port 8000, not 8080. Now naviagte through the website in your browser as you would any other website.
