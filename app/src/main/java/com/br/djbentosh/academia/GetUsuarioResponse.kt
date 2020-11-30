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

data class GetCadastroReturn(
    @SerializedName("ok") val ok:Boolean
)

data class GetNewChamada(
    @SerializedName("user") val user: String,
    @SerializedName("nome") val nome: String,
    @SerializedName("telefone") val telefone: String

)