DESCRIÇÃO: Uma agência de banco de sangue forneceu uma lista de candidatos a doadores e precisa de um sistema que processe esses dados para extrair algumas informações. 

Sistema web sistema web que receba um JSON com os dados e mostre os seguintes resultados: 
Quantos candidatos temos nessa lista em cada estado do Brasil? 
IMC médio em cada faixa de idade de dez em dez anos: 0 a 10; 11 a 20; 21 a 30, etc. (IMC = peso / altura^2) 
Qual o percentual de obesos entre os homens e entre as mulheres? (É obeso quem tem IMC >30)
Qual a média de idade para cada tipo sanguíneo? 
A quantidade de possíveis doadores para cada tipo sanguíneo receptor.
---------------------------------------------------------------------------------------------------------------------------

PASSOS NECESSÁRIO PARA EXECUÇÃO DO MESMO:
1-BAIXAR O PROJETO
2-IMPORTAR O PROJETO NO SEU WORKSPACE SPRING
3-INICIALIZAR O MYSQL LOCALMENTE (UTILIZANDO O XAMPP OU ALGUM PROGRAMA SIMILAR)

---------------------------------------------------------------------------------------------------------------------------

INFORMAÇÕES IMPORTANTES:
-USUÁRIO PADRÃO DO SISTEMA (SERÁ CRIADO JUNTAMENTE COM A EXECUÇÃO DO PROJETO)
	Usuário: admin@admin.com
	Senha: admin
- DADOS PARA CONEXÃO DO BANCO DE DADOS 
	url: localhost:3306/wk?createDatabaseIfNotExist=true&useSSL=false
	username: root
	password:
- OS DADOS DE CONEXÃO PODEM SER ALTERADOS NO ARQUIVO ‘src\main\resources\application.properties’

---------------------------------------------------------------------------------------------------------------------------

ROTEIRO:
1)HOME 
Tela destinado para fazer o import do arquivo data.json 
Apresenta o primeiro relatório do sistema, mostrando quantos candidatos foram cadastrados, sendo este dividido por estado

2)CANDIDATOS
Tela destinada para listar todos os candidatos salvos no banco de dados.
Apresenta alguns campos para fazer pesquisas dentre os dados apresentados

3)RELATÓRIOS
Tela destinada para apresentar os restantes do relatórios
Relatório de Obesidade: O percentual de obesos entre os homens e entre as mulheres. (É obeso quem tem IMC >30)
Relatório de IMC Médio por idade: IMC médio em cada faixa de idade de dez em dez anos: 0 a 10; 11 a 20; 21 a 30, etc. (IMC = peso / altura^2)
Relatório de Média de Idade por tipo sanguíneo: média de idade para cada tipo sanguíneo.
Relatório de Possíveis Doadores por tipo sanguíneo: A quantidade de possíveis doadores para cada tipo sanguíneo receptor


