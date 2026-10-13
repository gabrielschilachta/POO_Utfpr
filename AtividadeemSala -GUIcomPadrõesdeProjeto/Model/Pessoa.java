package Model;
public abstract class Pessoa {
    private String nome;
    private String cpf;

    public Pessoa(String nome, String cpf) throws DadosInvalidosException {
        setNome(nome);
        setCpf(cpf);
    }

    public String getNome() {
         return nome; 
        }

    public String getCpf() {
         return cpf; }

        public void setNome(String nome) throws DadosInvalidosException {
            if (nome == null || nome.trim().isEmpty()) {
                throw new DadosInvalidosException("O nome não pode ser vazio!");
            }
            this.nome = nome.trim();
        }
        public void setCpf(String cpf) throws DadosInvalidosException{
            if (cpf == null || cpf.trim().isEmpty()) {
                throw new DadosInvalidosException("O CPF não pode ser vazio!");
            }
            String cpfNumerico = cpf.replaceAll("[^0-9]", "");
            if (cpfNumerico.length() != 11) {
                throw new DadosInvalidosException("CPF inválido! Informe um CPF com exatamente 11 dígitos.");
            }
            this.cpf = cpf.trim();
        }
        public String apresentacao() {
             return "Nome: " + getNome() + " | CPF: " + getCpf();
             }
         }






