package com.example.toothpick

interface UserRepository {
    fun getUser(): User
    fun saveUser(user: User)
}