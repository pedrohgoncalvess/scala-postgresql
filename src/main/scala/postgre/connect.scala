package postgre

import slick.jdbc.PostgresProfile.api._

/* postgres variables are in src/main/resources/application.conf  */
object connect {
  val db = Database.forConfig("postgres")
}
