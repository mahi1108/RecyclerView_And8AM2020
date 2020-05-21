package cubex.mahesh.recyclerview_and8am2020

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.media.ThumbnailUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class MyAdapter(
    var mainActivity: MainActivity,
    var files: Array<File>
) : RecyclerView.Adapter<MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var linflater = LayoutInflater.from(mainActivity)
        var v = linflater.inflate(R.layout.indi_row_item,parent, false)
        return  MyHolder(v)
    }

    override fun getItemCount(): Int = files.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var file = files[position]
        var bmp = BitmapFactory.decodeFile(file.path)
        var bmp_thumb = ThumbnailUtils.extractThumbnail(bmp,100,100)
        holder.cirview.setImageBitmap(bmp_thumb)
        holder.fname.setText(file.name)
        holder.fsize.setText(file.length().toString() + " bytes")
        holder.btndelete.setOnClickListener {

        }
        holder.btnview.setOnClickListener {

        }
        holder.cview.setOnClickListener {

        }
    }

}