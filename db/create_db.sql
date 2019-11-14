CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE IF NOT EXISTS event (
    id uuid DEFAULT uuid_generate_v4(),
    title varchar NOT NULL,
    duration uuid NULL,
    location uuid NULL,
    description uuid NULL
);

CREATE TABLE IF NOT EXISTS duration (
    id uuid DEFAULT uuid_generate_v4(),
    from_date date NOT NULL,
    to_date date NOT NULL
);

CREATE TABLE IF NOT EXISTS description (
    id uuid DEFAULT uuid_generate_v4(),
    content varchar NULL,
    website varchar NULL,
    ticketInfo varchar NULL
);

CREATE TABLE IF NOT EXISTS address (
    id uuid DEFAULT uuid_generate_v4(),
    street varchar NULL,
    city varchar NULL,
    postCode varchar NULL
);

ALTER TABLE event
    ADD CONSTRAINT event_pkey PRIMARY KEY (id);

ALTER TABLE duration
    ADD CONSTRAINT duration_pkey PRIMARY KEY (id);

ALTER TABLE description
    ADD CONSTRAINT description_pkey PRIMARY KEY (id);
