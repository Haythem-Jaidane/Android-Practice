package tn.esprit.colormixer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tn.esprit.colormixer.databinding.ActivityQuestionBinding
import com.google.android.material.snackbar.Snackbar

//TODO 2 Add string constant val here for RED / BLUE / YELLOW / PURPLE / GREEN / ORANGE
val RED = "RED"
val BLUE = "BLUE"
val YELLOW = "YELLOW"
val PURPLE = "PURPLE"
val GREEN = "GREEN"
val ORANGE = "ORANGE"
//TODO 3 Add string constant val here for NAME / MIXED_COLOR / COLOR1 / COLOR2 / RESULT / SUCCESS / FAILED
val NAME = "NAME"
val MIXED_COLOR = "MIXED_COLOR"
val COLOR1 = "COLOR1"
val COLOR2 = "COLOR2"
val RESULT = "RESULT"
val SUCCESS = "SUCCESS"
val FAILED = "FAILED"

class QuestionActivity : AppCompatActivity() {

    //TODO 4 Add lateint var for binding
    private lateinit var binding:ActivityQuestionBinding
    //TODO 5 Add var for colorMixed / color1 / color2 / name
    var colorMixed:String = ""
    var color1:String = ""
    var color2:String = ""
    var name:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO 6 Bind the view and implement setContentView()
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //TODO 7 Implement setOnClickListener on the button Mix and call mixColor()
        binding.btnMix.setOnClickListener {
            mixColor()
        }
    }

    private fun mixColor(){

        //TODO 8 Check if the input for FullName. IF it's empty show a snackbar with the message : You must enter your name !
        if(binding.tfFullName.text?.isEmpty() == true){
            Snackbar.make(binding.root, "You must enter your name !", Snackbar.LENGTH_LONG).setDuration(1000).show()
            return
        }
        //TODO 9 Check if Only 2 colors are selected then change the value of  colorMixed / color1 / color2
        var count_color = 0
        color1 = ""
        color2 = ""

        if(binding.cbBlue.isChecked){
            count_color += 1
            color1 = BLUE
        }

        if(binding.cbRed.isChecked){
            count_color += 1
            if (color1.isEmpty()){
                color1 = RED
            }
            else{
                color2 = RED
            }
        }

        if(binding.cbYellow.isChecked){
            count_color += 1
            color2 = YELLOW

        }
        if(count_color == 2){
            if(color1 == BLUE){
                if (color2 == RED){
                    colorMixed = PURPLE
                }
                else{
                    colorMixed = GREEN
                }
            }
            else{
                colorMixed = ORANGE
            }
            //TODO 10 Change the value of name with the input
            name = binding.tfFullName.text.toString()
            //TODO 11 Create an Intent to AnswerActivity and add all of the values name / colorMixed / color1 / color2 Then start the Activity
            var intent = Intent(this, AnswerActivity::class.java)
            intent.putExtra(MIXED_COLOR, colorMixed)
            intent.putExtra(NAME,name)
            intent.putExtra(COLOR1,color1)
            intent.putExtra(COLOR2,color2)
            startActivity(intent)
        }
        else{
            Snackbar.make(binding.root, "select 2 color only :)", Snackbar.LENGTH_LONG).setDuration(1000).show()
            return
        }
    }
}