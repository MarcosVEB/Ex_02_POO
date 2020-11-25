import java.util.Random;
import java.util.Scanner;

public class Exercicio {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int quant = 0;
		int continua = 0;
		do {
		do {
				System.out.println("Informe a quantidade de números a serem gerados: ");
				quant = s.nextInt();
				if(quant <= 0) {
					System.out.println("Informe um número válido, maior do que 0.");
				}
		}while(quant <=0);
		
		int vet[] = new int[quant];
		int vetVari[] = new int[quant];
		int maior = Integer.MIN_VALUE;
		int menor = Integer.MAX_VALUE;
		int soma = 0;
		double media = 0;
		int moda = 0;
		
		for(int i = 0; i < vet.length; i++) {
			Random gerador = new Random();
			vet[i] = gerador.nextInt(5000);
		}
		
		//ordenando o vetor
		for(int i = 0; i < vet.length; i++) {
			int a = vet[i];
			int indice = i;
			for(int j = i + 1; j < vet.length; j++) {
				if(vet[j] < a) {
					a = vet[j];
					indice = j;
				}
			}
			vet[indice] = vet[i];
			vet[i] = a;
		}
		menor = vet[0];
		maior = vet[quant - 1];
		
		System.out.println("Vetor gerado: ");
		for(int i = 0; i < vet.length; i++) {
			System.out.print(vet[i] + "| ");
		}
		
		
		System.out.println();
		
		
		System.out.println("Números pares: ");
		for(int i = 0; i < vet.length; i++) {
			if(vet[i] %2 == 0) {
				System.out.print(vet[i] + "| ");
			}
		}
		
		
		System.out.println();
		
		
		System.out.println("Números ímpares: ");
		for(int i = 0; i < vet.length; i++) {
			if(vet[i] %2 != 0) {
				System.out.print(vet[i] + "| ");
			}
		}
		
		
		System.out.println();
		
		
		System.out.println("Números primos: ");
		for(int i = 0; i < vet.length; i++) {
			boolean primo = false;
			int metade = (int) vet[i] / 2;
			for(int j = 2; j < metade + 1; j++) {
				if(vet[i] % j != 0) {
					primo = true;
				} else {
					primo = false;
					break;
				}
			}
			if(primo) {
				System.out.print(vet[i] + "| ");
			}
		}
		
		
		System.out.println();
		
		
		System.out.println("Moda: ");
		int vetModa[] = new int[quant];
		for(int i = 0; i < vet.length - 1; i++) {
				for(int j = 0 + 1; j < vet.length; j++) {
					if(vet[i] == vet[j]) {
						vetModa[i] += 1;
					}
			}
		}
		boolean repete = false;
		for(int i = 0; i < vetModa.length - 1; i++) {
			for(int j = 0 + 1; j < vetModa.length - 1; j++) {
				if(vetModa[i] > vetModa[j]) {
					moda = vetModa[i];
					repete = true;
				}
		}
	}
		if(repete) {
			System.out.println(moda);
		} else {
			System.out.println("Nenhum número se repete");
		}
		
		
		System.out.println();
		
		
		//media
		for(int i = 0; i < vet.length; i++) {
			soma += vet[i];
			}
			media = soma / quant;
			
			
			System.out.println();
			
			
		System.out.println("Mediana: ");
			if(vet.length % 2 == 0) {
				int meio = (int) vet.length / 2;
				int meio2 = meio - 1;
				System.out.println(vet[meio2] + " e " + vet[meio]);
		} else {
			int meio = (int) vet.length / 2;
			System.out.println(vet[meio]);
		}
			
			
			System.out.println();
			
			
			System.out.println("Variancia: ");
			for(int i = 0; i < vet.length; i++) {
				double a = vet[i] - media;
				vetVari[i] = (int) Math.pow(a, 2);
			}
			int somaVari = 0;
			for(int i = 0; i < vet.length; i++) {
				somaVari += vetVari[i];
			}
			double variancia = somaVari / (quant -1);
			System.out.println(variancia);
			
			
			System.out.println();
			
			
			System.out.println("Desvio padrão: " + Math.sqrt(variancia));
			
		
		System.out.println();
		System.out.println("O maior número é " + maior + ", o menor é " + menor + ", a soma dos números gerados é " + soma + ", e a média é " + media);
		
		
		System.out.println("Deseja continuar? digite 1 se sim, se não, digite qualque outro número: ");
		continua = s.nextInt();
		} while(continua == 1);
		s.close();
	}
}