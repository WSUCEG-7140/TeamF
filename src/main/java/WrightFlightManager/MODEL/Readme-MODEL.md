# MODEL Folder

## Contents
- The MODEL folder should contain the code for the classes that model the database tables as object
- Each attribute in a table should be a private field in the class with a getter/setter
- If an attribute is a primary key (underlined in the schema), it only needs a getter and does not need a setter
- Additionally, if a class is marked as "NOT NULL" in the SQL script, it must be a parameter in the class's constructor, since it cannot be added to the database without that parameter