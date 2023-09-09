package https.github.com.alecxandy.AutoGestorGURU.ms_user.controller;

import https.github.com.alecxandy.AutoGestorGURU.ms_user.model.FotoUser;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.UUID;

@RestController
@RequestMapping("/user/foto")
public class UserFotoController {

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE) //receber apenas arquivo de midia
    public void atualizarFoto(@RequestParam FotoUser fotoUser) {
        //nome do arquivo
        String nomeArquivo = UUID.randomUUID().toString() + "_" + fotoUser.getMultipartFile().getOriginalFilename();
        //caminho de transferencia do arquivo
        var arquivoFoto = Path.of("/Users/alec_/Desktop", nomeArquivo);
        try {
            fotoUser.getMultipartFile().transferTo(arquivoFoto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
