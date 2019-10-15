package org.sidd.dao;

import org.sidd.entites.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReminderRepository extends JpaRepository<Reminder, Long> {

}
