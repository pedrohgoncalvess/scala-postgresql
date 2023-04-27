package postgre

import postgre.main.insertBookTable
import postgre.Data._

object exec extends App{
    DatabaseMigration.flyway.migrate()
    println("Migration was successfully.")

    insertBookTable(wiseManFear)
    insertBookTable(nameOfTheWild)
    println("Inserts was successfully.")

}
