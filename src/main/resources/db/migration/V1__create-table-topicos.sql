create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(100) not null,
    fechaCreacion varchar(50),
    status varchar(1),
    autor varchar(100),
    curso varchar(100),

    primary key(id)
);