package https.github.com.alecxandy.AutoGestorGURU.ms_user.controller;

import https.github.com.alecxandy.AutoGestorGURU.ms_user.model.FotoUser;
import https.github.com.alecxandy.AutoGestorGURU.ms_user.service.FotoUserService;
import https.github.com.alecxandy.AutoGestorGURU.ms_user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.nio.file.Path;
import java.util.UUID;

@RestController
@RequestMapping("/user/foto")
public class UserFotoController {

    @Autowired
    private FotoUserService fotoUserService;
    @Autowired
    private UserService userService;

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE) //receber apenas arquivo de midia
    public void atualizarFoto(@RequestParam MultipartFile multipartFile) {

        FotoUser fotoUser = new FotoUser();
        fotoUser.setUser(userService.findById(2L));
        fotoUser.setNome(multipartFile.getOriginalFilename());
        fotoUser.setContentType(multipartFile.getContentType());
        fotoUser.setTamanho(multipartFile.getSize());
        fotoUserService.save(fotoUser);

        String nomeArquivo = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();
        var arquivoFoto = Path.of("/Users/alec_/Desktop", nomeArquivo);
        try {
            multipartFile.transferTo(arquivoFoto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @GetMapping
    public List<FotoUser> findAll() {
        return fotoUserService.findAll();
    }


}
