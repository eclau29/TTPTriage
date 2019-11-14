package com.ttptriage.resource;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttptriage.entities.PersonalInfo;
import com.ttptriage.repository.PersonRepository;
import com.ttptriage.repository.PersonalInfoRepository;

@RestController
@RequestMapping(value = "api/personalinfo")
public class PersonalInfoController {

	@Autowired
	PersonalInfoRepository personalInfoRepository;
	@Autowired
	PersonRepository pRepo;

	@GetMapping(value = "{personId}/getInfo")
	public PersonalInfo getPersonalInfo(Integer id) {
		return personalInfoRepository.getOne(id);
	}

	@PostMapping(value = "{personId}/addInfo")
	public PersonalInfo create(@RequestBody PersonalInfo info, HttpServletRequest req, HttpServletResponse resp) {
		try {
			
			personalInfoRepository.saveAndFlush(info);
			resp.setStatus(201);
			// String newAddrUrl = "http://localhost:8081/api/addresses/" + address.getId();
			StringBuffer url = req.getRequestURL();
			System.out.println(url);
			url.append("/");
			url.append(info.getId());
			System.out.println(url);
			String newAddrUrl = url.toString();
			resp.addHeader("Location", newAddrUrl);
			return info;
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			info = null;
		}
		return info;
	}
	
	@PutMapping(value="/{personId}/info/{infoId}")
	public PersonalInfo updateInfo(@PathVariable Integer infoId, @PathVariable Integer personId,
			@RequestBody PersonalInfo info, HttpServletResponse resp, HttpServletRequest req) {
//		System.err.println("Film details: " + film);
//		return svc.update(fid, film);
		//alternative with error checking before
		PersonalInfo managedInfo = null;
		Optional<PersonalInfo> infoToUpdate = personalInfoRepository.findById(infoId);
		if (infoToUpdate.isPresent()) {
				managedInfo = infoToUpdate.get();
				info = personalInfoRepository.saveAndFlush(info);
				return managedInfo;
		}
		if (info == null) {
			resp.setStatus(404);
		}
		return managedInfo;
	}
}
