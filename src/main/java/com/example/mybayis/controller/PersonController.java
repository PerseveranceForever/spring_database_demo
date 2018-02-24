package com.example.mybayis.controller;

import com.example.mybayis.dao.PersonDAO;
import com.example.mybayis.domain.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 落叶飞翔的蜗牛
 * @Date 2018/2/24
 * @Description 需要事务的时候加上@EnableTransactionManagement
 */
@EnableTransactionManagement
@RestController
@RequestMapping("/mybatis")
public class PersonController {

    @Autowired
    private PersonDAO personMapper;

    @RequestMapping("/save")
    public Integer save() {
        PersonVO personDO = new PersonVO();
        personDO.setName("张三");
        personDO.setAge(18);
        personMapper.insert(personDO);
        return personDO.getId();
    }

    @RequestMapping("/update")
    public Long update() {
        PersonVO personDO = new PersonVO();
        personDO.setId(2);
        personDO.setName("旺旺");
        personDO.setAge(12);
        return personMapper.update(personDO);
    }

    @RequestMapping("/delete")
    public Long delete() {
        return personMapper.delete(11L);
    }

    @RequestMapping("/selectById")
    public PersonVO selectById() {
        return personMapper.selectById(2L);
    }

    @RequestMapping("/selectAll")
    public List<PersonVO> selectAll() {
        return personMapper.selectAll();
    }

    /**
     * 需要事务的时候加上@Transactional
     * @return Boolean
     */
    @RequestMapping("/transaction")
    @Transactional(rollbackFor = Exception.class)
    public Boolean transaction() {
        //假设先进行删除后进行保存操作
        delete();
        save();
        return true;
    }

}
