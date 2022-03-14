package car.copernic.pcanton.ejercicios

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var ej1:Button
    lateinit var ej2:Button
    lateinit var ej3:Button
    lateinit var ej4:Button
    lateinit var ej5:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ej1=findViewById(R.id.Ejercicio1)
        ej2=findViewById(R.id.Ejercicio2)
        ej3=findViewById(R.id.Ejercicio3)
        ej4=findViewById(R.id.Ejercicio4)
        ej5=findViewById(R.id.Ejercicio5)

        ej1.setOnClickListener{
            val i = Intent(this@MainActivity, Ejercicio1::class.java)
            startActivity(i)
        }
        ej2.setOnClickListener{
            val i = Intent(this@MainActivity, Ejercicio2::class.java)
            startActivity(i)
        }
        ej3.setOnClickListener{
            val i = Intent(this@MainActivity, Ejercicio3::class.java)
            startActivity(i)
        }
        ej4.setOnClickListener{
            val i = Intent(this@MainActivity, Ejercicio4::class.java)
            startActivity(i)
        }
        ej5.setOnClickListener{
            val i = Intent(this@MainActivity, Ejercicio5::class.java)
            startActivity(i)
        }
    }
}