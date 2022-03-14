package car.copernic.pcanton.ejercicios

import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Ejercicio1 : AppCompatActivity() {
    // Holds an instance of the SensorManager system service.
    private var mSensorManager: SensorManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)

        mSensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val sensorList = mSensorManager!!.getSensorList(Sensor.TYPE_ALL)


        val sensorText = StringBuilder()
        for (currentSensor in sensorList) {
            sensorText.append(currentSensor.name).append(
                System.getProperty("line.separator")
            )
        }

        val sensorTextView = findViewById<View>(R.id.sensor_list) as TextView
        sensorTextView.text = sensorText
    }
}