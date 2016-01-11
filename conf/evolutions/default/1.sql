# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table adresse (
  rue                       bigint not null,
  ville                     varchar(255) not null,
  code_postal               integer not null,
  constraint uq_adresse_rue unique (rue))
;

create table clients (
  client_id                 bigint not null,
  nom                       varchar(255) not null,
  prenom                    varchar(255) not null,
  email                     varchar(255) not null,
  sexe                      varchar(255) not null,
  date_naissance            varchar(255) not null,
  idfidelite                bigint,
  id_rue                    varchar(255) not null,
  id_ville                  varchar(255) not null,
  id_code_postal            varchar(255) not null,
  magasin                   varchar(255) not null,
  typologie                 varchar(255),
  credit                    integer,
  typedemande               varchar(255),
  rib                       bigint,
  constraint uq_clients_email unique (email),
  constraint uq_clients_rib unique (rib),
  constraint pk_clients primary key (client_id))
;

create table user (
  user_id                   bigint not null,
  login                     varchar(255) not null,
  password                  varchar(255) not null,
  constraint uq_user_login unique (login),
  constraint pk_user primary key (user_id))
;

create sequence clients_seq;

create sequence user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists adresse;

drop table if exists clients;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists clients_seq;

drop sequence if exists user_seq;

