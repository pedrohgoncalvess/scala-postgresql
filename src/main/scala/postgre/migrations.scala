package postgre

object DatabaseMigration{
  import org.flywaydb.core.Flyway
  val flyway = Flyway.configure.dataSource("jdbc:postgresql://localhost:5433/postgres", "postgres", "admin").load()
  }