package com.br.djbentosh.academia

import com.google.gson.annotations.SerializedName

data class GetUsuarioResponse(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("name") val name: String,
    @SerializedName("location") val location: String,
    @SerializedName("image") val image: String
)

data class GetUsuario(
    var id: String,
    var title: String,
    var name: String,
    var location: String,
    var image: String
)

data class GetLogin(
    @SerializedName("user") val user: String,
    @SerializedName("pass") val pass: String
)

data class GetCadastroReturn(
    @SerializedName("ok") val ok: Boolean
)

data class GetNovoCadastroReturn(
    @SerializedName("ok") val ok: Boolean
)



data class GetNovoCadastro(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("name") val name: String,
    @SerializedName("location") val location: String,
    @SerializedName("image") val image: String

)