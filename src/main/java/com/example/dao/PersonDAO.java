package com.example.dao;

import com.example.domain.PersonVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author 落叶飞翔的蜗牛
 * @Date 2018/2/24
 * @Description
 */
@Mapper
public interface PersonDAO {

    /**
     * mybatis-spring-boot-starter的 github 源码地址为:
     * https://github.com/mybatis/spring-boot-starter
     * <p>
     * mybatis-spring-boot-stater的官方文档地址:
     * http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/
     * <p>
     * mybatis 官方中文文档：
     * http://www.mybatis.org/mybatis-3/zh/java-api.html
     */

    /**
     * 添加操作，返回新增元素的 ID
     *
     * @param personDO
     */
    @Insert("insert into person(name,age) values(#{name},#{age})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(PersonVO personDO);

    /**
     * 更新操作
     *
     * @param personDO
     * @return 受影响的行数
     */
    @Update("update person set name=#{name},age=#{age} where id=#{id}")
    Long update(PersonVO personDO);

    /**
     * 删除操作
     *
     * @param id
     * @return 受影响的行数
     */
    @Delete("delete from person where id=#{id}")
    Long delete(@Param("id") Long id);

    /**
     * 查询所有
     *
     * @return
     */
    @Select("select id,name,age from person")
    List<PersonVO> selectAll();

    /**
     * 根据主键查询单个
     *
     * @param id
     * @return
     */
    @Select("select id,name,age from person where id=#{id}")
    PersonVO selectById(@Param("id") Long id);
}
