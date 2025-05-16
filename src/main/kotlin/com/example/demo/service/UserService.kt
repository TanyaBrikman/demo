package com.example.demo.service

import com.example.demo.repository.User
import com.example.demo.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    fun findAll(): List<User> {
        return userRepository.findAll()
    }
}