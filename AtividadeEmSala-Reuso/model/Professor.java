package model;

 class Professor extends Pessoa {
    private  float salario;
    public Professor(String nome, String cpf, float salario){
        super(nome, cpf);
        this.salario = salario;
    }

    public Float getSalario(){
        return salario;
    }

    @Override
    public String apresentacao(){
        return super.apresentacao() + "E eu sou professor";
    }
    
}
