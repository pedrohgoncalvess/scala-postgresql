package postgre

import postgre.main.{insertAuthorTable, insertBookTable, readData}
import postgre.Data._
import DatabaseMigration.flyway

object migrations extends App{
    flyway.migrate()
    println("Migration was successfully.")

    listAuthors.foreach(author => insertAuthorTable(author))
    listBooks.foreach(book => insertBookTable(book))
    println("Inserts was successfully.")
}

object readata extends App {
    readData
}

