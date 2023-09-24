package com.bjelor.dine4fit.data.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text

@Root(name = "potravina", strict = false)
data class DetailResponse(

    @field:Attribute(name = "guid_potravina", required = true)
    var guid: String = "",

    @field:Element(name = "nazev", required = false)
    var name: String = "",

    @field:Element(name = "foto", required = false)
    var photoUrl: String = "",

    @field:Element(name = "hodnoty", required = false)
    var values: Values = Values(),
) {


    @Root(strict = false)
    data class Values(

        @field:Element(name = "energie", required = false)
        var energy: NutritionalValue = NutritionalValue(),

        @field:Element(name = "bilkoviny", required = false)
        var protein: NutritionalValue = NutritionalValue(),

        @field:Element(name = "sacharidy", required = false)
        var carbs: NutritionalValue = NutritionalValue(),

        @field:Element(name = "tuky", required = false)
        var fat: NutritionalValue = NutritionalValue(),
    )

    @Root(strict = false)
    data class NutritionalValue(

        @field:Attribute(name = "jedn")
        var unit: String = "",

        @field:Text
        var value: Double = 0.0,
    )
}