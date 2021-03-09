package com.formacion.serverBack.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacion.serverBack.entity.WorkExperience;

@Repository
public interface IWorkExperienceRepository extends CrudRepository<WorkExperience, Integer> {

}
