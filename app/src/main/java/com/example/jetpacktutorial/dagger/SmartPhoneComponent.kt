package com.example.jetpacktutorial.dagger

import dagger.Component

@Component
interface SmartPhoneComponent {

    fun getSmartPhone() : SmartPhone
}