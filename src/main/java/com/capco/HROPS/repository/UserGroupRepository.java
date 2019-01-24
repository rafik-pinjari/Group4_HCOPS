package com.capco.HROPS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capco.HROPS.model.UserGroup;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Integer> {
	UserGroup findByuserGroupName(String userGroupName);

	UserGroup findAllByuserGroupId(int userGroupId);

}
