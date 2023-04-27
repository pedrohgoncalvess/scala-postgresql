package postgre

import java.time.LocalDate


/*books for insert in book table*/

object Data {

  val nameOfTheWild = Book(
    id = 2L,
    book_name = "The name of the wild",
    id_author = 1L,
    release_date = LocalDate.of(2012, 4, 15),
    length_in_pages = 625
  )

  val wiseManFear = Book(
    id = 1L,
    book_name = "The wise man's fear",
    id_author = 1L,
    release_date = LocalDate.of(2008, 4, 15),
    length_in_pages = 936
  )


}
