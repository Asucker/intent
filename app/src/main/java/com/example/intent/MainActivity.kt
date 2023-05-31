package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.intent.MoveForResultActivity.Companion.RESULT_CODE

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMovWithDataActivity: Button = findViewById(R.id.btn_move_activity_with_data)
        btnMovWithDataActivity.setOnClickListener(this)

        val btnMovWithObject: Button = findViewById(R.id.btn_move_with_object)
        btnMovWithObject.setOnClickListener(this)

        val btnMovWithResult: Button = findViewById(R.id.btn_move_activity_with_result)
        btnMovWithResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_with_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Artyom")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 17)
                startActivity(moveWithDataIntent)


            }
            R.id.btn_move_with_object -> {
                val person = Person("Ahmadovich", "rafi@gmail.com", "malang")
                val moveWithObject = Intent(this@MainActivity, move_with_object::class.java)
                moveWithObject.putExtra(move_with_object.EXTRA_PERSON, person)
                startActivity(moveWithObject)
            }
            R.id.btn_move_activity_with_result -> {
                val moveForResultIntent =
                    Intent(this@MainActivity, MoveForResultActivity::class.java)
                getResult.launch(moveForResultIntent)
            }
        }
    }

    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == RESULT_CODE) {
                val value = it.data?.getIntExtra(
                    MoveForResultActivity.EXTRA_SELECTED_VALUE, 0
                )
                tvResult.setText("Habsil $value")

            }
        }
}
