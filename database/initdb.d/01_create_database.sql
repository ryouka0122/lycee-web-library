
create table if not exists users (
  user_id int not null
  , user_name varchar(32) not null
  , password varchar(32) null
  , primary key(user_id)
);

create table if not exists authors (
  author_id int not null
  , author_name varchar(100) not null
  , primary key(author_id)
);

create table if not exists publishers (
  publisher_id int not null
  , publisher_name varchar(100) not null
  , primary key (publisher_id)
);

create table if not exists books (
  book_id int not null
  , book_name varchar(1000) not null
  , author_id int not null
  , publisher_id int not null
  , primary key (book_id)
);
