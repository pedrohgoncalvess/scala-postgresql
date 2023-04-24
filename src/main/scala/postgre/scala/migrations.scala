package postgre.scala

import org.flywaydb.core.Flyway

object DatabaseMigration extends App{
  val flyway = Flyway.configure.dataSource("jdbc:postgresql://localhost:5433/postgres", "postgres", "admin").load()
  flyway.migrate()
  }