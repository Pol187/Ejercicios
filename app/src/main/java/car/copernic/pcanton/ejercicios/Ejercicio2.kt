package car.copernic.pcanton.ejercicios


import android.content.pm.ActivityInfo
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class Ejercicio2 : AppCompatActivity(), SensorEventListener {

    lateinit var tvX:TextView
    lateinit var tvY:TextView
    lateinit var tvZ:TextView
    lateinit var sensorManager: SensorManager

    var acx: Float = 0f
    var acy: Float = 0f
    var acz: Float = 0f

    var tiposensor = Sensor.TYPE_ACCELEROMETER
    lateinit var sensor: Sensor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)
        tvX=findViewById(R.id.tvX)
        tvY=findViewById(R.id.tvY)
        tvZ=findViewById(R.id.tvZ)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(tiposensor)

        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }
    override fun onResume() {
        super.onResume()
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        sensor?.also { acceleracion ->
            sensorManager.registerListener(this, sensor , SensorManager.SENSOR_DELAY_NORMAL)
        }
    }
    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            tvX.text = "X: " + String.format( "%.3f", event.values[0] )
            tvY.text = "Y: " + String.format( "%.3f", event.values[1] )
            tvZ.text = "Z: " + String.format( "%.3f", event.values[2] )

            acx = event.values[0]
            acy = event.values[1]
            acz = event.values[2]
        }else{
            tvX.text = "X: "
            tvY.text = "Y: "
            tvZ.text = "Z: "
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }
    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}