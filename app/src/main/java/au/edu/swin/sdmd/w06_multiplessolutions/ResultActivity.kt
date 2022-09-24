package au.edu.swin.sdmd.w06_multiplessolutions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getParcelableExtra<Result>("result")
        val tvResult = findViewById<TextView>(R.id.result)
        tvResult.text = result?.opResult.toString()
        tvResult.setOnClickListener{
            onBackPressed()
        }
    }
    override fun onBackPressed() {

        val intent_return = intent
        val tvResult = findViewById<TextView>(R.id.result)
        intent_return.putExtra("data",tvResult.text);
        setResult(RESULT_OK, intent_return)
        Log.i("intent_return", intent_return.toString())
        super.finish()
//        super.onBackPressed();
    }
}