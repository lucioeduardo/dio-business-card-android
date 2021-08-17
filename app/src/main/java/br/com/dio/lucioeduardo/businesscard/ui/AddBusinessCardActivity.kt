package br.com.dio.lucioeduardo.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import br.com.dio.lucioeduardo.businesscard.App
import br.com.dio.lucioeduardo.businesscard.R
import br.com.dio.lucioeduardo.businesscard.data.BusinessCard
import br.com.dio.lucioeduardo.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners(){
        binding.closeBtn.setOnClickListener {
            finish()
        }
        binding.btnConfirm.setOnClickListener {
            Log.d("Color", binding.colorPicker.color.toString())

            val businessCard = BusinessCard(
                name = binding.txtInputName.editText?.text.toString(),
                company = binding.txtInputEnterpriseName.editText?.text.toString(),
                email = binding.txtInputEmail.editText?.text.toString(),
                backgroundColor = binding.colorPicker.color,
                phone = binding.txtInputPhone.editText?.text.toString()
            )

            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()

            finish()

        }
    }
}