package aluno;

import java.util.Scanner;

public class Aluno {

    private String name;
    private int idade;
    private String genero;

    public Aluno() {
    }

    public Aluno(String name, int idade, String genero) {
        this.name = name;
        this.idade = idade;
        this.genero = genero;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public static Aluno reg(){

        Scanner inputy = new Scanner(System.in);
        Aluno temp = new Aluno();
        System.out.println("Por favor digite o nome do aluno: ");
        temp.setName(inputy.nextLine());
        System.out.println("Por favor digite o genero do aluno: ");
        temp.setGenero(inputy.nextLine());
        System.out.println("Por favor digite a idade do aluno: ");
        temp.setIdade(inputy.nextInt());

        return temp;
    }

}
