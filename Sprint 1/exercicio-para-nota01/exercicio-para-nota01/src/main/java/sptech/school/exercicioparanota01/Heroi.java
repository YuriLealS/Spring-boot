package sptech.school.exercicioparanota01;

    public class Heroi {
        private String nome;
        private int idade;
        private String hablidade;
        private double forca;
        private boolean vivo;

        public Heroi(String nome, int idade, String hablidade, double forca, boolean vivo) {
            this.nome = nome;
            this.idade = idade;
            this.hablidade = hablidade;
            this.forca = forca;
            this.vivo = vivo;
        }

        public Heroi() {
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        public void setHablidade(String hablidade) {
            this.hablidade = hablidade;
        }

        public void setForca(double forca) {
            this.forca = forca;
        }

        public void setVivo(boolean vivo) {
            this.vivo = vivo;
        }

        public String getNome() {
            return nome;
        }

        public int getIdade() {
            return idade;
        }

        public String getHablidade() {
            return hablidade;
        }

        public double getForca() {
            return forca;
        }

        public boolean isVivo() {
            return vivo;
        }
    }
