package com.oleksii.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.oleksii.data.domain.Group;

public interface GroupRepository extends CrudRepository<Group, Integer> {

}
