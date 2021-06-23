Uma agência de banco de sangue forneceu uma lista de candidatos a doadores e precisa de um sistema que processe esses dados para extrair algumas informações. 

Sistema web sistema web que receba um JSON com os dados e mostre os seguintes resultados:<br>
- Quantos candidatos temos nessa lista em cada estado do Brasil? <br>
- IMC médio em cada faixa de idade de dez em dez anos: 0 a 10; 11 a 20; 21 a 30, etc. (IMC = peso / altura^2) <br>
- Qual o percentual de obesos entre os homens e entre as mulheres? (É obeso quem tem IMC >30)<br>
- Qual a média de idade para cada tipo sanguíneo?<br>
- A quantidade de possíveis doadores para cada tipo sanguíneo receptor.<br>
---------------------------------------------------------------------------------------------------------------------------

PASSOS NECESSÁRIO PARA EXECUÇÃO DO MESMO:<br>
1-BAIXAR O PROJETO<br>
2-IMPORTAR O PROJETO NO SEU WORKSPACE SPRING<br>
3-INICIALIZAR O MYSQL LOCALMENTE (UTILIZANDO O XAMPP OU ALGUM PROGRAMA SIMILAR)<br>

---------------------------------------------------------------------------------------------------------------------------

INFORMAÇÕES IMPORTANTES:<br>
USUÁRIO PADRÃO DO SISTEMA (SERÁ CRIADO JUNTAMENTE COM A EXECUÇÃO DO PROJETO)<br>
	<br>
	<strong>Usuário</strong>: admin@admin.com<br>
	<strong>Senha</strong>: admin<br>
- DADOS PARA CONEXÃO DO BANCO DE DADOS <br>
	url: localhost:3306/wk?createDatabaseIfNotExist=true&useSSL=false<br>
	username: root<br>
	password:<br>
- OS DADOS DE CONEXÃO PODEM SER ALTERADOS NO ARQUIVO ‘src\main\resources\application.properties’<br>

---------------------------------------------------------------------------------------------------------------------------

ROTEIRO:<br>
1)HOME <br>
Tela destinado para fazer o import do arquivo data.json <br>
Apresenta o primeiro relatório do sistema, mostrando quantos candidatos foram cadastrados, sendo este dividido por estado<br>

2)CANDIDATOS<br>
Tela destinada para listar todos os candidatos salvos no banco de dados.<br>
Apresenta alguns campos para fazer pesquisas dentre os dados apresentados<br>

3)RELATÓRIOS<br>
Tela destinada para apresentar os restantes do relatórios<br>
Relatório de Obesidade: O percentual de obesos entre os homens e entre as mulheres. (É obeso quem tem IMC >30)<br>
Relatório de IMC Médio por idade: IMC médio em cada faixa de idade de dez em dez anos: 0 a 10; 11 a 20; 21 a 30, etc. (IMC = peso / altura^2)<br>
Relatório de Média de Idade por tipo sanguíneo: média de idade para cada tipo sanguíneo.<br>
Relatório de Possíveis Doadores por tipo sanguíneo: A quantidade de possíveis doadores para cada tipo sanguíneo receptor<br>


