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