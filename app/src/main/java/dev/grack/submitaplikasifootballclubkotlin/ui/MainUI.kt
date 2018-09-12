package dev.grack.submitaplikasifootballclubkotlin.ui

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.*

class MainUI : AnkoComponent<ViewGroup> {

    companion object {
        val gambarId = 1
        val namaId = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        linearLayout {
            lparams(matchParent, wrapContent)
            padding = dip(16)

            imageView {
                id = gambarId
            }.lparams(width = dip(50), height = dip(50))

            textView {
                id = namaId
                textColor = Color.BLACK
                this.gravity = Gravity.CENTER_VERTICAL
            }.lparams(width = wrapContent, height = wrapContent) {
                margin = dip(15)
            }

        }
    }
}