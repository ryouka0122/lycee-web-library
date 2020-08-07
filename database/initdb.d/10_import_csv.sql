load data local infile '/datasets/authors.csv' into table authors fields terminated by ',' enclosed by '"' lines terminated by '\n' ignore 1 lines;
commit;

load data local infile '/datasets/publishers.csv' into table publishers fields terminated by ',' enclosed by '"' lines terminated by '\n' ignore 1 lines;
commit;

load data local infile '/datasets/books.csv' into table books fields terminated by ',' enclosed by '"' lines terminated by '\n' ignore 1 lines;
commit;

load data local infile '/datasets/users.csv' into table users fields terminated by ',' enclosed by '"' lines terminated by '\n' ignore 1 lines;
commit;
