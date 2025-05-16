package com.example.demo.repository

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "name") //аннотация column если отличается название колонки
    val name: String,
    val email: String,
    val birth: LocalDate,
    val age: Int

) {
    override fun toString(): String {
        return "User(id=$id, name='$name', email='$email', birth=$birth, age=$age)"
    }
}