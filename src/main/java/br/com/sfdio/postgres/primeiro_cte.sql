WITH tb_tmp_banco AS (
	SELECT numero,nome FROM banco
)

SELECT numero, nome FROM tb_tmp_banco;

WITH tb_tmp_params AS (
	SELECT 213 AS banco_numero
), tb_tmp_banco AS (
	SELECT 
		numero, nome 
	FROM 
		banco AS b 
		JOIN tb_tmp_params as ttp ON ttp.banco_numero = b.numero
)

SELECT * FROM tb_tmp_banco