package com.iyilmaz.signupfragmentstutorial.entity

import java.io.Serializable
import java.util.*

class Person(
    var name: String,
    var surname: String,
    var username: String,
    var date: String,
    var password: String,
    var gender: String?,
    var lanCheck1: String?,
    var lanCheck2: String?,
    var lanCheck3: String?,
    var lanCheck4: String?
) : Serializable {

    override fun toString(): String {
        return "$name $surname $username $date $password $gender $lanCheck1 $lanCheck2 $lanCheck3 $lanCheck4"
    }

}