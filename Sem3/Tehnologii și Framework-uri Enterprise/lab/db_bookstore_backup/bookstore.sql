-- Database: bookstore

-- DROP DATABASE bookstore;

CREATE DATABASE bookstore
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United Kingdom.1252'
    LC_CTYPE = 'English_United Kingdom.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Table: public.book

-- DROP TABLE public.book;

CREATE TABLE public.book
(
    id integer NOT NULL DEFAULT nextval('book_id_seq'::regclass),
    name text COLLATE pg_catalog."default",
    author text COLLATE pg_catalog."default",
    price double precision,
    yearofpublication text COLLATE pg_catalog."default",
    publisher text COLLATE pg_catalog."default",
    CONSTRAINT book_pk PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.book
    OWNER to postgres;

-- Index: book_id_uindex

-- DROP INDEX public.book_id_uindex;

CREATE UNIQUE INDEX book_id_uindex
    ON public.book USING btree
    (id)
    TABLESPACE pg_default;


-- Table: public.clients

-- DROP TABLE public.clients;

CREATE TABLE public.clients
(
    id integer NOT NULL DEFAULT nextval('client_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default",
    dateofregistration text COLLATE pg_catalog."default",
    CONSTRAINT client_pk PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.clients
    OWNER to postgres;

-- Table: public.purchase

-- DROP TABLE public.purchase;

CREATE TABLE public.purchase
(
    id integer NOT NULL DEFAULT nextval('purchase_id_seq'::regclass),
    clientid integer NOT NULL,
    bookid integer NOT NULL,
    total double precision NOT NULL,
    CONSTRAINT purchase_pk PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.purchase
    OWNER to postgres;

-- Index: purchase_id_uindex

-- DROP INDEX public.purchase_id_uindex;

CREATE UNIQUE INDEX purchase_id_uindex
    ON public.purchase USING btree
    (id)
    TABLESPACE pg_default;

