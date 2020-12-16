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
        interceptor.level = HttpLoggingInterceptor.Level.BODY

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
        onSuccess: (usuario: GetCadastroReturn) -> Unit,
        onError: () -> Unit
    ) {
        api.getCadastraUsuario()
            .enqueue(object : Callback<GetCadastroReturn> {
                override fun onResponse(
                    call: Call<GetCadastroReturn>,
                    response: Response<GetCadastroReturn>
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

                override fun onFailure(call: Call<GetCadastroReturn>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

    fun getNovoCadastro(
        onSuccess: (usuario: GetNovoCadastro) -> Unit,
        onError: () -> Unit
    ) {
        api.getNovoCadastro()
            .enqueue(object : Callback<GetNovoCadastro> {
                override fun onResponse(
                    call: Call<GetNovoCadastro>,
                    response: Response<GetNovoCadastro>
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

                override fun onFailure(call: Call<GetNovoCadastro>, t: Throwable) {
                    onError.invoke()
                }
            })
    }
}