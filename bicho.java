package bicho_virtual;
import java.util.Scanner;

public class bichovirtual {

    private String nome;
    private String classe;
    private String familia;
    private int idade;
    private boolean estado; 
    private int caloria;
    private int forca;
    
    public bichovirtual(String nome, String classe, String familia) {
        this.nome = nome;
        this.classe = classe;
        this.familia = familia;
        this.idade = 0;
        this.estado = true;
        this.caloria = 10;
        this.forca = 10;
    }

    public void exibirStatus() {
        System.out.println("O animal se chama " + nome + ", é da classe " + classe + " da família " + familia +
                ". Força: " + forca + ", Calorias: " + caloria + ", Idade: " + idade + ", Estado: " + (estado ? "Vivo" : "Morto"));
    }

    public void comer() {
        if (!estado) {
            System.out.println("O animal está morto e não pode comer.");
            return;
        }
        if (caloria < 100) {
            caloria += 10;
            forca -= 2;
            System.out.println("O animal comeu! Força: " + forca + ", Calorias: " + caloria);
        } else {
            System.out.println("O animal está cheio e não pode comer mais.");
        }
    }

    public void correr() {
        if (!estado) {
            System.out.println("O animal está morto e não pode correr.");
            return;
        }
        if (caloria > 0 && forca > 0) {
            caloria -= 5;
            forca -= 5;
            System.out.println("O animal está correndo! Força: " + forca + ", Calorias: " + caloria);
        } else {
            System.out.println("O animal está cansado e não tem energia para correr.");
        }
    }

    public void dormir() {
        if (!estado) {
            System.out.println("O animal está morto e não pode dormir.");
            return;
        }
        forca += 10;
        caloria -= 2;
        System.out.println("O animal dormiu! Força: " + forca + ", Calorias: " + caloria);
    }

    public void morrer() {
        this.estado = false;
        this.forca = 0;
        System.out.println("O animal morreu!");
    }

    public boolean isAlive() {
        return estado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Crie seu novo animal");
        System.out.print("Insira o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Insira a classe: ");
        String classe = scanner.nextLine();
        System.out.print("Insira a família: ");
        String familia = scanner.nextLine();

        bichovirtual animal = new bichovirtual(nome, classe, familia);
        System.out.println("Animal criado com sucesso!");
        animal.exibirStatus();

        while (animal.isAlive()) {
            System.out.println("\nO que o " + nome + " vai fazer agora?");
            System.out.println("1- Comer");
            System.out.println("2- Correr");
            System.out.println("3- Dormir");
            System.out.println("4- Morrer");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    animal.comer();
                    break;
                case 2:
                    animal.correr();
                    break;
                case 3:
                    animal.dormir();
                    break;
                case 4:
                    animal.morrer();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            if (animal.isAlive()) {
                animal.exibirStatus();
            }
        }

        System.out.println("\nGAME OVER!");
        scanner.close();
    }
}
