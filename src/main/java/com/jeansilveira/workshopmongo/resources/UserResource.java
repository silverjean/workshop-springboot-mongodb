package com.jeansilveira.workshopmongo.resources;

import com.jeansilveira.workshopmongo.domain.User;
import com.jeansilveira.workshopmongo.dto.UserDTO;
import com.jeansilveira.workshopmongo.services.UserService;
import com.jeansilveira.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();

        List<UserDTO> dtoList = list.stream().map(UserDTO::new).toList();

        return ResponseEntity.ok().body(dtoList);
    }

    @RequestMapping(value="/{id}" , method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        Optional<User> obj = service.findById(id);

        if (obj.isPresent()) {
            User user = obj.get();
            return ResponseEntity.ok().body(new UserDTO(user));
        } else {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
    }
}
