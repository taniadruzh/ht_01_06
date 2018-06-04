CREATE TABLE public."4_client"
(
    id integer DEFAULT nextval('"4_client_id_seq"'::regclass) PRIMARY KEY NOT NULL,
    fio_client varchar(25)
);
