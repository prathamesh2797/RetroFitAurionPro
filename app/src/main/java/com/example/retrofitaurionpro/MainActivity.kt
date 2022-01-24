package com.example.retrofitaurionpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitaurionpro.adapter.RVAdapter
import com.example.retrofitaurionpro.adapter.onItemClickedInterface
import com.example.retrofitaurionpro.api.JsonAPI
import com.example.retrofitaurionpro.api.RetroFitHelper
import com.example.retrofitaurionpro.databinding.ActivityMainBinding
import com.example.retrofitaurionpro.models.jsonListItem
import com.example.retrofitaurionpro.repository.jsonRepository
import com.example.retrofitaurionpro.viewmodels.MainViewModel
import com.example.retrofitaurionpro.viewmodels.ViewModelProviderFactory

class MainActivity : AppCompatActivity(), onItemClickedInterface {

    lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    lateinit var rvAdapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title ="API DATA"

        val jsonApi = RetroFitHelper.getInstance().create(JsonAPI::class.java)
        val repository = jsonRepository(jsonApi)
        mainViewModel = ViewModelProvider(this, ViewModelProviderFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.jsonData.observe(this, Observer { list->
            Log.d("CODEDATA", list.toString())
            setUpRecyclerView(list)
        })
    }

    private fun setUpRecyclerView(list: List<jsonListItem>){
        rvAdapter = RVAdapter(this,list,this)
        binding.rvRecycler.adapter =rvAdapter
        binding.rvRecycler.layoutManager = LinearLayoutManager(this@MainActivity)


    }

    override fun onItemClick(listItems: jsonListItem) {
        Log.d("ITEM CLICKED", listItems.name.toString())
        val intent = Intent(this, ItemDetails::class.java)
        intent.putExtra("name",listItems.name)
        intent.putExtra("allow_forking", listItems.allow_forking.toString())
        intent.putExtra("archive_url", listItems.archive_url)
        intent.putExtra("archived", listItems.archived.toString())
        intent.putExtra("assignees_url", listItems.assignees_url)
        intent.putExtra("blobs_url", listItems.blobs_url)
        intent.putExtra("disabled", listItems.disabled.toString())
        intent.putExtra("forks_count", listItems.forks_count.toString())
        intent.putExtra("homepage", listItems.homepage.toString())
        intent.putExtra("size", listItems.size.toString())
        intent.putExtra("owner", listItems.owner.toString())


        startActivity(intent)
    }
}