package https.github.com.alecxandy.AutoGestorGURU.ms_user.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.UUID;

@RestController
@RequestMapping("/user/foto")
public class UserFotoController {


    @GetMapping
    public String test(){
        return "test ok";
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE) //receber apenas arquivo de midia
    public void atualizarFoto(@RequestPart MultipartFile multipartFile) {

        String nomeArquivo = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();

        var arquivoFoto = Path.of("/Users/alec_/Desktop", nomeArquivo);

        System.out.println(nomeArquivo);
        System.out.println(multipartFile.getContentType());

        try {
            multipartFile.transferTo(arquivoFoto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
