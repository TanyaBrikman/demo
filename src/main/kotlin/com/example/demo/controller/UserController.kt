package com.example.demo.controller

import com.example.demo.repository.User
import com.example.demo.repository.UserRepository
import com.example.demo.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController(
    private val userService: UserService
) {

    @GetMapping()
    @RequestMapping("api/users")
    fun findAll(): List<User> {
        return userService.findAll()
    }
}
