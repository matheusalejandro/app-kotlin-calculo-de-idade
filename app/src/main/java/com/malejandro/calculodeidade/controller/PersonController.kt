package com.malejandro.calculodeidade.controller

import com.malejandro.calculodeidade.model.PersonDetails
import java.time.LocalDate

class PersonController(person: PersonDetails) {
    var person : PersonDetails = person
    val actualYear = LocalDate.now().year

    fun getResult(): String {
        return "${this.person.firstName}, você tem ${calculateAge()} anos de idade"
    }

    fun calculateAge(baseYear:Int) : Int {
        return baseYear - this.person.birthYear
    }

    fun calculateAge() : Int {
        return calculateAge(actualYear)
    }
}