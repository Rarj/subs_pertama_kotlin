package dev.grack.submitaplikasifootballclubkotlin

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import dev.grack.submitaplikasifootballclubkotlin.DetailActivity.Companion.keteranganId
import dev.grack.submitaplikasifootballclubkotlin.model.ModelFootballs
import dev.grack.submitaplikasifootballclubkotlin.ui.MainUI
import kotlinx.android.synthetic.main.abc_alert_dialog_material.view.*
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    companion object {
        val keteranganId = 3
        val POSITIONEXTRA = "position_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        val desc = intent.getParcelableExtra<ModelFootballs>(POSITIONEXTRA)

        DetailActivityUI(desc).setContentView(this)
    }
}

class DetailActivityUI(var desc: ModelFootballs) : AnkoComponent<DetailActivity> {
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
        scrollView{
            linearLayout {
                orientation = LinearLayout.VERTICAL
                lparams(matchParent, matchParent)

                imageView() {
                    Glide.with(this).load(desc.image).into(this)
                    id = MainUI.gambarId
                    padding = dip(10)

                    this@linearLayout.gravity = Gravity.CENTER_HORIZONTAL
                }.lparams(dip(80), dip(80))

                textView {
                    id = MainUI.namaId
                    text = desc.name
                    textSize = sp(10).toFloat()
                    gravity = Gravity.CENTER_HORIZONTAL
                    padding = dip(10)
                }

                textView {
                    id = keteranganId
                    text = desc.description
                    gravity = Gravity.CENTER_HORIZONTAL
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                    padding = dip(10)
                }
            }
        }
    }
}
