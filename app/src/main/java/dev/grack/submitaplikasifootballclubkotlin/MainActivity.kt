package dev.grack.submitaplikasifootballclubkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import dev.grack.submitaplikasifootballclubkotlin.adapter.AdapterFootball
import dev.grack.submitaplikasifootballclubkotlin.model.ModelFootballs
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    var listItem: MutableList<ModelFootballs> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initData()

        verticalLayout {
            lparams(matchParent, matchParent)
            orientation = LinearLayout.VERTICAL

            recyclerView {
                lparams(matchParent, matchParent)
                layoutManager = LinearLayoutManager(context)
                adapter = AdapterFootball(listItem) {
                    startActivity<DetailActivity>(DetailActivity.POSITIONEXTRA to it)
                    val toast = Toast.makeText(context, it.name, Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_names)
        val image = resources.obtainTypedArray(R.array.club_images)
        val keterangan = resources.getStringArray(R.array.club_detail)

        listItem.clear()

        for (i in name.indices) {
            listItem.add(ModelFootballs(name[i], image.getResourceId(i, 0), keterangan[i]))
        }

        image.recycle()
    }
}