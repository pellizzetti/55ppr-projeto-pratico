-- Database: "55ppr"

-- DROP DATABASE "55ppr";

CREATE DATABASE "55ppr"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;

-- Table: public.customers

-- DROP TABLE public.customers;

CREATE TABLE public.customers
(
  customer_id serial,
  customer_firstname character varying(200),
  customer_lastname character varying(200),
  CONSTRAINT customers_pk PRIMARY KEY (customer_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.customers
  OWNER TO postgres;
  
-- Table: public.games

-- DROP TABLE public.games;

CREATE TABLE public.games
(
  game_id serial,
  game_title character varying(200),
  game_number_players integer,
  game_release_date date,
  game_format character varying(20),
  CONSTRAINT games_pk PRIMARY KEY (game_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.games
  OWNER TO postgres;
  
-- Table: public.movies

-- DROP TABLE public.movies;

CREATE TABLE public.movies
(
  movie_id serial,
  movie_title character varying(200),
  movie_synopsis text,
  movie_release_date date,
  movie_format character varying(20),
  CONSTRAINT movies_pk PRIMARY KEY (movie_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.movies
  OWNER TO postgres;