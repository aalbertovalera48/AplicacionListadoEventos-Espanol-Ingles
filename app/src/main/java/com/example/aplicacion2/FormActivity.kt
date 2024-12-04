package com.example.aplicacion2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class FormActivity : AppCompatActivity() {
    private lateinit var imagePlaceholder: ImageView
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        imagePlaceholder = findViewById(R.id.imagePlaceholder)
        val btnSelectImage: Button = findViewById(R.id.btnSelectImage)
        val btnSave: Button = findViewById(R.id.btnSave)
        val btnClose: Button = findViewById(R.id.btnClose)

        btnSelectImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, REQUEST_CODE_SELECT_IMAGE)
        }

        btnSave.setOnClickListener {
            val name = findViewById<EditText>(R.id.editName).text.toString()
            val description = findViewById<EditText>(R.id.editDescription).text.toString()
            val address = findViewById<EditText>(R.id.editAddress).text.toString()
            val price = findViewById<EditText>(R.id.editPrice).text.toString()
            val date = findViewById<EditText>(R.id.editDate).text.toString()
            val capacity = findViewById<EditText>(R.id.editCapacity).text.toString()

            val event = Evento(name, description, address, price, date, capacity, imageUri?.toString())
            val intent = Intent()
            intent.putExtra("newEvent", event)
            setResult(RESULT_OK, intent)
            finish()
        }

        btnClose.setOnClickListener {
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SELECT_IMAGE && resultCode == Activity.RESULT_OK) {
            imageUri = data?.data
            imagePlaceholder.setImageURI(imageUri)
        }
    }

    companion object {
        const val REQUEST_CODE_SELECT_IMAGE = 2
    }
}