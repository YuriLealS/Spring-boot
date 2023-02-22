package sptech.school.exercicioparanota01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

    @RestController
    @RequestMapping("/herois")
    public class HeroiController {

        private List <Heroi> herois = new ArrayList<>();

        @GetMapping
        public List<Heroi> listar(){
            return herois;
        }

        @GetMapping ("/{indice}")
        public Heroi listarIndice (@PathVariable int indice){
            Heroi h1 = herois.get(indice);
            return h1;
        }


        @GetMapping("/cadastrar/{nome}/{habilidade}/{idade}/{forca}/{vivo}")
        public Heroi cadastrar(Heroi h1, @PathVariable String nome, @PathVariable String habilidade, @PathVariable int idade, @PathVariable double forca, @PathVariable boolean vivo){
            h1.setForca(forca);
            h1.setHablidade(habilidade);
            h1.setIdade(idade);
            h1.setNome(nome);
            h1.setVivo(vivo);
            herois.add(h1);
            return h1;
        }

        @GetMapping("/atualizar/{indice}/{nome}/{habilidade}/{idade}/{forca}/{vivo}")
        public Heroi atualizar(Heroi h1, @PathVariable int indice, @PathVariable String nome, @PathVariable String habilidade, @PathVariable int idade, @PathVariable double forca, @PathVariable boolean vivo){
            if (indice >= herois.size()){
                return null;
            } else {
                h1 = herois.get(indice);
                h1.setForca(forca);
                h1.setHablidade(habilidade);
                h1.setIdade(idade);
                h1.setNome(nome);
                h1.setVivo(vivo);
                return h1;
            }
        }
        @GetMapping ("/remover/{indice}")
        public String remover (@PathVariable int indice){
            if (indice < herois.size()){
                Heroi h1 = herois.get(indice);
                herois.remove(h1);
                return "Herói removido";
            }else {
                return "Heroi não encontrado";
            }

        }
    }
