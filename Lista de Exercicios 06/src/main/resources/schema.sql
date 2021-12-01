CREATE SCHEMA IF NOT EXISTS public;

CREATE SEQUENCE IF NOT EXISTS registration_seq START 100000;

CREATE TABLE IF NOT EXISTS employee (
	id INT GENERATED ALWAYS AS IDENTITY,
  	registration INT UNIQUE DEFAULT nextval('registration_seq'), 
  	name VARCHAR(60) NOT NULL CHECK (name <> ''),
  	email TEXT NOT NULL CHECK (name <> ''),
  	cpf CHAR(11) NOT NULL UNIQUE,
  	phone VARCHAR(11) NOT NULL,
  
  	PRIMARY KEY(id)
);

CREATE INDEX IF NOT EXISTS phone_idx ON employee USING btree(phone);
CREATE INDEX IF NOT EXISTS email_idx ON employee USING btree(lower(email));
CREATE INDEX IF NOT EXISTS name_idx ON employee USING btree(lower(name));
