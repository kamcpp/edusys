
SET search_path = messaging, pg_catalog;

CREATE SEQUENCE message_template_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

CREATE SEQUENCE send_request_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

CREATE TABLE message_template (
	id bigint DEFAULT nextval('message_template_id_seq'::regclass) NOT NULL,
	description character varying(20480),
	name character varying(5120) NOT NULL,
	submit_date_time bigint NOT NULL,
	text character varying(20480) NOT NULL,
	type integer NOT NULL,
	owner_person_id bigint NOT NULL
);

CREATE TABLE send_request (
	id bigint DEFAULT nextval('send_request_id_seq'::regclass) NOT NULL,
	description character varying(20480),
	name character varying(5120) NOT NULL,
	number_of_delivered_sendlist_items integer NOT NULL,
	number_of_sendlist_items integer NOT NULL,
	submit_date_time bigint NOT NULL,
	owner_person_id bigint NOT NULL
);

ALTER TABLE sendlist
	ADD COLUMN send_request_id bigint NOT NULL;

ALTER TABLE message_template
	ADD CONSTRAINT message_template_pkey PRIMARY KEY (id);

ALTER TABLE send_request
	ADD CONSTRAINT send_request_pkey PRIMARY KEY (id);

ALTER TABLE message_template
	ADD CONSTRAINT fk41715b222a99445 FOREIGN KEY (owner_person_id) REFERENCES personnel.person(id);

ALTER TABLE send_request
	ADD CONSTRAINT fke33060d822a99445 FOREIGN KEY (owner_person_id) REFERENCES personnel.person(id);

ALTER TABLE sendlist
	ADD CONSTRAINT fk4a657c2663d5d7d6 FOREIGN KEY (send_request_id) REFERENCES send_request(id);
