package com.br.djbentosh.academia

import retrofit2.Call
import retrofit2.http.GET

interface UsuarioApi {

    @GET("14bf65cb-0ec3-4d14-8e9c-d9d1f14987bb")
    fun getListaUsuarios(

    ): Call<List<GetUsuarioResponse>>

    @GET("4392235b-2614-4027-88ba-5c4cea94eb5b")
    fun getAutenticacaoUsuario(

    ): Call<GetLogin>

    @GET("ee28dc0d-1fc4-460a-af49-5c039300a325")
    fun getCadastraUsuario(

    ): Call<GetCadastroReturn>

    @GET("253f11f8-7ae5-4d4f-8607-395e56bdf024")
    fun getNewCadastro(

    ): Call<GetNewChamada>

}