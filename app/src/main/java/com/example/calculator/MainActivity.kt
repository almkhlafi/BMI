package com.example.calculator

import android.graphics.Color
import android.graphics.drawable.PaintDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextPaint
import android.widget.*
import android.widget.EditText
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        var calcu=findViewById<Button>(R.id.calculate)
        var cvHeight=findViewById<EditText>(R.id.etHeight)
        var cvWeight=findViewById<EditText>(R.id.etWeight)
        var cvResult=findViewById<TextView>(R.id.cvResult)
        var Underwei=findViewById<TextView>(R.id.Bunderweight)
        var img=findViewById<ImageView>(R.id.imageView)
        var clear=findViewById<Button>(R.id.clear)
        clear.setOnClickListener(){

            cvHeight.hint.toString()
            cvResult.setText("0")
            cvWeight.setText("0")
            var img=findViewById<ImageView>(R.id.imageView)
            var r=resources.getDrawable(R.mipmap.defaultt)
            img.setImageDrawable(r)
        }

        calcu.setOnClickListener(){



            var weight=cvWeight.text.toString()
                var wei=weight.toDouble()
                var height=cvHeight.text.toString()
                var hei=height.toDouble()
                    val bmi:Double=(wei / (hei / 100.0).pow(2))
            val formatt:Double=String.format("%.2f",bmi).toDouble()


    try {


            when(formatt){

                in 1.0..18.5 ->{
                    var img=findViewById<ImageView>(R.id.imageView)
                    var r=resources.getDrawable(R.mipmap.green)
                    cvResult.setText(formatt.toString()+" kg/m2"+"  Healthy"+img.setImageDrawable(r))
                    Toast.makeText(applicationContext,"Normal",Toast.LENGTH_SHORT).show()
                }
                in 18.5..24.9 ->{
                    var img=findViewById<ImageView>(R.id.imageView)
                    var r=resources.getDrawable(R.mipmap.orang)
                    cvResult.setText(formatt.toString()+" kg/m2"+"  Overweight"+img.setImageDrawable(r))
                    Toast.makeText(applicationContext,"Overweight",Toast.LENGTH_SHORT).show()
                }
                in 25.0..29.9 ->{
                    var img=findViewById<ImageView>(R.id.imageView)
                    var r=resources.getDrawable(R.mipmap.red)
                    cvResult.setText(formatt.toString()+" kg/m2"+"  Obese"+img.setImageDrawable(r))
                    Toast.makeText(applicationContext,"Obese",Toast.LENGTH_SHORT).show()
                }
                else -> {Toast.makeText(applicationContext,"Check your Input",Toast.LENGTH_SHORT).show()}

            }
        }catch (e: Exception){
        Toast.makeText(applicationContext,"An Error",Toast.LENGTH_SHORT).show()
        }
        }
    }
}