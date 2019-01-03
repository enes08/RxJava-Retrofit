package com.enes_08.retrofitjsonparse.model.response

import com.enes_08.retrofitjsonparse.Address
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class User  {

    //gelen jsondaki  id,name,username aynı olduğu için SerializedName anotation a gerek yok ama kodumdaki
    //değişken adları düzgün olsun diyorsan servisten gelen değeri yazman gerek  @SerializedName("id")
    //istersen kendi değişkeninin adını değiştirebilirsin  var mId: Int? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("username")
    @Expose
    var username: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("address")
    @Expose
    var address: Address? = null
    @SerializedName("phone")
    @Expose
    var phone: String? = null
    @SerializedName("website")
    @Expose
    var website: String? = null
    @SerializedName("company")
    @Expose
    var company: Company? = null

}
