import java.util.HashMap;

public class LePrimitivos extends Tools
{
	private OperadoresAritmeticos operacoes  = new OperadoresAritmeticos();

	private Int vetores;

	private Int inteiros;

	private Bool bool;

	private Strings string;

	private Condicional ifCondicional;

	private While lacoDeRepeticao;

	private Def def;

	private HashMap<String,Def> funcoes = new HashMap<String,Def>(); //armazena as funcoes

	private Char chars;

	private boolean controladorDeLaco = false;//quando true so passa pelo primeiro while

	private boolean controladorIf = false;

	private boolean controladorDef = false;

	private Doubles doubles;

	private String ifExpressao = "";

	private String expressao = "";

	private Comparadores troca;

	//inicio do método idLinha
	public void idLinha(String linha,int whilis)
	{
		linha.trim(); //tira a indentaçao
		troca = new Comparadores();

		if (controladorIf) //enquanto o controlador do If for true toda linha passará por aqui e será armazenado em um hashmap
		{
			linha.trim();

			if(this.tiraEspacos(linha).equals("{"))
			{
				ifCondicional.countAbreChave();
				ifCondicional.txtLines.put(ifCondicional.countLines(),linha);
			}

			else if(this.tiraEspacos(linha).equals("}") || this.tiraEspacos(linha).equals("}else"))
			{
				int aux1 = ifCondicional.countLines(); //numero as linhas do if
				ifCondicional.countFechaChave();
				if(this.tiraEspacos(linha).equals("}else") && ifCondicional.igualdadeDeChave())
				{
					ifCondicional.linhaDoElse = aux1; //pega a linha do else
				}
				ifCondicional.txtLines.put(aux1,linha);
			}

			else
			{
				ifCondicional.txtLines.put(ifCondicional.countLines(),linha);
			}

			if(ifCondicional.igualdadeDeChave() && !(this.tiraEspacos(linha).equals("}else")))
			{
				ifCondicional.condicionalIf(ifCondicional.getNumeroDeLinhas(), this.getIfExpressao());
				controladorIf = false;
			}
		}
		else if (controladorDeLaco) // enquanto for true toda linha passará por aqui e será armazenado em um hashmap
		{
			linha.trim();
			if(this.tiraEspacos(linha).equals("{"))
			{
				lacoDeRepeticao.countAbreChave();
				lacoDeRepeticao.txtLines.put(lacoDeRepeticao.countLines(),linha);
			}

			else if(this.tiraEspacos(linha).charAt(0) == '}')
			{
				lacoDeRepeticao.countFechaChave();
				lacoDeRepeticao.txtLines.put(lacoDeRepeticao.countLines(),linha);
			}

			else
			{
				lacoDeRepeticao.txtLines.put(lacoDeRepeticao.countLines(),linha);
			}
			if(lacoDeRepeticao.igualdadeDeChave() && !(this.tiraEspacos(linha).equals("}else")))
			{

				lacoDeRepeticao.laco(lacoDeRepeticao.getNumeroDeLinhas(), this.getExpressao());
				controladorDeLaco = false;
			}
		}
		else if (controladorDef) // enquanto for true toda linha passará por aqui e será armazenado em um hashmap
		{
			linha.trim();

			if(this.tiraEspacos(linha).equals("{"))
			{
				def.countAbreChave();
				def.txtLines.put(def.countLines(),linha);
			}

			else if(this.tiraEspacos(linha).charAt(0) == '}')
			{

				def.countFechaChave();
				def.txtLines.put(def.countLines(),linha);
			}

			else
			{
				def.txtLines.put(def.countLines(),linha);
			}

			if(def.igualdadeDeChave() && !(this.tiraEspacos(linha).equals("}else")))
			{
				controladorDef = false;
			}
		}

		else if(linha.contains("}") || linha.contains("{"))
		{
			//artificio tecnico para ignorar as chaves
		}

		else if (linha.substring(0,2).equals("if") || this.controladorIf)
		{
			ifCondicional = new Condicional();
			setIfExpressao(this.tiraEspacos(linha.substring(2,linha.length())+" "));
			this.controladorIf = true;
		}

		else if (linha.substring(0,3).equals("int"))
		{
			this.inteiros = new Int();
			if(linha.contains(";"))
			{
				inteiros.verificador(linha);
			}
			else
			{
				ErrosNaCompilacao.getLineError(0);
			}
		}

		else if (linha.substring(0,3).equals("def"))
		{
			String aux = this.tiraEspacos(linha);
			def = new Def();
			def.setEscopo(linha.substring(linha.indexOf("(")+1,linha.indexOf(")")));

			funcoes.put(aux.substring(3,aux.indexOf("(")),def);
			this.controladorDef = true;
		}


        else if (linha.substring(0,4).equals("char"))
		{
			this.chars = new Char();
			if(linha.contains(";"))
			{
			    chars.verificador(linha);
			}
			else
			{
				ErrosNaCompilacao.getLineError(0);
		    }
        }
		else if (linha.substring(0,4).equals("bool"))
		{
			this.bool = new Bool();
			if(linha.contains(";"))
			{
			    bool.verificador(linha);
			}
			else
			{
				ErrosNaCompilacao.getLineError(0);
		    }
		}
		else if (linha.substring(0,5).equals("print"))
		{
			this.print(this.tiraEspacos(linha));
		}

		else if (linha.substring(0,5).equals("vetor"))
		{
            if (!linha.contains(";"))
            {
                ErrosNaCompilacao.getLineError(0);
            }
			linha = this.tiraEspacos(linha);
			if(linha.substring(5,linha.indexOf("|")).equals("string"))
			{
				this.string = new Strings();
				string.armazenaVetor(linha.substring(linha.indexOf("|")+1,linha.length()-1));
			}

			else if(linha.substring(5,linha.indexOf("|")).equals("double"))
			{
				this.doubles = new Doubles();
				doubles.armazenaVetor(linha.substring(linha.indexOf("|")+1,linha.length()-1));
			}

			else if(linha.substring(5,linha.indexOf("|")).equals("char"))
			{
				this.chars = new Char();
				chars.armazenaVetor(linha.substring(linha.indexOf("|")+1,linha.length()-1));
			}

			else if(linha.substring(5,linha.indexOf("|")).equals("bool"))
			{
				this.bool = new Bool();
				bool.armazenaVetor(linha.substring(linha.indexOf("|")+1,linha.length()-1));
			}

			else if(linha.substring(5,linha.indexOf("|")).equals("int"))
			{
				this.vetores = new Int();
				vetores.armazenaVetor(linha.substring(linha.indexOf("|")+1,linha.length()-1));
			}

		}

		else if (linha.substring(0,5).equals("input"))
		{
			this.input(this.tiraEspacos(linha));
		}

		else if (linha.substring(0,5).equals("while") || this.controladorDeLaco)
		{
			lacoDeRepeticao = new While();
			setExpressao(this.tiraEspacos(linha.substring(5, linha.length()))); //expressao do while
			this.controladorDeLaco = true;
		}

		else if(linha.substring(0,6).equals("double"))
		{
			this.doubles = new Doubles();
			if(linha.contains(";"))
			{
			    doubles.verificador(linha);
			}
			else
			{
				ErrosNaCompilacao.getLineError(0);
		    }
		}

		else if (linha.substring(0,6).equals("string"))
		{
			this.string = new Strings();
			if(linha.contains(";"))
			{
			    string.verificador(linha);
			}
			else
			{
				ErrosNaCompilacao.getLineError(0);
		    }
		}

		else if(linha.contains("call"))
		{
			String aux =  this.tiraEspacos(linha);
			String var = aux.substring(aux.indexOf("call")+4,aux.indexOf("("));
			String parametros = aux.substring(aux.indexOf("(")+1,aux.indexOf(")"));
			funcoes.get(var).runParametros(parametros);
			funcoes.get(var).chamadaDef(this.tiraEspacos(linha));

		}
	    else if( operacoes.analisadorLexicoDeOperacoes(this.tiraEspacos(linha))) //verifica se tem continha para fazer
		{

			String aux =  this.tiraEspacos(linha);
             if(!linha.contains(";"))
            {
                ErrosNaCompilacao.getLineError(0);
            }
           	
            else if(this.tiraEspacos(linha.substring(0,this.tiraEspacos(linha).indexOf('='))).contains("[") && this.tiraEspacos(linha.substring(0,this.tiraEspacos(linha).indexOf('='))).contains("]"))
            {

                if(Comparadores.tipoVariaveis.get(aux.substring(aux.indexOf(']')+1,aux.indexOf('='))).equals("double"))
                {
                    this.inteiros =new Int();
                    int index = inteiros.indetificadorDeNumerosInt(aux.substring(aux.indexOf('[')+1,aux.indexOf(']')),0);
	                Doubles.vetoresArmazenados.get(aux.substring(aux.indexOf(']')+1,aux.indexOf('='))).put(index, operacoes.leituraDaOperacao(this.tiraEspacos(linha).substring(operacoes.getInicioDaExpressao(),operacoes.getFimDaExpressao())));
                }
                else
                {

                    this.inteiros =new Int();
                    int index = inteiros.indetificadorDeNumerosInt(aux.substring(aux.indexOf('[')+1,aux.indexOf(']')),0);
	                Int.vetoresArmazenados.get(aux.substring(aux.indexOf(']')+1,aux.indexOf('='))).put(index, (int)operacoes.leituraDaOperacao(this.tiraEspacos(linha).substring(operacoes.getInicioDaExpressao(),operacoes.getFimDaExpressao())));
                }
            }

            else if (Comparadores.tipoVariaveis.get(tiraEspacos(linha).substring(0, this.tiraEspacos(linha).indexOf("="))).equals("int"))
			{
			    Int.variaveisArmazenadas.put(operacoes.getVariavelParaArmazenar(),(int)operacoes.leituraDaOperacao(this.tiraEspacos(linha).substring(operacoes.getInicioDaExpressao(),operacoes.getFimDaExpressao())));
			}
			else
			{
				Doubles.variaveisArmazenadas.put(operacoes.getVariavelParaArmazenar(),operacoes.leituraDaOperacao(this.tiraEspacos(linha).substring(operacoes.getInicioDaExpressao(),operacoes.getFimDaExpressao())));
			}
        }

		else if ((this.tiraEspacos(linha).charAt(0) == '[') && linha.contains("]"))
		{
			linha = this.tiraEspacos(linha);
            if(!linha.contains(";"))
            {
                ErrosNaCompilacao.getLineError(0);
            }
            else if(Comparadores.tipoVariaveis.get(linha.substring(linha.indexOf("]")+1, linha.indexOf("="))).equals("string"))
			{
				this.string = new Strings();
				string.inseriValorNoVetor(linha.substring(0, linha.length()-1));
			}

			else if(Comparadores.tipoVariaveis.get(linha.substring(linha.indexOf("]")+1, linha.indexOf("="))).equals("double"))
			{
				this.doubles = new Doubles();
				doubles.inseriValorNoVetor(linha.substring(0,linha.length()-1));
			}

			else if(Comparadores.tipoVariaveis.get(linha.substring(linha.indexOf("]")+1, linha.indexOf("="))).equals("char"))
			{
				this.chars = new Char();
				chars.inseriValorNoVetor(linha.substring(0,linha.length()-1));
			}

			else if(Comparadores.tipoVariaveis.get(linha.substring(linha.indexOf("]")+1, linha.indexOf("="))).equals("bool"))
			{
				this.bool = new Bool();
				bool.inseriValorNoVetor(linha.substring(0,linha.length()-1));
			}

			else if(Comparadores.tipoVariaveis.get(linha.substring(linha.indexOf("]")+1, linha.indexOf("="))).equals("int"))
			{
				this.vetores = new Int();
				vetores.inseriValorNoVetor(linha.substring(0, linha.length()-1));
			}
		}

		else
		{
            
            if(linha.contains(";"))
            {
			    troca.getVariaveis(linha);
            }
            else
            {
                ErrosNaCompilacao.getLineError(0);
            }
            
		}
	}

	/* os métodos de expressao é oq vai pegar a expressão
	booleana que tem depois do if ou do while*/

	//inicio do método setExpressao
	public void setExpressao(String exp)
	{
		this.expressao = exp;
	}
	//fim do método setExpressao

	//inicio do método getExpressao
	public String getExpressao()
	{
		return this.expressao;
	}
	//fim do método getIfExpressao
	public void setIfExpressao(String exp)
	{
		this.ifExpressao = exp;
	}
	//fim do método setIfExpressao

	//inicio do método getIfExpressao
	public String getIfExpressao()
	{
		return this.ifExpressao;
	}
	//fim do método getIfExpressao
}
