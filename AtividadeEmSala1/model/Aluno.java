package model;

public class Aluno {
        private String nome, ra;

        public Aluno(String nome, String ra){ //Metodo construtor
            this.nome = nome;
            this.ra = ra;
        }

        public String getNome(){
            return nome;
        }

        public String getMatricula(){
            return ra;
        }
        
        public void setNome(String n){
            if (nome.isEmpty()){
                System.out.println("Digite um nome");
            }
            else{
                nome = n;
            }


        }

        public void setRa(String matricula){
            if (matricula.isEmpty()){
                System.out.println("Digite uma matricula");
            }
            else{
                ra = matricula;
            }
        }
    }