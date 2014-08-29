
CREATE SCHEMA cms;

SET search_path = cms, pg_catalog;

CREATE TABLE "class" (
	id bigint NOT NULL,
	name character varying(5120) NOT NULL,
	cms_group_id bigint NOT NULL
);

CREATE TABLE department (
	id bigint NOT NULL,
	name character varying(5120) NOT NULL
);

CREATE TABLE general_reservation (
	id bigint NOT NULL,
	calculated_date bigint,
	"called" boolean NOT NULL,
	cancelled boolean,
	"date" character varying(5120) NOT NULL,
	description character varying(5120),
	email character varying(5120) NOT NULL,
	followed boolean,
	has_registered boolean,
	name character varying(5120) NOT NULL,
	not_answered boolean,
	phone character varying(5120) NOT NULL,
	seen boolean NOT NULL,
	sms_sent boolean NOT NULL,
	source character varying(20480),
	text character varying(5120) NOT NULL,
	will_inform_us boolean,
	will_register boolean,
	will_registered_with_conditions boolean,
	cms_class_id bigint NOT NULL
);

CREATE TABLE "group" (
	id bigint NOT NULL,
	name character varying(5120) NOT NULL,
	cms_department_id bigint NOT NULL
);

CREATE TABLE reservation (
	id bigint NOT NULL,
	calculated_date bigint,
	"date" character varying(5120) NOT NULL,
	email character varying(5120) NOT NULL,
	name character varying(5120) NOT NULL,
	phone character varying(5120) NOT NULL,
	text character varying(5120) NOT NULL,
	"time" character varying(5120) NOT NULL,
	cms_department_id bigint NOT NULL,
	cms_reservation_plan_id bigint NOT NULL
);

CREATE TABLE reservation_plan (
	id bigint NOT NULL,
	name character varying(5120) NOT NULL
);

ALTER TABLE "class"
	ADD CONSTRAINT class_pkey PRIMARY KEY (id);

ALTER TABLE department
	ADD CONSTRAINT department_pkey PRIMARY KEY (id);

ALTER TABLE general_reservation
	ADD CONSTRAINT general_reservation_pkey PRIMARY KEY (id);

ALTER TABLE "group"
	ADD CONSTRAINT group_pkey PRIMARY KEY (id);

ALTER TABLE reservation
	ADD CONSTRAINT reservation_pkey PRIMARY KEY (id);

ALTER TABLE reservation_plan
	ADD CONSTRAINT reservation_plan_pkey PRIMARY KEY (id);

ALTER TABLE "class"
	ADD CONSTRAINT fk5a5a97878dcb0f5 FOREIGN KEY (cms_group_id) REFERENCES "group"(id);

ALTER TABLE general_reservation
	ADD CONSTRAINT fkaa6c8ef583b8a255 FOREIGN KEY (cms_class_id) REFERENCES class(id);

ALTER TABLE "group"
	ADD CONSTRAINT fk5e0f67f6c5f9dbf FOREIGN KEY (cms_department_id) REFERENCES department(id);

ALTER TABLE reservation
	ADD CONSTRAINT fka2d543cc6c5f9dbf FOREIGN KEY (cms_department_id) REFERENCES department(id);

ALTER TABLE reservation
	ADD CONSTRAINT fka2d543ccb5528cc2 FOREIGN KEY (cms_reservation_plan_id) REFERENCES reservation_plan(id);

SET search_path = education, pg_catalog;

CREATE SEQUENCE term_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MAXVALUE
	NO MINVALUE
	CACHE 1;

CREATE TABLE term (
	id bigint DEFAULT nextval('term_id_seq'::regclass) NOT NULL,
	english_name character varying(5120) NOT NULL,
	persian_name character varying(5120) NOT NULL,
	institute_id bigint NOT NULL
);

ALTER TABLE department
	DROP COLUMN web_description,
	DROP COLUMN web_keywords,
	ADD COLUMN htmlcontent character varying(20480),
	ADD COLUMN seo_description character varying(20480),
	ADD COLUMN seo_keywords character varying(20480);

ALTER TABLE "group"
	ADD COLUMN htmlcontent character varying(20480),
	ADD COLUMN seo_description character varying(20480),
	ADD COLUMN seo_keywords character varying(20480),
	ADD COLUMN show_order integer NOT NULL;

ALTER TABLE term
	ADD CONSTRAINT term_pkey PRIMARY KEY (id);

ALTER TABLE term
	ADD CONSTRAINT fk36446c41f6f48b FOREIGN KEY (institute_id) REFERENCES institute(id);

SET search_path = messaging, pg_catalog;

ALTER TABLE todo_item
	ADD COLUMN response character varying(20480),
	ALTER COLUMN priority SET NOT NULL;

SET search_path = phonebook, pg_catalog;

ALTER TABLE phone_entry
	ADD COLUMN response character varying(20480),
	ALTER COLUMN color SET NOT NULL,
	ALTER COLUMN private_class SET NOT NULL,
	ALTER COLUMN registered SET NOT NULL,
	ALTER COLUMN seen SET NOT NULL,
	ALTER COLUMN should_be_followed SET NOT NULL;
