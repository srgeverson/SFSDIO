INSERT INTO public.banco (
numero, nome, ativo, data_criacao) VALUES (
'237'::integer, 'BRADESCO'::character varying, true::boolean, '2010-02-10'::timestamp without time zone)
 returning numero;
 INSERT INTO public.banco (
numero, nome, ativo, data_criacao) VALUES ('341', 'ITAÚ', true, '2010-02-10');
