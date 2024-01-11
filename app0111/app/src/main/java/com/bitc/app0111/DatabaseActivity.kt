package com.bitc.app0111

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import com.bitc.app0111.databinding.ActivityDatabaseBinding

class DatabaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDatabaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dbHelper = DBHelper(this)
        var database = dbHelper.writableDatabase

        val seq = binding.etSeq
        val name = binding.etName
        val phone = binding.etPhone
        val email = binding.etEmail
        val address = binding.etAddress

        binding.btnInsert.setOnClickListener {
            val member = PhonebookData(seq.text, name.text, phone.text, email.text, address.text)
            dbHelper.dbInsert(database, member)
        }

        binding.btnUpdate.setOnClickListener {
            val member = PhonebookData(seq.text, name.text, phone.text, email.text, address.text)

            dbHelper.dbUpdate(database, member)
        }

        binding.btnDelete.setOnClickListener {
            dbHelper.dbDelete(database, seq.text)
        }

        binding.btnSelectAll.setOnClickListener {
            val text = dbHelper.dbSelectAll(database)
            binding.tvResult.text = text
        }

        binding.btnSelect.setOnClickListener {
            val text = dbHelper.dbSelect(database, seq.text)
            binding.tvResult.text = text
        }
    }
//
//    private fun clearEditText() {
//        binding.etSeq.setText("")
//        binding.etName.setText("")
//        binding.etPhone.setText("")
//        binding.etEmail.setText("")
//        binding.etAddress.setText("")
//    }
}



