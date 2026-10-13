package Model;

public class Professor extends Pessoa {
    private float salario;

    public Professor(String nome, String cpf, float salario) throws DadosInvalidosException {
        super(nome, cpf);
        setSalario(salario);
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) throws DadosInvalidosException { if (salario <= 0) {
         throw new DadosInvalidosException("O salário do professor deve ser maior que R$ 0,00!");
         }
          this.salario = salario;
         }

    @Override
    public String apresentacao() {
        return super.apresentacao() + String.format(" | Cargo: Professor | Salário: R$ %.2f", salario);
    }
}