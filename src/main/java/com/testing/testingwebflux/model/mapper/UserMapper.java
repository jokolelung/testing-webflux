package com.testing.testingwebflux.model.mapper;

import com.testing.testingwebflux.model.Users;
import com.testing.testingwebflux.model.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserDto entityToDto(Users user) {
        try {
            log.debug("Convert 'Course' entity to DTO. ['id': {}, 'email', {}]",
                    user.getId(), user.getEmail());

            UserDto dto = modelMapper.map(user, UserDto.class);

            log.debug("DTO '{}' initialized with id {}", user.getEmail(), user.getId());
            return dto;
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return null;
    }

}
