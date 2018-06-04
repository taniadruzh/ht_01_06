CREATE TABLE public."4_service"
(
    id integer DEFAULT nextval('"4_service_id_seq"'::regclass) PRIMARY KEY NOT NULL,
    name_service varchar(25)
);
