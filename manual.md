# **Documenta��o do Morpheus Language**


### Criadores 
```
Henrique Herrera (https://github.com/henriqueherrera)
Matheus Slama (https://github.com/Lokens)
Pablo Lodi (https://github.com/PabloLodi)
```

## **Usando o Morpheus** 
		       �����������������
1. Voc� deve possuir o Java Development Kit xxx instalado
2. Escreva o c�digo a ser interpretado no seu editor favorito e salve com a extens�o .mp
3. Compile utilizando o javac. 
4. Execute o Interpretador no terminal com o comando: java Morpheus (nome do seu arquivo).mp

��������
�����������������

## **Introdu��o a linguagem**
����������
�����������������

Morpheus � um interpretador compilado utilizando a Java Development Kit xxx e � utilizado no terminal com o comando:  		

```
����������������������������������������java Morpheus nomedoarquivo.mp 
```

Morpheus � uma linguagem com sintaxe flex�vel, podendo o usu�rio utilizar o espa�amento e a endenta��o desejada.
� poss�vel declarar vari�veis, atribuir valores a vari�veis, usar la�os dentro de la�os, dar comandos de entrada para o usu�rio, usar vetores e criar fun��es com escopo.
� necess�rio utilizar o ; (ponto e v�rgula) no final de cada linha. No caso de fun��es, la�os e condicionais, o uso no in�cio n�o � necess�rio. nesses casos utilizasse {} (chaves).

```����������
```

### **1. Coment�rios**
�������
Para fazer coment�rios no Morpheus utiliza-se // (duas barras juntas) no in�cio da linha. Desse modo, tudo que tiver escrito depois dela n�o ser� executado pelo interpretador.  
```����������
```
*Exemplo:*
```
	//linha de teste que n�o ser� executada
 �
	//print ("io")
	print("oi")
	
	tela:
	 oi
```
```����������
```
### **2. Tipos e operadores**
```����������
```
�������������������������**Tipos de vari�veis**

|**Tipo** |    **Descri��o**         | Exemplo     |
|---------|--------------------------|-------------|
|  int    | Inteiro de 32 bits       |  -1,0,1     |
| double  |N�mero com ponto flutuante|-0.59        |
|bool     |Booleano                  | true, false |
|string   |Sequ�ncia de caracteres   |�Hello World�|
|char     |Caractere �nico           |'z'          |

```����������
```
�������������������������**Sinais Aritim�ticos**


|**Operador**|**Opera��o** |
|------------|-------------|
|			+      | Adi��o      |
|			-			 | Subtra��o   |
|			/			 | Divis�o     |
|			*			 | Multplica��o|
|			%			 | Resto       |

```����������
```
�������������������������**Sinais de compara��es (condi��es)**

| **Sinal** |      **A��o**    							 |
|-----------|--------------------------------|
|			==		|Compara��o de valores iguais    |
|			!=		|Compara��o de valores diferentes|
|			>>		|				Maior										 |
|			>=		|		Maior ou igual							 |
|     <<		|  Menor												 |
|			<=		|  Menor ou igual								 |

```����������
```
�������������������������**Sinais Utilizados**

|**Sinal**|**Fun��o**         |
|---------|-------------------|
|//				|Coment�rio         |
| = 			|Atribui��o de Valor|



```����������
```
### **3.Declarar vari�veis**

A declara��o de vari�veis funciona na ordem �tipo nome = valor�, ou seja, primeiro deve ser escrito o tipo dela, seu nome (� obrigat�rio uma vari�vel de nome) e o valor a ser iniciado.
As vari�veis tamb�m podem ser declaradas sem nenhuma atribui��o de valor,
```����������
				
����������������������������������������tipo vari�vel = valor
����������
```

Se nenhum valor for atribu�do a vari�vel iniciar� com


|Valores iniciais|	      |             |
|----------------|------------|-------------|
|int = 0         |double = 0.0|string = null|
|bool = false    |char = ' '  |             |

```����������
```
*Certos nomes n�o podem ser usados como nome de vari�vel pois eles s�o reservados para o sistema. 


*Exemplo de declara��o de vari�vel:*

```����������

	Int numero = 10;
	double valor = 10.25;

	char a;
	a = �a�; 

	string frase;
	frase = �hello world�;

����������
```

### **4.Usando express�es**
```����������
```
No Morpheus realiza opera��es com n�meros, vari�veis e vetores.
*as opera�oes podem ser feitas com tipos diferente de primitivos, ex.: int e double

*Cada express�o deve ficar entre () (par�nteses) 
 
		
```
����������������������������������������Vari�vel = (((x+2) *0.5) + [3] vetor)
```	

```����������
```
### **5.Comandos de entrada**
```����������
```
O comando input () pode ser utilizado para adquirir um valor de entrada digitado pelo usu�rio.

