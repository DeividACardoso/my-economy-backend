-- Inserção na tabela despesa
INSERT INTO despesa (descricao, quantidade, referencia_mes, usuario_email)
VALUES ('Compra de supermercado', 200.50, '2024-06-01', 'user@example.com');

INSERT INTO limite_mensal (quantidade, referencia_mes, usuario_email)
VALUES (1000.00, '2024-06-01', 'user@example.com');

INSERT INTO usuario (id_despesa, id_limite_mensal, login, nome, password, dt_nascimento, role)
VALUES (
    1,
    1,
    'user@example.com',
    'Nome do Usuário',
    'senha123',  -- Exemplo de hash de senha
    '1990-01-01',
    'ADMIN'
);
