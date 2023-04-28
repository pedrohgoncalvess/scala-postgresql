create schema library;

create table library.author(
                               id serial,
                               author_name varchar(100) not null unique,
                               primary key(id)
);

create table library.book (
                              id serial,
                              book_name varchar(100) not null unique,
                              book_author int not null,
                              release_date timestamp default(current_timestamp),
                              length_pages int not null,
                              primary key(id),
                              foreign key(book_author)
                                  references library.author(id)

);