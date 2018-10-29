-- Table: public.item

-- DROP TABLE public.item;

CREATE TABLE public.item
(
    oid integer NOT NULL,
    descricao character varying(255) COLLATE pg_catalog."default",
    valor numeric(8,2),
    CONSTRAINT item_pkey PRIMARY KEY (oid)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.item
    OWNER to postgres;





-- Table: public.lancamento

-- DROP TABLE public.lancamento;

CREATE TABLE public.lancamento
(
    oid integer NOT NULL,
    dt_final timestamp without time zone,
    dt_inicial timestamp without time zone,
    observacao character varying(1000) COLLATE pg_catalog."default",
    vl_total numeric(8,2),
    CONSTRAINT lancamento_pkey PRIMARY KEY (oid)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.lancamento
    OWNER to postgres;





-- Table: public.lancamento_item

-- DROP TABLE public.lancamento_item;

CREATE TABLE public.lancamento_item
(
    lancamento_oid integer NOT NULL,
    listaitem_oid integer NOT NULL,

    CONSTRAINT fk_i9kba5mf3h1x13ap9fpfth3mm FOREIGN KEY (listaitem_oid)
        REFERENCES public.item (oid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_k9dukg34jvorcxmkj8deke719 FOREIGN KEY (lancamento_oid)
        REFERENCES public.lancamento (oid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.lancamento_item
    OWNER to postgres;