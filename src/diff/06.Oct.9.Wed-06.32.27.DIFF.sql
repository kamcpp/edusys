
SET search_path = cms, pg_catalog;

ALTER TABLE reservation
	ADD COLUMN "called" boolean NOT NULL,
	ADD COLUMN cancelled boolean,
	ADD COLUMN followed boolean,
	ADD COLUMN has_registered boolean,
	ADD COLUMN not_answered boolean,
	ADD COLUMN seen boolean NOT NULL,
	ADD COLUMN sms_sent boolean NOT NULL,
	ADD COLUMN will_inform_us boolean,
	ADD COLUMN will_register boolean,
	ADD COLUMN will_registered_with_conditions boolean;

SET search_path = education, pg_catalog;

CREATE SEQUENCE term_id_seq1
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

ALTER TABLE term
	ALTER COLUMN id SET DEFAULT nextval('term_id_seq1'::regclass);

SET search_path = messaging, pg_catalog;

CREATE SEQUENCE message_template_id_seq1
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

CREATE SEQUENCE send_request_id_seq1
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

CREATE SEQUENCE sendlist_id_seq1
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

CREATE TABLE todo_item_attachement (
	id bigint NOT NULL,
	"data" bytea,
	length integer NOT NULL,
	name character varying(5120) NOT NULL,
	submit_datetime bigint NOT NULL,
	todo_item_id bigint NOT NULL
);

ALTER TABLE message_template
	ALTER COLUMN id SET DEFAULT nextval('message_template_id_seq1'::regclass);

ALTER TABLE send_request
	ALTER COLUMN id SET DEFAULT nextval('send_request_id_seq1'::regclass);

ALTER TABLE sendlist
	ALTER COLUMN id SET DEFAULT nextval('sendlist_id_seq1'::regclass);

ALTER TABLE todo_item_attachement
	ADD CONSTRAINT todo_item_attachement_pkey PRIMARY KEY (id);

ALTER TABLE todo_item_attachement
	ADD CONSTRAINT fk3a5133cb2cb465a FOREIGN KEY (todo_item_id) REFERENCES todo_item(id);
