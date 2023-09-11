package https.github.com.alecxandy.AutoGestorGURU.ms_user.controller;

import https.github.com.alecxandy.AutoGestorGURU.ms_user.model.ProfilePhoto;
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
    public void updatePhoto(@RequestParam MultipartFile multipartFile) {
        ProfilePhoto profilePhoto = new ProfilePhoto();
        profilePhoto.setUser(userService.findById(2L));
        profilePhoto.setNome(multipartFile.getOriginalFilename());
        profilePhoto.setContentType(multipartFile.getContentType());
        profilePhoto.setTamanho(multipartFile.getSize());
        fotoUserService.save(profilePhoto);
        String nomeArquivo = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();
        var arquivoFoto = Path.of("/Users/alec_/Desktop", nomeArquivo);
        try {
            multipartFile.transferTo(arquivoFoto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @GetMapping
    public List<ProfilePhoto> findAll() {
        return fotoUserService.findAll();
    }


}
