package com.minjun.wang.enterprise.mapper;

public interface UserMapper {
	@Select("SELECT * FROM users WHERE id = #{userId}")
	User getUser(@Param("userId") String userId);
} 