<div align="center">
<h1>Connection and migrations on PostgreSQL with Slick and Flyway</h1>

<p>Unfortunately Java and Scala do not have ORM's or FRM's that make """migrations of tables""" from classes in code to objects in the database. For this reason in this repository I will use 2 dependencies, Slick for data and query migrations and Flyway for table migrations</p>

</div>

<h2 align='center'>Running</h2>

<p>Open project in root directory and run this command in terminal:</p>

```
sbt update
```

<p>This command downloads all dependencies in build.sbt in the root of the project and allows you to run the file through the terminal, note that if you are using Intelij IDE, you can run the code without having to run anything in the terminal.</p>

<i><p>Whenever it appears <b>Create a new server? y/n (default y)</b> you must press enter.</p></i>

<p>Finally you must run:</p>

```
sbt run
```

<p>This command runs the main file at src\main\scala\postgre\main.scala.</p>

<p align="center"> - </p>


<h3 align='center'>Migrations</h3>

> Why not Slick migration API?:
> <b>I don't like.</b>
<p>In the <b>build.sbt</b> file, the dependencie responsible for migrations is:</p>

```
"org.flywaydb" % "flyway-core" % "7.14.0"
```

- <h4>Dirs and files</h4>

<p>In the <i>src/main/scala/db.migration</i> <b>(it is necessary to work)</b> dir we have a .sql scripts responsibles for building the database.
they should follow the pattern of starting the filename with V{version number}__{filename}.sql.
</p>

> Ex. V1__build_data_base.sql

<p>
<i>The versions are useful for banks that are already consolidated and that don't usually need to be built.</i>
</p>

<p>
In the <i>src/main/scala/postgre.scala/migrations</i> we have a short code. First:
</p>

```
val flyway = Flyway.configure.dataSource("jdbc:postgresql://localhost:5433/postgres", "postgres", "admin").load()
flyway.migrate()
```

<p>
Val flyway is the database connection, this could be done in another way, how is the connection to manipulate the data with the login information in application.conf.
</p>

<p>
Val flyway now contains Flyway methods, 
then, with all the settings done, we run the migrations with flyway.migrate().
</p>
