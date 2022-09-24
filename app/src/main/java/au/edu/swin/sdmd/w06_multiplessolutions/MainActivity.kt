package au.edu.swin.sdmd.w06_multiplessolutions

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val factor1 = Random.nextInt(from = 1, until = 13)
        val factor2  = Random.nextInt(from = 1, until = 13)
        val tvFactor1 = findViewById<TextView>(R.id.factor1)
        val tvFactor2 = findViewById<TextView>(R.id.factor2)

        tvFactor1.text = factor1.toString()
        tvFactor2.text = factor2.toString()


        var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // There are no request codes
                val data: String? = result.data?.getStringExtra("data")
                Log.i("resultLauncher", data.toString())
                val resultMain = findViewById<TextView>(R.id.resultMain)
                resultMain.text = data.toString()
            }
        }

//        for activity
//        val multiply = findViewById<Button>(R.id.multiply)
//        multiply.setOnClickListener {
//            val i = Intent(this, ResultActivity::class.java).apply {
//                putExtra("result", Result(factor1 * factor2))
//            }
//            resultLauncher.launch(i)
//        }

//         for fragment
            val multiply = findViewById<Button>(R.id.multiply)
            multiply.setOnClickListener {
               val fragment = ResultFragment.newInstance(factor1*factor2)
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.result_container, fragment)
                    .commit()
            }

    }
}