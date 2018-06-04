CREATE TABLE public."2_people"
(
    id integer DEFAULT nextval('"2_people_id_seq"'::regclass) PRIMARY KEY NOT NULL,
    fio varchar(30) NOT NULL
);
CREATE UNIQUE INDEX "2_people_id_uindex" ON public."2_people" (id);