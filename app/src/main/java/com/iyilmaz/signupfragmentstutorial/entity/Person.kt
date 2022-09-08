package com.iyilmaz.signupfragmentstutorial.entity

import java.io.Serializable

class Person(
    var name: String?,
    var surname: String?,
    var car: String?,
    var city: String?,
    var username: String?,
    var date: String?,
    var gender: String?,
    var kotlin: String?,
    var java: String?,
    var dart: String?,
    var cSharp: String?
) : Serializable {

    override fun toString(): String {
        return "$name $surname $car $city $username $date $gender $kotlin $java $dart $cSharp"
    }

}