
SET search_path = messaging, pg_catalog;

CREATE SEQUENCE sendlist_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

CREATE TABLE sendlist (
	id bigint DEFAULT nextval('sendlist_id_seq'::regclass) NOT NULL,
	body character varying(20480),
	cancellation_reason character varying(20480),
	client_submit_date_time bigint NOT NULL,
	content_type integer NOT NULL,
	delivery integer NOT NULL,
	description character varying(20480),
	"from" character varying(5120),
	last_try_date_time bigint,
	number_of_tries integer NOT NULL,
	retry_reason character varying(20480),
	server_submit_date_time bigint NOT NULL,
	status integer NOT NULL,
	subject character varying(5120),
	"to" character varying(5120) NOT NULL,
	type integer NOT NULL,
	owner_person_id bigint NOT NULL
);

ALTER TABLE sendlist
	ADD CONSTRAINT sendlist_pkey PRIMARY KEY (id);

ALTER TABLE sendlist
	ADD CONSTRAINT fk4a657c2622a99445 FOREIGN KEY (owner_person_id) REFERENCES personnel.person(id);
