package model;

class Aluno extends Pessoa{


     private String matricula;

    public Aluno(String nome, String cpf, String matricula){
        super(nome, cpf);
        this.matricula = matricula;
    }

    public String getMatricula(){
        return matricula;
    }

     @Override
    public String apresentacao(){
        return super.apresentacao() + "E eu sou aluno";
    }

    


    
}
