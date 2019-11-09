package com.ttptriage.service;

import com.ttptriage.entities.PersonalInfo;

public interface PersonalInfoService {
	public PersonalInfo create(int personId, PersonalInfo personalInfo);
	public PersonalInfo getInfo(int personId);
	public PersonalInfo updateInfo(int personId, PersonalInfo personalInfo);
	public Boolean deleteInfo(int personId, int infoId);
}
