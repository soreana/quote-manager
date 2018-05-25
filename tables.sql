DROP TABLE IF EXISTS public.verse;

CREATE TABLE public.verse
(
  verse_pk SERIAL PRIMARY KEY,
  first        VARCHAR(200)  NOT NULL,
  last        VARCHAR(200)  NOT NULL
);
