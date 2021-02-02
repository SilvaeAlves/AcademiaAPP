package com.br.djbentosh.academia

import retrofit2.Call
import retrofit2.http.GET

interface UsuarioApi {

    @GET("62073e3d-1849-42d3-819f-b20d4a668498")
    fun getListaUsuarios(

    ): Call<List<GetUsuarioResponse>>

    @GET("4392235b-2614-4027-88ba-5c4cea94eb5b")
    fun getAutenticacaoUsuario(

    ): Call<GetLogin>

    @GET("ee28dc0d-1fc4-460a-af49-5c039300a325")
    fun getCadastraUsuario(

    ): Call<GetCadastroReturn>

    @GET("14d89a7f-c35e-40f2-83bb-8345c8c7a119")
    fun getNovoCadastro(

    ): Call<GetNovoCadastro>

}