
SET search_path = cms, pg_catalog;

ALTER TABLE reservation
	ALTER COLUMN description TYPE character varying(5120) /* TYPE change - table: reservation original: character varying(10240) new: character varying(5120) */,
	ALTER COLUMN source TYPE character varying(20480) /* TYPE change - table: reservation original: character varying(10240) new: character varying(20480) */;

SET search_path = messaging, pg_catalog;

ALTER TABLE sendlist
	ADD COLUMN ref_id character varying(5120);
