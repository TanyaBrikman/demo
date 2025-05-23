package com.example.demo.controller

import com.example.demo.repository.User
import com.example.demo.repository.UserRepository
import com.example.demo.service.UserService
import org.springframework.web.bind.annotation.*


@RestController
class UserController(
    private val userService: UserService
) {

    @GetMapping("/api/users")

    fun findAll(): List<User> {
        return userService.findAll()
    }


    @PostMapping("/api/users")   //Вызываем пост метод и передаем в него тело запроса (user) в виде json объекта с данными о юзере,
    //которого собираемся создать.
    // Чтобы эти данные из json объекта смапились на объект User, то нужно пометить его аннотацией requestBody
    fun create(@RequestBody user: User): User {
        return userService.create(user)
    }


    @DeleteMapping("/api/users/{id}")

    fun delete(@PathVariable id: Long) {
        userService.delete(id)
    }

    @PutMapping("/api/users/{id}")

    fun update(
        @PathVariable id: Long,
        @RequestParam(required = false) email: String,
        @RequestParam(required = false) name: String
    ){
        userService.update(id, email, name)
    }
}
