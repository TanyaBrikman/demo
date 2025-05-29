package com.example.demo.repository

import jakarta.persistence.*
import java.time.LocalDate
import java.time.Period

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "name") //аннотация column если отличается название колонки
    var name: String,
    var email: String,
    val birth: LocalDate,
) {
    @get:Transient
    val age: Int
        get() = Period.between(birth, LocalDate.now()).years

    override fun toString(): String {
        return "User(id=$id," +
                " name='$name'," +
                " email='$email'," +
                " birth=$birth, " +
                "age=$age)"
    }
}