package com.example.hibernate.dao;

import com.example.hibernate.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

/**
 * @Author 落叶飞翔的蜗牛
 * @Date 2018/2/24
 * @Description
 */
@Repository
@Table(name="user")
@Qualifier("userDao")
public interface UserDAO extends CrudRepository<User, Long > {
    @Override
    User findOne(Long id);

    @Override
    User save(User u);

    /**
     * 根据名称查询用户
     * @param name
     * @return
     */
    @Query("select t from User t where t.userName=?1")
    User findUserByName(@Param(value = "name") String name);
}
