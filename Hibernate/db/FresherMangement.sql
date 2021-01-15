create database if not exists FresherManagement;
use FresherManagement;
create table if not exists identity_cards(
    identity_card_id int auto_increment not null,
    number varchar(20),
    name varchar(50),
    valid_date date,
    constraint pk_address primary key (identity_card_id)
);

create table if not exists freshers(
    fresher_id int auto_increment not null,
    name varchar(50),
    phone varchar(11),
    identity_card_id int,
    course_id int,
    constraint pk_fresher primary key (fresher_id)
);
create table if not exists courses(
    course_id int auto_increment not null,
    name varchar(50),
    teacher varchar(50),
    start_date datetime,
    end_date datetime,
    constraint pk_course primary key (course_id)
);

create table if not exists `groups`(
    group_id int auto_increment not null,
    name varchar(50),
    constraint pk_group primary key (group_id)
);

create table if not exists fresher_groups(
    fresher_id int,
    group_id int,
    constraint fresher_groups primary key (fresher_id, group_id)
);

-- constrain
alter table freshers add constraint fk_fresher_identity_card
    foreign key (identity_card_id) references identity_cards(identity_card_id);

alter table freshers add constraint fk_fresher_course
    foreign key (course_id) references courses(course_id);

alter table fresher_groups add constraint fk_fresher_group_fresher
    foreign key (fresher_id) references freshers(fresher_id);

alter table fresher_groups add constraint fk_fresher_group_group
    foreign key (group_id) references `groups`(group_id);


-- data
insert into identity_cards values
    (1, '28391283', 'Nguyen Tho Tuan', '2025-12-02'),
    (2, '23423434', 'Chau Xuan Tuan', '2025-10-21'),
    (3, '23423123', 'Hoang Minh Vu', '2026-03-17');

insert into courses values
    (1, 'Khoa hoc Java', 'Ho Tuan Thanh', '2021-12-02', '2021-12-30'),
    (2, 'Khoa hoc Hibernate', 'Truong Phuoc Loc', '2021-04-02', '2021-12-30'),
    (3, 'Khoa hoc NodeJs', 'Nguyen Huy Khanh', '2021-08-02', '2021-12-30');

insert into `groups` values
    (1, 'Group 1'),
    (2, 'Group 2');

insert into freshers values
    (1, 'Tho Tuan', '0909123423', 1, 1),
    (1, 'Xuan Tuan', '0909123423', 2, 1),
    (1, 'Minh Vu', '0909123423', 3, 3);

insert into fresher_groups values
    (1, 1),
    (1, 3),
    (1, 2),
    (2, 1),
    (2, 3),
    (3, 2);