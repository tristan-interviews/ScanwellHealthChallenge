package io.tristanlarsin.scanwellhealthchallenge.activities

import android.os.Bundle
import io.tristanlarsin.scanwellhealthchallenge.R
import io.tristanlarsin.scanwellhealthchallenge.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }
}