package com.example.demo.service

import com.example.demo.repository.User
import com.example.demo.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.Period

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    fun findAll(): List<User> = userRepository.findAll()

    fun create(user: User): User {
        val optionalUser = userRepository.findByEmail(user.email)

        if (optionalUser != null) throw IllegalArgumentException("User ${user.email} already exists")

        user.age = Period.between(user.birth, LocalDate.now()).years

        return userRepository.save(user)
    }

    fun delete(id: Long) {
        userRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("User $id does not exist")

        userRepository.deleteById(id)
    }

    @Transactional
    fun update(id: Long, email: String, name: String) {
        val user = userRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("User $id does not exist")

        if (email != user.email) {
            val foundByEmail = userRepository.findByEmail(email)

            if (foundByEmail != null) throw IllegalArgumentException("User ${user.email} already exists")

            user.email = email
        }

        if(name != user.name){
                user.name = name
        }

//        userRepository.save(user)
    }


}