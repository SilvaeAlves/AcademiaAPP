package com.br.djbentosh.academia

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UsuariosRepository {

    private val api: UsuarioApi

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level=HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
        client.addInterceptor(interceptor)

        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()

        api = retrofit.create(UsuarioApi::class.java)
    }

    fun getListaUsuarios(
        onSuccess: (usuario: List<GetUsuarioResponse>) -> Unit,
        onError: () -> Unit
    ) {
        api.getListaUsuarios()
            .enqueue(object : Callback<List<GetUsuarioResponse>> {
                override fun onResponse(
                    call: Call<List<GetUsuarioResponse>>,
                    response: Response<List<GetUsuarioResponse>>
                ) {
                    if (response.isSuccessful) {
                        val responseBody: List<GetUsuarioResponse>? = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<List<GetUsuarioResponse>>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

    fun getLoginAutentica(
        onSuccess: (usuario: GetLogin) -> Unit,
        onError: () -> Unit
    ) {
        api.getAutenticacaoUsuario()
            .enqueue(object : Callback<GetLogin> {
                override fun onResponse(
                    call: Call<GetLogin>,
                    response: Response<GetLogin>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<GetLogin>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

    fun getCadastraUsuario(
        onSuccess: (usuario: GetCadastro) -> Unit,
        onError: () -> Unit
    ) {
        api.getCadastraUsuario()
            .enqueue(object : Callback<GetCadastro> {
                override fun onResponse(
                    call: Call<GetCadastro>,
                    response: Response<GetCadastro>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<GetCadastro>, t: Throwable) {
                    onError.invoke()
                }
            })
    }


}