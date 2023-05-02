package postgre

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
           length_page:Int,
           style:String
               )

case class Author(
                 id:Long,
                 author_name:String
                 )

object SlickTables {

  import slick.jdbc.PostgresProfile.api._

   class BookTable(tag: Tag) extends Table[Book]/*subclass Table*/(tag, Some("library") /*<-schema name*/,"book" /*<-table name*/) {
     def id = column[Long]("id",O.PrimaryKey,O.AutoInc)
     def name = column[String]("book_name")
     def id_author = column[Long]("id_author")
     def release_date = column[LocalDate]("release_date")
     def length_page = column[Int]("length_pages")
     def style = column[String]("style")

     // overriding '*' default method of Table subclass which maps table columns in scala classes
     override def * = (id,name,id_author,release_date, length_page, style) <> (Book.tupled,Book.unapply)
   }

  //API entry point
  lazy val bookTable = TableQuery[BookTable]

  class AuthorTable(tag: Tag) extends Table[Author](tag, Some("library"),"author") {
    def id = column[Long]("id",O.PrimaryKey,O.AutoInc)
    def author_name = column[String]("author_name")

    override def * = (id,author_name) <> (Author.tupled,Author.unapply)
  }

  lazy val authorTable = TableQuery[AuthorTable]
}
