package postgre

import java.util.concurrent.Executors
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success, Try}

object PrivateExecutionContext {
  val executor = Executors.newFixedThreadPool(4)
  implicit val ec: ExecutionContext = ExecutionContext.fromExecutorService(executor)
}

object main {

  import slick.jdbc.PostgresProfile.api._
  import PrivateExecutionContext._

  val wiseManFear:Book = Data.wiseManFear
  val nameOfTheWild:Book = Data.nameOfTheWild


  def insertBookTable(book:Book): Unit = {  /*insert tuple in book table*/
  val queryDescription = SlickTables.bookTable += book
  val futureId: Future[Int] = connect.db.run(queryDescription)
  futureId.onComplete {
    case Success(newMovieId) => println(s"Query was successful, new id is $newMovieId")
    case Failure(ex) => println(s"Query failed, reason: $ex")
    }
  }

  def readData: Unit = {
    val resultFuture: Future[Seq[Book]] = connect.db.run(SlickTables.bookTable.result)
    resultFuture.onComplete {
      case Success(movies) => println(s"Fetched: $movies")
      case Failure(ex) => println(s"Fetching failed: $ex")
    }
  }
}
