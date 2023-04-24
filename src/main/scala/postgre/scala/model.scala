package postgre.scala

import java.time.LocalDate
import slick.lifted.Tag
import slick.jdbc.PostgresProfile
import slick.lifted.ProvenShape
//import slick.jdbc.PostgresProfile.api._
import play.api.libs.json._

case class Book(
           id:Long,
           book_name:String,
           id_author:Long,
           release_date:LocalDate,
           length_in_pages:Int
               )

object SlickTables {

  import slick.jdbc.PostgresProfile.api._

   class BookTable(tag: Tag) extends Table[Book](tag, Some("library") /*<-schema name*/,"book") {
     def id = column[Long]("id",O.PrimaryKey,O.AutoInc)
     def name = column[String]("book_name")
     def id_author = column[Long]("id_author")
     def release_date = column[LocalDate]("release_date")
     def lengthInPage = column[Int]("length_in_pages")

     //mapping function to the case class
     override def * = (id,name,id_author,release_date, lengthInPage) <> (Book.tupled,Book.unapply)
   }

  //API entry point
  lazy val bookTable = TableQuery[BookTable]
}