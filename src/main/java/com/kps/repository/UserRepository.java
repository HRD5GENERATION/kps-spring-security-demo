package com.kps.repository;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.kps.model.Role;
import com.kps.model.User;

@Repository
public interface UserRepository {
	
	@Select("Select u.id, u.username, u.password, u.status From tbuser u Where u.username=#{username}")
	@Results({
		@Result(property="id", column="id"),
		@Result(property="roles", column="id", many=@Many(select="findRoleByUserId"))
	})
	User loadUserByUsername(String username);
	
	@Select("Select r.id, r.role From tbuser_role ur Inner Join tbrole r on r.id=ur.role_id Where ur.user_id=#{id}")
	List<Role> findRoleByUserId(int id);	
}
