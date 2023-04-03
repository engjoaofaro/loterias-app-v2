# loterias-app-v2
Versão 2 do app de simulações de jogos da Loteria (Mega-Sena, Lotofácil, Lotomania).

# IMPORTANTE - Configuração de ambiente
Para testar com o acompanhamento dos resultados por e-mail será necessário configurar as 
credenciais da AWS de sua conta (AWS_ACCESS_KEY_ID, AWS_SECRET_KEY) assim como a variável 
de Url da fila SQS (QUEUE_URL).

Execução: java -jar loterias-app-v2-jar-with-dependencies.jar

# Arquitetura
![arquitetura](images/loterias-app-aws-architecture.png)

## License

[MIT](https://opensource.org/licenses/MIT)
