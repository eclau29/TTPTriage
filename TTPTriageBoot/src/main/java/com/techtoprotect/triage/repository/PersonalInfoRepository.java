package com.techtoprotect.triage.repository;

import com.techtoprotect.triage.model.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Integer> {
}
