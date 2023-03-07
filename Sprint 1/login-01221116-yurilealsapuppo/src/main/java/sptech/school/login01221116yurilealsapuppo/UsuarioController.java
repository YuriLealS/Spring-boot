package sptech.school.login01221116yurilealsapuppo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private List<Usuario> cadastros;

    public UsuarioController() {
        cadastros = new ArrayList<>();
    }

    String senhaMudada;
    Usuario usuarioMudado;
    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario u){
        cadastros.add(u);
        return u;
    }
    @PostMapping("/autenticacao/{usuario}/{senha}")
        public Usuario autenticarUsuario(@PathVariable String usuario, @PathVariable String senha){
            for (int i = 0; i < cadastros.size(); i++) {
                cadastros.get(i);
                if (cadastros.get(i).getUser().equals(usuario) &&
                        cadastros.get(i).getSenha().equals(senha)){
                    cadastros.get(i).setAutenticado(true);
                    return cadastros.get(i);
                }
            }
            return null;
        }
    @GetMapping
    public List<Usuario> exibirUsuarios(){
        return cadastros;
    }

    @DeleteMapping("/autenticacao/{usuario}")
    public String desAutenticar(@PathVariable String usuario){
        for (Usuario u: cadastros) {
            if (u.getUser().equals(usuario)) {
                if (u.isAutenticado()) {
                    u.setAutenticado(false);
                    return "Logoff do usuário " + u.getNome() + " concluído";
                } else {
                    return "Usuário " + u.getNome() + " NÃO está autenticado";
                }
            }
        }
        return "Usuário " + usuario + " não encontrado";
    }

    @PutMapping("/alterarSenha/{userAtual}/{senhaAtual}/{novaSenha}/{confirmarNovaSenha}")
    public String alterarSenha(@PathVariable String userAtual, @PathVariable String senhaAtual,
                               @PathVariable String novaSenha, @PathVariable String confirmarNovaSenha){
        for (Usuario u : cadastros) {
            if (u.getUser().equals(userAtual)){
                if (u.getSenha().equals(senhaAtual)){
                    if (novaSenha.equals(confirmarNovaSenha)){
                        if (novaSenha.equals(senhaAtual)){
                            return "Essa senha é igual a antiga";
                        }else{
                            u.setSenha(novaSenha);
                            return "Senha alterada com sucesso";
                        }
                    }else {
                        return "As senhas não coincidem";
                    }
                }else {
                    return "Essa não é sua senha atual";
                }
            }
        } return "Esse usuário não está cadastrado";
    }

}
