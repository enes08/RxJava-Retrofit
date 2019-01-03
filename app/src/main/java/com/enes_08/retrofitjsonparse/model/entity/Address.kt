package com.enes_08.retrofitjsonparse

import com.enes_08.retrofitjsonparse.model.response.Geo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Address {

    var street: String? = null

    var suite: String? = null

    var city: String? = null

    var zipcode: String? = null

    var geo: Geo? = null

}
