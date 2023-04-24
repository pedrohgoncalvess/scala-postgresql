<div align="center">
<h1>Connection and migrations on PostgreSQL with Slick and Flyway</h1>

<p>Unfortunately Java and Scala do not have ORM's or FRM's that make """migrations of tables""" from classes in code to objects in the database. For this reason in this repository I will use 2 dependencies, Slick for data and query migrations and Flyway for table migrations</p>

</div>

> Why not Slick migration API?:
> <b>I don't like.</b>



<div align="center">

<h2>Migrations</h2>
</div>
<p>In the <b>build.sbt</b> file, the dependencie responsible for migrations is:</p>

```
"org.flywaydb" % "flyway-core" % "7.14.0"
```

<p>In the <i>src/main/scala/db.migration</i> dir we have a .sql scripts responsibles for building the database</p>
<p></p>
