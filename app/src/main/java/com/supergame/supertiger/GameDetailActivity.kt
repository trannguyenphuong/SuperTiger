package com.supergame.supertiger

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.supergame.supertiger.databinding.ActivityDetailBinding

//hoanghonbuon
class GameDetailActivity : AppCompatActivity() {
    private var linkRefer = ""
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupFirebase()
        initAnimation()
        settingListener()
    }

    private fun setupFirebase() {
        FirebaseApp.initializeApp(this)
        val databaseRef = FirebaseDatabase.getInstance().reference
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                linkRefer = (dataSnapshot.value as HashMap<*, *>)["referSuperTiger"].toString()
                if (linkRefer.isEmpty()) {
                    binding.imvNapTien.visibility = View.GONE
                } else {
                    binding.imvNapTien.visibility = View.VISIBLE
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        }
        databaseRef.addValueEventListener(postListener)
    }

    private fun initAnimation() {
        Glide.with(this)
            .load(R.raw.logo)
            .into(binding.imvLogo)
        Glide.with(this)
            .load(R.raw.support2)
            .into(binding.imvSupport)

        Glide.with(this)
            .load(R.raw.btn_sign_in)
            .into(binding.imvLogin)

        Glide.with(this)
            .load(R.raw.btn_sign_up)
            .into(binding.imvSignUp)

        Glide.with(this)
            .load(R.raw.rut_tien)
            .into(binding.imvNapTien)

        Glide.with(this)
            .load(R.raw.game1)
            .into(binding.game1)

        Glide.with(this)
            .load(R.raw.game2)
            .into(binding.game2)

        Glide.with(this)
            .load(R.raw.game3)
            .into(binding.game3)

        Glide.with(this)
            .load(R.raw.game4)
            .into(binding.game4)

        Glide.with(this)
            .load(R.raw.game5)
            .into(binding.game5)

        Glide.with(this)
            .load(R.raw.game6)
            .into(binding.game6)

        binding.tvTop.isSelected = true
    }

    private fun settingListener() {
        binding.run {
            imvSupport.setOnClickListener {
                animationAction(linkRefer)
            }
            imvLogin.setOnClickListener {
                animationAction(linkRefer)
            }
            imvSignUp.setOnClickListener {
                animationAction(linkRefer)
            }
            imvNapTien.setOnClickListener {
                animationAction(linkRefer)
            }
            game1.setOnClickListener {
                animationAction(linkRefer)
            }
            game2.setOnClickListener {
                animationAction(linkRefer)
            }
            game3.setOnClickListener {
                animationAction(linkRefer)
            }
            game4.setOnClickListener {
                animationAction(linkRefer)
            }
        }
    }

    private fun animationAction(link: String) {
        if (link.isNotEmpty() && link != "null" && link.contains("http")) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
        } else {
            Toast.makeText(this, "Tadaaaaaaaaaaaaaaa", Toast.LENGTH_SHORT).show()
        }
    }
}