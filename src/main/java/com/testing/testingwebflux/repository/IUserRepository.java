package com.testing.testingwebflux.repository;

import com.testing.testingwebflux.model.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface IUserRepository extends ReactiveSortingRepository<Users, Long> {

    Flux<Users> findAllByUsernameIsNotNull(Pageable pageable);
}
