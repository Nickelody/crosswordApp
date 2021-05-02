package com.omen273.crossLingo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_sett.*
import kotlinx.android.synthetic.main.toolbar_sett.*
import java.io.File

class SettActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sett)
        setSupportActionBar(sett_toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        sett_toolbar.setNavigationOnClickListener{
            onBackPressed()
        }

        level_list.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                openFileOutput(ChooseTopicsActivity.LEVEL_NAME, MODE_PRIVATE).use {
                    ConfigWriter().write(it, parent?.selectedItem.toString())
                }
            }
        }
    }

    override fun onResume() {
        val currentLevel = ChooseTopicsActivity.readLevelFromConfig(filesDir, resources)
        if(currentLevel != null) {
            val levels = resources.getStringArray(R.array.levels)
            val index = levels.indexOf(currentLevel)
            level_list.setSelection(index)
        }
        super.onResume()
    }
}
