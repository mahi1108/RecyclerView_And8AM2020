package cubex.mahesh.recyclerview_and8am2020

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.indi_row_item.view.*

class MyHolder(view:View) : RecyclerView.ViewHolder(view) {
    var cview = view.cview
    var cirview = view.ciview
    var fname = view.fname
    var fsize = view.fsize
    var btndelete = view.btn_delete
    var btnview = view.btn_view
}