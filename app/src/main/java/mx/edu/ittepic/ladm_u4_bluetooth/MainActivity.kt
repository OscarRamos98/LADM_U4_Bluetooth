package mx.edu.ittepic.ladm_u4_bluetooth

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
        if (bluetoothAdapter == null) {
            // Device doesn't support Bluetooth
        }

        button.setOnClickListener {

            if (bluetoothAdapter?.isEnabled == false) {
                val habilitarB = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                startActivityForResult(habilitarB, 1)
            }
        }
        button2.setOnClickListener {
            if (bluetoothAdapter?.isEnabled == true) {
                bluetoothAdapter.disable()
            }
        }
    }


}
