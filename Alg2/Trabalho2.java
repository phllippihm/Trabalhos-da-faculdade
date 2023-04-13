import javax.swing.*;
import java.util.Arrays;
import java.io.*;

public class Trabalho2{
    public String vaga;
	public int km;
	public String veiculo;
	public String nome;

	public Trabalho2(){ 
		this.vaga= "";
		this.veiculo= "";
		this.nome= "";
		this.km= 0;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setVaga(String vaga) {
		this.vaga = vaga;
	}
	public String getVaga() {
		return vaga;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public int getKm() {
		return km;
	}
	public void mostraCliente(){
		JOptionPane.showMessageDialog(null, "Olá, " + getNome() + " sua vaga é a " + getVaga() + ", seu veículo é o "
				+ getVeiculo() + " e sua kilometragem é " + getKm() + ".");
	}
	public void insereKilometragem(){
		int km = Integer.parseInt(JOptionPane.showInputDialog("Olá, " +getNome()+ " sua vaga é a " +getVaga()+ ", seu veículo é o "+getVeiculo() + ". Digite sua kilometragem: "));
		setKm(km);
		System.out.println("KM = "+getKm());
	}

    static final int tamanho = 12;
	static final Trabalho2 clientes[] = new Trabalho2[tamanho]; 
	static final String NOME_ARQUIVO = "AGENDA.TXT";

	public static void inicializaEstacionamento(){
		System.out.println("Tamanho = "+tamanho);
		for(int i=0; i<tamanho; i++){
			clientes[i] = new Trabalho2();
		}
		clientes[0].setVaga("101");
		clientes[1].setVaga("102");
		clientes[2].setVaga("103");
		clientes[3].setVaga("104");
		clientes[4].setVaga("201");
		clientes[5].setVaga("202");
		clientes[6].setVaga("203");
		clientes[7].setVaga("204");
		clientes[8].setVaga("301");
		clientes[9].setVaga("302");
		clientes[10].setVaga("303");
		clientes[11].setVaga("304");

		clientes[0].setNome("Ricardo");
		clientes[1].setNome("João");
		clientes[2].setNome("Maria");
		clientes[3].setNome("José");
		clientes[4].setNome("Julia");
		clientes[5].setNome("Marcos");
		clientes[6].setNome("Paulo");
		clientes[7].setNome("Pedro");
		clientes[8].setNome("Bruno");
		clientes[9].setNome("Isabela");
		clientes[10].setNome("Rafaela");
		clientes[11].setNome("Gabriel");

		clientes[0].setVeiculo("Ferrari");
		clientes[1].setVeiculo("Mercedes");
		clientes[2].setVeiculo("Fusca");
		clientes[3].setVeiculo("Lamborghini");
		clientes[4].setVeiculo("Evoque");
		clientes[5].setVeiculo("BMW");
		clientes[6].setVeiculo("Fusca");
		clientes[7].setVeiculo("Fiat 147");
		clientes[8].setVeiculo("Dodge");
		clientes[9].setVeiculo("Mustang");
		clientes[10].setVeiculo("Ferrari");
		clientes[11].setVeiculo("Fusca");
	}

	//1)Solicite ao usuário a kilometragem de cada veículo, a mensagem que aparece para o
    //usuário deve seguir o seguinte modelo:

    //"Olá (nome do dono do Veículo), sua vaga é a (número da vaga), insira a kilometragem
	//do seu veículo (Modelo do Veículo) : "
        
    //Os campos entre parênteses devem ser substituídos pelos respectivos nomes e
	//modelos. 
	public static void opcao_1(){
		for(int i=0; i<tamanho;i++){
			clientes[i].insereKilometragem();
		}	
	}

	//2)Solicite ao usuário que informe um modelo de veículo(STRING) e utilizando
	//PESQUISA LINEAR mostre o número de veículos com o mesmo modelo no
	//estacionamento piloto da Tiburcio´s PARK.

	public static void opcao_2(){
		String veiculo = JOptionPane.showInputDialog("Digite o modelo: ");
		int contador = 0;
		for(int i=0; i<tamanho; i++){
			if(veiculo.equalsIgnoreCase(clientes[i].getVeiculo())){
				contador++;
			}
		}
		JOptionPane.showMessageDialog(null, "O estacionamento Tibursio Park tem "+contador+" veículos deste modelo");
	}
	
	//3) Mostre a média de Kilometragem dos carros do estacionamento.

	public static void opcao_3(){
		int soma = 0;
		Double media = 0.0;
		
		soma = somaKm();
		media = calculaMedia(soma);


		JOptionPane.showMessageDialog(null, "A média das kilometragens do estacionamento é "+media);
	}

    //4) Mostre o nome do dono, o número da vaga e o modelo do veículo que MAIS andou.
	public static void opcao_4(){
		int indiceMaior = maiorKm();
		clientes[indiceMaior].mostraCliente();
	}


    //5)  Mostre o número da vaga do veículo que MENOS andou e o nome do dono deste
	//veículo.

	public static void opcao_5(){
		int indiceMenor = menorKm();
		clientes[indiceMenor].mostraCliente();
	}
	
    //6)Solicite que o usuário informe o número de uma das vagas(STRING), mostre o nome
	//do dono, modelo e kilometragem deste veículo.	

	public static void opcao_6(){
		String vaga = JOptionPane.showInputDialog("Digite a vaga: ");
		int indice=0;
		for(int i=0; i<tamanho; i++){
			if(vaga.equalsIgnoreCase(clientes[i].getVaga())){
				indice = i;
			}
		}
		clientes[indice].mostraCliente();
	}
	
	//7)  Mostre todas as leituras de kilometragem ordenadas. Para isso coloque todas as
	//leituras em um VETOR e ordene com o BubbleSort.

	public static void opcao_7(){
		int troca, fim, aux;
		int k = 0, i;
		int VetorK[] = new int [tamanho];
		String mensagem ="";

		for (int j=0; j<tamanho; j++){
			VetorK[k] = clientes[j].getKm();
			k++;
		}

		troca = 1;
		fim = tamanho - 1;
		while(troca==1){
			troca = 0;
			for(i=0; i<fim; i++){
				if (VetorK[i] > VetorK[i+1]){
					aux = VetorK[i];
					VetorK[i]= VetorK[i+1];
					VetorK[i+1]= aux;
					troca = 1;
				}			
			}
			fim = fim -1;
		}
		mensagem = Arrays.toString(VetorK);
		JOptionPane.showMessageDialog(null, mensagem);
	}

	//8) Mostre o número de veículos que possuem kilometragem superior a média
	//calculada na opção 3.

	public static void opcao_8(){
		int soma = 0, acimaDaMedia = 0;
		Double media = 0.0;
		
		soma = somaKm();
		media = calculaMedia(soma);
		acimaDaMedia = kmAcimaDaMedia(media);

		JOptionPane.showMessageDialog(null, "O número de kilometragens acima da média  é "+acimaDaMedia);
	}

	//9) Solicite que o usuário informe o nome de um dono, mostre o modelo, a
	//kilometragem deste veículo e o número da vaga.

	public static void opcao_9(){
		String dono = JOptionPane.showInputDialog("Digite o nome: ");	
		int indice=0;
		for(int i=0; i<tamanho; i++){
			if(dono.equalsIgnoreCase(clientes[i].getNome())){
				indice = i;
			}
		}
		clientes[indice].mostraCliente();
	}

	//10) Considerando as vagas com final 4 (104,204,304), mostre o nome do dono, o modelo e a kilometragem.
	
	public static void opcao_10(){
		clientes[3].mostraCliente();
		clientes[7].mostraCliente();
		clientes[11].mostraCliente();
	}

	public static void opcao_11(){
		escreveArquivo();
		leArquivo();
	}

	public static int somaKm(){
		int soma=0;
		for(int i=0; i<tamanho; i++){
			soma+= clientes[i].getKm();
		}
		return soma;
	}
		
	public static Double calculaMedia(int soma){
		Double media=0.0;
		media = soma/12.0;
		return media;
	}

	public static int maiorKm(){
		int maior=0, indiceMaior=-1;
		for(int i=0; i<tamanho; i++){
			if(clientes[i].getKm()>maior){
				maior = clientes[i].getKm();
				indiceMaior = i;
			}
		}
		return indiceMaior;
	}

	public static int menorKm(){
		int menor=999999, indiceMenor=-1;
		for(int i=0; i<tamanho; i++){
			if(clientes[i].getKm()<menor){
				menor = clientes[i].getKm();
				indiceMenor = i;
			}
		}
		return indiceMenor;
	}

	public static int kmAcimaDaMedia(Double media){
		int contador=0;
		for(int i=0; i<tamanho; i++){
			if(clientes[i].getKm()>media){
				contador++;
			}
		}
		return contador;
	}

	public static void escreveArquivo(){
		try{
            BufferedWriter agenda = null;
			
			agenda = new BufferedWriter(new FileWriter(new File(NOME_ARQUIVO)));

			
			for(int i=0;i<tamanho;i++){
				agenda.write(clientes[i].getNome());
				agenda.newLine();
			}
		
            agenda.close();

          } catch (IOException e){
            JOptionPane.showMessageDialog(null, "Não abriu arquivo para escrita!");
      }
	}

	public static void leArquivo(){
		try{

			BufferedReader agenda = new BufferedReader(new FileReader(new File(NOME_ARQUIVO)));
			String nome = agenda.readLine();
		
			while (nome!= null) {
			   JOptionPane.showMessageDialog(null, "Nome: " + nome);
			   nome = agenda.readLine();
			}
		
			agenda.close();
		  }catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Não abriu arquivo para leitura!");
		  }
	}

    public static void main(String args[]){
		inicializaEstacionamento();
		int opcao = 1;
		while (opcao > 0 && opcao < 12) {

			
			opcao = Integer.parseInt(JOptionPane.showInputDialog( "MENU \n\n"
											+ "1) Cadastrar Kilometragem\n"
											+ "2) Verificar modelos de veículos repetidos\n"
											+ "3) Média de kilometragem\n"
											+ "4) Informações do veículo que mais andou\n"
											+ "5) Informações do veículo que menos andou\n"
											+ "6) Informações da vaga\n"
											+ "7) Kilometragens ordenadas\n"
											+ "8) Kilometragens maiores que a média\n"
											+ "9) Informações do cliente por nome\n"
											+ "10) Mostrar as vagas de final 4(104,204,304)\n"
											+ "11) - Mostra agenda de clientes\n"
											+ "12) - Sair"));


			if(opcao == 1){
				opcao_1();

			}
			else if(opcao == 2){
				opcao_2();
			}

			else if(opcao == 3){
				opcao_3();
			}
			else if(opcao == 4){
			 	opcao_4();

			}
			else if(opcao == 5){
				opcao_5();
			}
			else if(opcao == 6){
				opcao_6();
			}
			else if(opcao == 7){
				opcao_7();
			}
			else if(opcao == 8){
				opcao_8();
			}
			else if(opcao == 9){
				opcao_9();
			}
			else if(opcao == 10){
				opcao_10();
			}
			else if(opcao == 11){
				opcao_11();
			}
			else{
				opcao = 0;
			}

		} 
	}
	
}