package postgre

import java.util.concurrent.Executors
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}


object PrivateExecutionContext {
  val executor = Executors.newFixedThreadPool(4)
  implicit val ec: ExecutionContext = ExecutionContext.fromExecutorService(executor)
}

object main {

  import slick.jdbc.PostgresProfile.api._
  import PrivateExecutionContext._

  def insertAuthorTable(author: Author, numTries:Int = 3): Future[Unit] = {

    val queryDescription = SlickTables.authorTable += author
    val futureId: Future[Int] = connect.db.run(queryDescription)
    futureId.flatMap { authorId =>
      println(s"Query was successful, new id is $authorId")
      Future.successful(())
    }.recoverWith {
      case ex: Throwable if numTries > 1 =>
        println(s"Query failed, reason: $ex")
        insertAuthorTable(author, numTries - 1)
      case ex: Throwable =>
        println(s"Query failed after $numTries tries, reason: $ex")
        Future.failed(ex)

    }
  }

  def insertBookTable(book: Book, numTries:Int = 3): Future[Unit] = {
    val queryDescription = SlickTables.bookTable += book
    val futureId: Future[Int] = connect.db.run(queryDescription)
    futureId.flatMap { bookId =>
      println(s"Query was successful, new id is $bookId")
      Future.successful(())
    }.recoverWith {
      case ex: Throwable if numTries > 1 =>
        println(s"Query failed, reason: $ex")
        insertBookTable(book)
      case ex: Throwable =>
        println(s"Query failed, number of tries: $numTries. Reason: $ex")
        Future.failed(ex)
    }
  }

  def readData: Unit = {

      println("Starting routine....")
    val resultFuture: Future[Seq[Book]] = connect.db.run(SlickTables.bookTable.result) /*select * from ___*/

    resultFuture.onComplete {
      case Success(books) =>
        //books.foreach(book => println(s"Book name: ${book.book_name}"))
        println(books)
      case Failure(ex) =>
        println(s"Query failed. Reason: $ex")
    }
  }
}
