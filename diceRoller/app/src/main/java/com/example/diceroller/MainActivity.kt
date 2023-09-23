package com.example.diceroller

import android.content.Context
import android.graphics.drawable.Drawable
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity() : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null

    private var x: Float = 0.0f
    private var y: Float = 0.0f
    private var z: Float = 0.0f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
        }

        rollButton.setOnClickListener {
            rollDice()
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {

            var accelerationX = event.values[0]
            var accelerationY = event.values[1]
            var accelerationZ = event.values[2]

            if(accelerationX - this.x > 25.0f || accelerationY - this.y > 25.0f || accelerationZ - this.z > 25.0f ) {
                rollDice()
            }

            this.x = accelerationX
            this.y = accelerationY
            this.z = accelerationZ
        }

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        return
    }


    private fun rollDice(){
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val diceImage : ImageView = findViewById(R.id.imageView2)

        val DrawableResources = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(DrawableResources)


    }
}