package Model;

public class Aluno extends Pessoa {
    private String matricula;

    public Aluno(String nome, String cpf, String matricula) throws DadosInvalidosException {
        super(nome, cpf);
        setMatricula(matricula);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) throws DadosInvalidosException {
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new DadosInvalidosException("A matrícula do aluno não pode ser vazia!");
        }
        this.matricula = matricula.trim();
    }

    @Override
    public String apresentacao() {
        return super.apresentacao() + " | Cargo: Aluno | Matrícula: " + getMatricula();
    }
}
