package id.ac.polbeng.rizkiafriani.volumeluasbalok

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import id.ac.polbeng.rizkiafriani.volumeluasbalok.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.bthasil.setOnClickListener {
            val panjang = binding.panjang.text.toString().toDoubleOrNull()
            val lebar = binding.lebar.text.toString().toDoubleOrNull()
            val tinggi = binding.tinggi.text.toString().toDoubleOrNull()


            if (panjang != null && lebar != null && tinggi != null) {

                val volume = hitungvolume(panjang, lebar, tinggi)
                val surfaceArea = hitungluas(panjang, lebar, tinggi)

                // Display the result
                binding.textViewResult.text = "Volume: $volume\nLuas Permukaan: $surfaceArea"
            } else {
                binding.textViewResult.text = "tolong masukkan angka yang valid!"
            }
        }
    }

    private fun hitungvolume(p: Double, l: Double, t: Double): Double {
        return p * l * t
    }

    private fun hitungluas(p: Double, l: Double, t: Double): Double {
        return 2 * (p * l + p * t + l * t)
    }
}
