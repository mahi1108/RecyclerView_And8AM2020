package cubex.mahesh.recyclerview_and8am2020

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var status = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if(status==PackageManager.PERMISSION_GRANTED)
        {
                readFiles()
        }else{
            ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                  11)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
            readFiles()
        }
    }


    fun  readFiles(){
                var root_path = "/storage/sdcard0/"
                var root_path1 = "/storage/emulated/0/"
                var sub_path = "WhatsApp/Media/WhatsApp Images/"
                var file = File(root_path+sub_path)
                var files:Array<File>
                if(file.exists()){
                    files = file.listFiles()
                }else{
                    file = File(root_path1+sub_path)
                    files = file.listFiles()
                }
            var lManager = LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL,
                false)
            rview.layoutManager = lManager
            var myadapter = MyAdapter(this,files)
            rview.adapter = myadapter
    }
}
