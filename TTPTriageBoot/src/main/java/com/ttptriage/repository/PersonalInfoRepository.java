package com.ttptriage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttptriage.entities.PersonalInfo;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Integer> {
}
