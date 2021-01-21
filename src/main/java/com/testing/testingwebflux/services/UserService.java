package com.testing.testingwebflux.services;

import com.testing.testingwebflux.model.dto.UserDto;
import com.testing.testingwebflux.model.mapper.UserMapper;
import com.testing.testingwebflux.repository.IUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private UserMapper userMapper;

    /**
     * Fetches all users.
     * @return a list of courses.
     */
    public Flux<UserDto> getUsers(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return this.iUserRepository.findAllByUsernameIsNotNull(pageable)
                .map(c -> this.userMapper.entityToDto(c));
    }
}
