package com.runrunfast.currency.service.impl;

import com.runrunfast.currency.entity.User;
import com.runrunfast.currency.mapper.UserMapper;
import com.runrunfast.currency.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 邹智敏
 * @since 2018-11-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
