package https.github.com.alecxandy.AutoGestorGURU.msprofessor.service;

import https.github.com.alecxandy.AutoGestorGURU.msprofessor.exception.IdentifierNotFoundException;
import https.github.com.alecxandy.AutoGestorGURU.msprofessor.infra.AddressResourceClient;
import https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.dto.AddressDTO;
import https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.dto.TeachAddressDTO;
import https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.dto.TeacherAddressResponseDTO;
import https.github.com.alecxandy.AutoGestorGURU.msprofessor.model.entity.Teacher;
import https.github.com.alecxandy.AutoGestorGURU.msprofessor.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private final TeacherRepository teacherRepository;
    @Autowired
    private AddressResourceClient addressResourceClient;
    @Autowired
    private ModelMapper modelMapper;

    public TeacherService(TeacherRepository teacherRepository, AddressResourceClient addressResourceClient, ModelMapper modelMapper) {
        this.teacherRepository = teacherRepository;
        this.addressResourceClient = addressResourceClient;
        this.modelMapper = modelMapper;
    }

    public TeacherAddressResponseDTO save(TeachAddressDTO teachAddressDTO) {
        Teacher teacher = teachAddressDTO.getTeacher();
        AddressDTO addressDTO = teachAddressDTO.getAddressDTO();
        teacher.setAddress_id(addressResourceClient.save(addressDTO).getBody().longValue());
        return findById(teacherRepository.save(teacher).getId());

    }

    public List<TeacherAddressResponseDTO> list(Pageable pageable) {
        List<TeacherAddressResponseDTO> list = new ArrayList<>();
        for (Teacher t : teacherRepository.findAll(pageable)) {
            TeacherAddressResponseDTO teacherAddressResponseDTO = modelMapper.map(t, TeacherAddressResponseDTO.class);
            teacherAddressResponseDTO.setAddressDTO(addressResourceClient.findById(t.getAddress_id()).getBody().get());
            list.add(teacherAddressResponseDTO);
        }
        return list;
    }

    public TeacherAddressResponseDTO findById(Long id) {
        Teacher t = teacherRepository.findById(id).orElseThrow(IdentifierNotFoundException::new);
        TeacherAddressResponseDTO dto = modelMapper.map(t, TeacherAddressResponseDTO.class);
        dto.setAddressDTO(addressResourceClient.findById(t.getAddress_id()).getBody().get());
        return dto;
    }

    public void deleteById(Long id) {
        teacherRepository.findById(id).map(teacher -> {
            addressResourceClient.deleteById(teacher.getAddress_id());
            teacherRepository.deleteById(id);
            return teacher;
        }).orElseThrow(IdentifierNotFoundException::new);
    }

    public TeacherAddressResponseDTO update(TeachAddressDTO teachAddressDTO) {
        Teacher t = teacherRepository.findById(teachAddressDTO.getTeacher().getId()).orElseThrow(() -> new IdentifierNotFoundException());
        Teacher teacher = teachAddressDTO.getTeacher();
        AddressDTO addressDTO = teachAddressDTO.getAddressDTO();
        addressDTO.setId(t.getAddress_id());
        teacher.setAddress_id(addressResourceClient.save(addressDTO).getBody().longValue());
        return findById(teacherRepository.save(teacher).getId());
    }

    public List<TeacherAddressResponseDTO> findByNameContaining(String name) {
        List<TeacherAddressResponseDTO> list = new ArrayList<>();
        for (Teacher t : teacherRepository.findByNameContaining(name)) {
            TeacherAddressResponseDTO teacherAddressResponseDTO = modelMapper.map(t, TeacherAddressResponseDTO.class);
            teacherAddressResponseDTO.setAddressDTO(addressResourceClient.findById(t.getAddress_id()).getBody().get());
            list.add(teacherAddressResponseDTO);
        }
        return list;
    }


}
