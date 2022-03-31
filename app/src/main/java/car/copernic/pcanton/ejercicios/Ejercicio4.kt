package car.copernic.pcanton.ejercicios

import android.content.Context
import android.content.pm.ActivityInfo
import android.graphics.Canvas
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout


class Ejercicio4 : AppCompatActivity(),SensorEventListener {

    lateinit var layout: FrameLayout
    lateinit var sensorManager: SensorManager
    lateinit var sensor: Sensor
    lateinit var fondo: Lienzo

    var acx: Float = 0f
    var acy: Float = 0f
    var acz: Float = 0f

    var tiposensor = Sensor.TYPE_ACCELEROMETER

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio4)

        layout = findViewById(R.id.layout)

        fondo = Lienzo( this )

        layout.addView(fondo)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(tiposensor)

        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)

        }


    override fun onResume() {
        super.onResume()
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        sensor.also { acceleracion ->
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            acx = event.values[0]
            acy = event.values[1]
            acz = event.values[2]

            fondo.posx -= acx * 10
            fondo.posy += acy * 10
        }
        fondo.invalidate()
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    class Lienzo(context: Context) : View(context) {
        var posx: Float = 0f
        var posy: Float = 0f
        var posz: Float = 0f

        override fun onDraw(canvas: Canvas) {
            canvas.drawRGB(10,10,10)
            val ancho = getWidth()
            val alto = getHeight()
            val pincel1 = Paint()

            pincel1.setARGB(255, 90, 255, 100)
            canvas.drawCircle( (ancho/2) + posx, (alto/2) + posy, 500f , pincel1)

            pincel1.setARGB(255, 255, 100, 100)
            canvas.drawCircle( (ancho/2) + posx, (alto/2) + posy, ancho /20f , pincel1)
        }
    }
}