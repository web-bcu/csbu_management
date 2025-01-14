package com.csbu.mvc_management.services;

import com.csbu.mvc_management.entities.Role;
import com.csbu.mvc_management.entities.UserModel;
import com.csbu.mvc_management.mappers.UserMapper;
import com.csbu.mvc_management.payload.UserDto;
import com.csbu.mvc_management.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserMapper mapper;

    public List<UserDto> getAllUser() {
        return repository.findAll()
                .stream()
                .map(mapper::fromUser)
                .collect(Collectors.toList());
    }

    public UserDto getUser(String user_id) {
        return repository.findById(user_id)
                .map(mapper::fromUser)
                .orElseThrow(() -> new RuntimeException(
                        String.format("No user found with the provided Id: %s", user_id)
                ));
    }

    public String updateUser(UserDto userdto) {
        Optional<UserModel> userOptional = repository.findById(userdto.id());

        if (!userOptional.isPresent()) {
            return null;
        }

        UserModel user = userOptional.get();

        if (userdto.fullname() != null) {
            user.setFullname(userdto.fullname());
        }
        if (userdto.department() != null) {
            user.setDepartment(userdto.department());
        }
        if (userdto.role() != null) {
            user.setRole(userdto.role());
        }
        repository.save(user);

        return "Updated Successfully";
    }

    public List<UserDto> getUserByRole(Role role) {
        return repository.findByRole(role)
                .stream()
                .map(mapper::fromUser)
                .collect(Collectors.toList());
    }

    public List<UserDto> getUserByDepartment(String department) {
        return repository.findByDepartment(department)
                .stream()
                .map(mapper::fromUser)
                .collect(Collectors.toList());
    }
}
