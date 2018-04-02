### opendbcopy

Under GPLv2

To run the program, 
- **git clone https://github.com/klDen/openDBcopy.git**
- **cd openDBcopy**
- **./gradlew deploy && ./gradlew run**

To migrate DB schema :

- Select Plugin -> Select New Plugin -> Migrate Database schema (DDL)

**Tab 0**
- Select your Database Dialect from the dropdown list (ex: MySQL5)
- Select your unique primary key generation algorithm (ex: identity for MySQL)

**Tab 1**
- Enter your Source & Destination Database connections 
- Press on Apply & Test for both connections to confirm

**Tab 2**
- Select the Catalog & Schema (ex: dbo)
- Optionally, you can select PK, FKI and Indexes if needed
- Press on Capture Source Model (a confirmation will be shown at the bottom left corner once completed)

**Tab 3**
- Select the Tables to migrate

**Tab 4**
- Select columns to migrate

**Tab 5**
- Execute!

From there, execute in the Terminal **./gradlew schemacreate** (your tables should be created if no errors were shown)

To copy data from a Source to Destination database :
- Select Plugin -> Select New Plugin -> Copy data from source into a destination database
- Follow the same steps as previously done!

