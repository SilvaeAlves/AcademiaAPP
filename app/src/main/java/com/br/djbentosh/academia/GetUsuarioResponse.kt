package com.br.djbentosh.academia

import com.google.gson.annotations.SerializedName

data class GetUsuarioResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("location") val location: String
)

data class GetLogin(
    @SerializedName("user") val user: String,
    @SerializedName("pass") val pass: String
)

data class GetCadastro(
    @SerializedName("user") val user: String,
    @SerializedName("name") val name: String,
    @SerializedName("pass") val pass: String

)