```

���������������������������������������input (vari�vel)
���������������������������������������input (�frase�, vari�vel)

```
*Pode-se utilizar frases dentro do input que aparecer� para o usu�rio.

*Exemplo:*
```
	Int numero;	
	input(numero); 

	//com frase

	string nome;
	input (�digite seu nome�, nome);
```
```����������
```
### **6.Comandos de sa�da**
```����������
```
Usar o comando print () gera uma sa�da permite o usu�rio visualizar na tela.
```

���������������������������������������print ()
���������������������������������������print (�string�=>vari�vel=>[]vetor)

```
Exemplo:
```
	print (�Morpheus�);

	No terminal aparecer�:
	Morpheus
```
*Para utilizar vari�veis utiliza-se o =>

```
	print(�nome �=>a=>�sobrenome�=>b); 
	print(�idade �=>c);

	No terminal aparecer�:
	nome Morpheus Language 
	idade 1

```

```����������
```
### **7.Usando condicionais** 
```����������
```
Ao usar condicionais usamos {} (chaves) que estiver entre chaves ser� executado.
As condicionais s�o usadas igual se usa no Java. 
*As condicionais podem ser usadas com aninhamento (if dentro de ifs)   
*opera��es matem�ticas n�o podem ser usadas como condi��o
As condicionais S�o: 
```

���������������������������������������If condi��o {Instru��es para condi��o verdadeira}

```
Exemplo: 
```
	int a = 10;
	int b = 10;

	if a == b
	{
		print (�A � igual a B�);
	}

	Sa�da no terminal:
	A � igual a B
```
else if : Essa condi��o � usada igual ao if, quando h� v�rios comandos if use o else if que s� ser� executado se os outros ifs ou else ifs forem falsos, isso deixa o c�digo mais r�pido. 
```����������
����������������������������������������else If condi��o {Instru��es para condi��o verdadeira}
����������
```

*Exemplo:*

```
	int a = 10;
	int b = 20

	if a == b
	{
		print (�� Igual�);
	}

	else if a != b
	{
		print (�� diferente�);
	}


	Sa�da no terminal:
	� diferente 

```

else : Usado se a condi��o if ou a else if n�o for verdadeira o else ser� executado.
```

����������������������������������������else {Instru��es se os ifs e else if forem falsos}

```
```
	int a = 10;
	int b = 5

	if a <= b
	{
		print (�menor ou igual�);
		if a/2 != b  
	{
	print (�if dentro de if�)
	}
	}
	else if b >> a
	{
		print (�b � maior que a�);
	}
	else {
	 print (�nenhum dos ifs�) }
```


```����������
```
### **8.la�os de repeti��o**
```����������
```


No Morpheus usamos o while (), ent�o enquanto a condi��o dentro dos par�nteses for verdadeira o while ficar fazendo ciclos executando os c�digos dentro das {} (chaves). 
*� importante botar uma condi��o de parada ou o while ficar� executando para sempre ou at� usa memoria durar.

```
���������������������������������������while (condi��o de parada) {c�digo}
```

*Exemplo:* 
```
	Int a = 0;

	while (a < 3)
	{
		print (a);
		a=(a+1);
	} 
	
	Sa�da no terminal:
	0
	1
	2

```
```����������
```
### **9. Vetores**
```����������
```
Vetores s�o atribu�dos com [] (colchetes) um vetor poder ter v�rios valores dentro dele e podem ser acessados pelo �ndice.
Para criar um vetor voc� escreve: 
```

���������������������������������������vetor tipo do vetor | [quantidade de posi��es] vari�vel.

```
*Exemplo:*
```
	vetor int | [3] n�meros 

	//Atribuir valores: 
	[0] n�meros =10; 
	[1] n�meros = 20;
	[2] n�meros = 30;

```

*Pode usar, modificar, acrescentar quaisquer valores do tipo do vetor pelos �ndices.
 

```����������
```
### **10.Fun�oes** 
```����������
```
No Morpheus usamos fun��es 
def vari�vel (escopo) {c�digo return valor; },
vari�vel = call vari�vel da fun��o (escopo);

Escopo: ter o escopo preenchido n�o � obrigat�rio, para utiliz�-lo deve-se escrever o tipo e uma vari�vel, pode-se usar quantos valores quiser no escopo, os valores recebidos no escopo da fun��o poder�o ser usados na fun��o.

Return: � obrigat�rio utilizar o return na fun��o ele pode ser de qualquer tipo.
*deve ser escrita antes de sua chamada

```
	int a= 5; 
	int b=2; 
	def soma (int y,int x) 
	{ 
		int total; 
		total= (y+x); return total;
	}
	b = call soma(a,b); 
	print(b);


```