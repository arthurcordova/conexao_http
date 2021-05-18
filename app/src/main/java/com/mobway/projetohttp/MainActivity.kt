package com.mobway.projetohttp

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var endPoints: EndPoints
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: AdapterRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        RetrofitHelper.initRetrofit()
        endPoints = RetrofitHelper.getServices()

        // Ligando nosso recycler view
        adapter = AdapterRecyclerView(this, arrayListOf())
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            estabelecerConexaoAPIUserPhotos()

        }
        findViewById<FloatingActionButton>(R.id.fab2).setOnClickListener { view ->
            estabelecerConexaoAPITodos()
        }
    }


    fun estabelecerConexaoAPIUserPhotos() {
        val call = endPoints.getPhotos()
        call.enqueue(object : Callback<List<UserPhotoModel>> {

            override fun onResponse(
                call: Call<List<UserPhotoModel>>,
                response: Response<List<UserPhotoModel>>
            ) {

                response.body().let {
                    println("Deu certo")

                    adapter.update(it!!)

                }

            }

            override fun onFailure(call: Call<List<UserPhotoModel>>, t: Throwable) {
                println("Test FAIL")
            }

        })
    }

    private fun estabelecerConexaoAPITodos() {
        val call = endPoints.getTodos()
        call.enqueue(object : Callback<List<TodoModel>> {

            override fun onResponse(
                call: Call<List<TodoModel>>,
                response: Response<List<TodoModel>>
            ) {

                response.body().let {
                    println("Deu certo")
                }

            }

            override fun onFailure(call: Call<List<TodoModel>>, t: Throwable) {
                println("Test FAIL")
            }

        })
    }
}

