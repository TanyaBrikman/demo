package com.example.demo.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.time.LocalDate

interface UserRepository : JpaRepository<User, Long> {
   // спецификация jpa, запрос в виде названия метода
    fun findByEmail(email: String): User?
}