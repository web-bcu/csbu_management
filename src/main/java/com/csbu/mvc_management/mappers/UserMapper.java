package com.csbu.mvc_management.mappers;

import com.csbu.mvc_management.entities.UserModel;
import com.csbu.mvc_management.records.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapper {
    public UserModel toUser(RegisterRequest request) {
        return new UserModel(
                request.id(),
                request.fullname(),
                request.department(),
                request.password()
        );
    }
}