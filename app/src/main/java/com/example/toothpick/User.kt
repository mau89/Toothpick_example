package com.example.toothpick

class User(val name: String, val email: String) {

    override fun toString(): String {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}'
    }

}