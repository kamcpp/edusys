
SET search_path = phonebook, pg_catalog;

ALTER TABLE phone_entry
	ADD COLUMN response character varying(20480),
	ALTER COLUMN color SET NOT NULL,
	ALTER COLUMN private_class SET NOT NULL,
	ALTER COLUMN registered SET NOT NULL,
	ALTER COLUMN seen SET NOT NULL,
	ALTER COLUMN should_be_followed SET NOT NULL;
