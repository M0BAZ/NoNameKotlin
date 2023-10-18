package com.example.prog

class User(val fio: String, val role: String, val pass: String) {
    fun returnUserName(): String = fio
}