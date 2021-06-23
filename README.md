Uma agência de banco de sangue forneceu uma lista de candidatos a doadores e precisa de um sistema que processe esses dados para extrair algumas informações. 

Sistema web sistema web que receba um JSON com os dados e mostre os seguintes resultados:<br>
- Quantos candidatos temos nessa lista em cada estado do Brasil? <br>
- IMC médio em cada faixa de idade de dez em dez anos: 0 a 10; 11 a 20; 21 a 30, etc. (IMC = peso / altura^2) <br>
- Qual o percentual de obesos entre os homens e entre as mulheres? (É obeso quem tem IMC >30)<br>
- Qual a média de idade para cada tipo sanguíneo?<br>
- A quantidade de possíveis doadores para cada tipo sanguíneo receptor.<br>
---------------------------------------------------------------------------------------------------------------------------

<strong>PASSOS NECESSÁRIO PARA EXECUÇÃO DO MESMO:</strong><br>
1-BAIXAR OU CLONAR O PROJETO<br>
2-IMPORTAR O PROJETO NO SEU WORKSPACE SPRING<br>
3-INICIALIZAR O MYSQL LOCALMENTE (UTILIZANDO O XAMPP, WAMPP OU ALGUM PROGRAMA SIMILAR)<br>
4-EXECUTAR O SISTEMA<br>

---------------------------------------------------------------------------------------------------------------------------

<strong>INFORMAÇÕES IMPORTANTES:</strong><br>
- <strong>USUÁRIO PADRÃO DO SISTEMA (SERÁ CRIADO JUNTAMENTE COM A EXECUÇÃO DO PROJETO)</strong><br>
	<strong>Usuário</strong>: admin@admin.com<br>
	<strong>Senha</strong>: admin<br><br>
- <strong>DADOS PARA CONEXÃO DO BANCO DE DADOS</strong> <br>
	url: localhost:3306/wk?createDatabaseIfNotExist=true&useSSL=false<br>
	username: root<br>
	password:<br><br>
- <strong>OS DADOS DE CONEXÃO PODEM SER ALTERADOS NO ARQUIVO ‘src\main\resources\application.properties’</strong><br>

---------------------------------------------------------------------------------------------------------------------------

<strong>ROTEIRO</strong>:<br>
<strong>1)HOME</strong> <br>
Tela destinado para fazer o import do arquivo data.json <br>
Apresenta o primeiro relatório do sistema, mostrando quantos candidatos foram cadastrados, sendo este dividido por estado<br>

<strong>2)CANDIDATOS</strong><br>
Tela destinada para listar todos os candidatos salvos no banco de dados.<br>
Apresenta alguns campos para fazer pesquisas dentre os dados apresentados<br>

<strong>3)RELATÓRIOS</strong><br>
Tela destinada para apresentar os restantes do relatórios<br>
Relatório de Obesidade: O percentual de obesos entre os homens e entre as mulheres. (É obeso quem tem IMC >30)<br>
Relatório de IMC Médio por idade: IMC médio em cada faixa de idade de dez em dez anos: 0 a 10; 11 a 20; 21 a 30, etc. (IMC = peso / altura^2)<br>
Relatório de Média de Idade por tipo sanguíneo: média de idade para cada tipo sanguíneo.<br>
Relatório de Possíveis Doadores por tipo sanguíneo: A quantidade de possíveis doadores para cada tipo sanguíneo receptor<br>

---------------------------------------------------------------------------------------------------------------------------

<strong>PADRÃO DO ARQUIVO JSON</strong><br>
[<br>
	{<br>
		"nome": "Doadora Teste 1",<br>
		"cpf": "111.111.111-11",<br>
		"rg": "44.084.541-5",<br>
		"data_nasc": "23\/05\/1964",<br>
		"sexo": "Feminino",<br>
		"mae": "Mãe do Fulano",<br>
		"pai": "Pai do Fulano",<br>
		"email": "email@teste.teste",<br>
		"cep": "39801-678",<br>
		"endereco": "Rua Kurt W. Rothe",<br>
		"numero": 675,<br>
		"bairro": "Castro Pires",<br>
		"cidade": "Teófilo Otoni",<br>
		"estado": "MG",<br>
		"telefone_fixo": "(33) 1111-1111",<br>
		"celular": "(33) 1111-11111",<br>
		"altura": 1.53,<br>
		"peso": 80,<br>
		"tipo_sanguineo": "O-"<br>
	}<br>
]<br>
