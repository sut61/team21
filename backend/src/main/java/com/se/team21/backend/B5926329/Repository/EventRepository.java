package com.se.team21.backend.B5926329.Repository;

import com.se.team21.backend.B5926329.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface EventRepository extends JpaRepository<Event, Long>{
}
