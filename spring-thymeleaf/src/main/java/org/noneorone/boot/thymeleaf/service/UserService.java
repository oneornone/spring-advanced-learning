package org.noneorone.boot.thymeleaf.service;

import org.noneorone.boot.thymeleaf.bean.User;
import org.noneorone.boot.thymeleaf.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {

    /**
     * 注入UserRepository
     */
    @Resource
    private UserRepository userRepository;

    /**
     * 保存对象
     *
     * @param user 将要保存的用户
     * @return 包含自动生成id的user对象
     */
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    /**
     * 根据id删除对象
     *
     * @param id 主键
     */
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    /**
     * 查询所有数据
     * @return 所有User对象
     */
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * 获取指定id对应的User对象
     * @param id 主键
     * @return User对象
     */
    public User getById(Integer id) {
        Optional<User> op = userRepository.findById(id);
        return op.get();
    }

    /**
     * 修改用户对象数据，持久化对象修改会自动更新到数据库
     * @param user 用户对象
     */
    @Transactional
    public void update(User user) {
        // 直接调用持久化对象的set方法修改对象的数据
        user.setUsername("孙悟空");
        user.setLoginName("swk");
    }



}
