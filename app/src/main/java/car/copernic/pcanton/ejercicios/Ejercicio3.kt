package car.copernic.pcanton.ejercicios

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button

class Ejercicio3 : AppCompatActivity(), SensorEventListener {

    lateinit var resultado: TextView
    lateinit var sensorManager: SensorManager
    lateinit var sensor: Sensor
    lateinit var acelerometro:Button
    lateinit var gravedad:Button
    lateinit var temperatura:Button
    lateinit var giroscopio:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)

        resultado=findViewById(R.id.resultado)
        acelerometro=findViewById(R.id.boton_acelerometro)
        gravedad=findViewById(R.id.button_gravedad)
        temperatura=findViewById(R.id.boton_temperatura)
        giroscopio=findViewById(R.id.boton_giroscopio)

//        sensor = sensorManager.getDefaultSensor( Sensor.TYPE_GYROSCOPE)
//        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)

        acelerometro.setOnClickListener{
            sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
            sensor = sensorManager.getDefaultSensor( Sensor.TYPE_GYROSCOPE)
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
        gravedad.setOnClickListener{
            sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
            sensor = sensorManager.getDefaultSensor( Sensor.TYPE_GRAVITY)
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
        temperatura.setOnClickListener{
            sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
            sensor = sensorManager.getDefaultSensor( Sensor.TYPE_AMBIENT_TEMPERATURE)
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
        giroscopio.setOnClickListener{
            sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
            sensor = sensorManager.getDefaultSensor( Sensor.TYPE_GYROSCOPE)
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }

    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event != null) {
            resultado.text = event.values[0].toString()
        }else {
            resultado.text = "error"
        }
    }
/*
               override fun onSensorChanged(event: SensorEvent) {
          if(event.sensor.type==Sensor.TYPE_ACCELEROMETER){
            resultado.text=event.values[0].toString()
          }
          else if (event.sensor.type==Sensor.TYPE_GRAVITY){
              resultado.text=event.values[0].toString()
            }
          else if (event.sensor.type==Sensor.TYPE_AMBIENT_TEMPERATURE){
              resultado.text=event.values[0].toString()
          }
          else if (event.sensor.type==Sensor.TYPE_GYROSCOPE){
              resultado.text=event.values[0].toString()
          }else{
              resultado.text="no esta"
          }
        }*/
    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}
