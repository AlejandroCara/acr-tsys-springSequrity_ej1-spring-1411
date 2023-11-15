create table cientifico(
    dni varchar(8),
    nomapels varchar(255),
    primary key (dni)
);

create table proyecto(
    id char(4),
    nombre varchar(255),
    horas int,
    primary key (id)
);

create table asignado_a(
    id int auto_increment,
    dni_cientifico varchar(8),
    id_proyecto char(4),
    primary key (id),
    foreign key (dni_cientifico) references cientifico(dni)
    on delete cascade on update cascade,
    foreign key (id_proyecto) references proyecto(id)
    on delete cascade on update cascade
);

create table user(
    id long,
    firstName varchar(150),
    lastName varchar(150),
    email varchar(200),
    password varchar(250),
    roles varchar(250),
    primary key (id)
);
