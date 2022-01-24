package com.example.retrofitaurionpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.retrofitaurionpro.databinding.ActivityItemDetailsBinding

class ItemDetails : AppCompatActivity() {

    private lateinit var binding: ActivityItemDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title ="Details"


        val name = intent.getStringExtra("name")
        val allowForking = intent.getStringExtra("allow_forking")
        val archiveUrl = intent.getStringExtra("archive_url")
        val archived = intent.getStringExtra("archived")
        val assigneesUrl = intent.getStringExtra("assignees_url")
        val blobsUrl = intent.getStringExtra("blobs_url")
        val disabled = intent.getStringExtra("disabled")
        val forksCount = intent.getStringExtra("forks_count")
        val homepage = intent.getStringExtra("homepage")
        val size = intent.getStringExtra("size")
        val owner = intent.getStringExtra("owner")

        binding.apply {
            vlName.text = name
            vlAllowForking.text = allowForking
            vlArchiveUrl.text = archiveUrl
            vlArchived.text = archived
            vlAssigneesUrl.text = assigneesUrl
            vlBlobsUrl.text = blobsUrl
            vlDisabled.text = disabled
            vlForksCount.text = forksCount
            vlHomepage.text = homepage
            vlSize.text = size
            vlOwner.text = owner
        }
    }


}