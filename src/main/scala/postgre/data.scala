package postgre

import java.time.LocalDate


/*books for insert in book table*/

object Data {

  /*BOOKS*/

  val nameOfTheWild = Book(
    id = 2L,
    book_name = "The name of the wild",
    id_author = 1L,
    release_date = LocalDate.of(2012, 4, 15),
    length_page = 625,
    style = "Physical"

  )

  val wiseManFear = Book(
    id = 1L,
    book_name = "The wise man's fear",
    id_author = 1L,
    release_date = LocalDate.of(2008, 4, 15),
    length_page = 936,
    style = "E-book"
  )

  val animalFarm = Book(
    id = 3L,
    book_name = "Animal Farm",
    id_author = 2L,
    release_date = LocalDate.of(1945,8,17),
    length_page = 112,
    style = "Physical"
  )


  /*AUTHORS */
  val patrickRothfuss = Author(
    id = 1L,
    author_name = "Patrick Rothfuss"
  )

  val georgeOrwell = Author(
    id = 2L,
    author_name = "George Orwell"
  )

  val listAuthors = List(patrickRothfuss,georgeOrwell)
  val listBooks = List(nameOfTheWild,wiseManFear,animalFarm)

}
