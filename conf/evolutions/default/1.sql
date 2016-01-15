# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table client (
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
  rib                       varchar(255),
  rating                    integer,
  nb_incidents              integer,
  constraint uq_client_email unique (email),
  constraint uq_client_rib unique (rib),
  constraint pk_client primary key (client_id))
;

create table promotion (
  promotion_id              bigint not null,
  client_id                 bigint not null,
  remise                    integer not null,
  constraint pk_promotion primary key (promotion_id))
;

create sequence client_seq;

create sequence promotion_seq;




# --- !Downs

drop table if exists client cascade;

drop table if exists promotion cascade;

drop sequence if exists client_seq;

drop sequence if exists promotion_seq;

