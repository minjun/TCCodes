package com.minjun.wang.enterprise.mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import com.minjun.wang.enterprise.model.Employee;

public interface UserMapper {
	@Select("SELECT * FROM Employee WHERE id = #{userId}")
	public Employee getUser(@Param("userId") String userId);
} 