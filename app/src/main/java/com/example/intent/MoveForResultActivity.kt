package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class MoveForResultActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var btnChoose: Button
    private lateinit var rqNumber: RadioGroup

    companion object{
        const val EXTRA_SELECTED_VALUE = "extra selected value"
        const val RESULT_CODE = 110
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        btnChoose = findViewById(R.id.btn_choose)
        btnChoose.setOnClickListener(this)

        rqNumber = findViewById(R.id.rg_number)
    }

    override fun onClick(v: View){
        if (v.id == R.id.btn_choose) {
            if (rqNumber.checkedRadioButtonId != 0) {
                var value = 0
                when (rqNumber.checkedRadioButtonId) {
                    R.id.rb_50 -> {
                        value = 50
                    }
                    R.id.rb_100 -> {
                        value = 100
                    }
                    R.id.rb_150 -> {
                        value = 150
                    }
                    R.id.rb_200 -> {
                        value = 200
                    }
                }
                val resultIntent : Intent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE,resultIntent)
                finish()
            }
        }
    }
}