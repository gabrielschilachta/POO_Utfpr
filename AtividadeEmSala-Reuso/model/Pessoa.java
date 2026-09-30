package model;

public class Pessoa {
        private String nome, cpf;

        public Pessoa(String nome, String cpf){ //Metodo construtor
            this.nome = nome;
            this.cpf = cpf;
        }

        public String getNome(){
            return nome;
        }

        public String getCpf(){
            return cpf;
        }
        
        public void setNome(String n){
            if (nome.isEmpty()){
                System.out.println("Digite um nome");
            }
            else{
                nome = n;
            }


        }

        public void setCpf(String Acpf){
            if (cpf.isEmpty()){
                System.out.println("Digite uma matricula");
            }
            else{
                cpf = Acpf;
            }
        }
        public String apresentacao(){
            return "Ola meu nome é: " + getNome()  + "e meu cpf: " + getCpf();
        }
    }