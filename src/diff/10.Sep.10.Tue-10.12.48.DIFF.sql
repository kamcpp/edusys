
SET search_path = phonebook, pg_catalog;

ALTER TABLE phone_entry
	ADD COLUMN response character varying(20480),
	ALTER COLUMN seen SET NOT NULL,
	ALTER COLUMN submit_date DROP NOT NULL;
