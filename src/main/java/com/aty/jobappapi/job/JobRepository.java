package com.aty.jobappapi.job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository; // classe equivalente au JpaRepo<> approfondir!

public interface JobRepository extends JpaRepository<Job, Long> {


}
