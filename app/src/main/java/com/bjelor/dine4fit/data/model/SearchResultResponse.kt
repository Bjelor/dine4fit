package com.bjelor.dine4fit.data.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text

@Root(name = "search", strict = false)
class SearchResultResponse(

    @field:Attribute(name = "jedn", required = false)
    var energyUnit: String = "",

    @field:ElementList(entry = "potravina", inline = true, required = false)
    var items: MutableList<Item> = mutableListOf(),

    ) {

    @Root(strict = false)
    data class Item(
        @field:Attribute(name = "guid_potravina")
        var guid: String = "",

        @field:Element(name = "nazev")
        var name: String = "",

        @field:Element(name = "foto_thumb", required = false)
        var thumbnailUrl: String = "",

        @field:Element(name = "energie", required = false)
        var energy: Energy = Energy(),
    ) {

        @Root(strict = false)
        data class Energy(

            @field:Attribute(name = "jedn")
            var portion: String = "",

            @field:Text
            var value: Double = 0.0,
        )
    }

}