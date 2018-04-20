package cn.qssq666.progressbardemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

        horizontalprogr.setProgress(progress)
        horizontalprogr1.setProgress(progress)

        btn_current_progress.setText("当前操作进度:" + progress + "%")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progress_adject.setOnSeekBarChangeListener(this)


//        progress_adject.setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener()->{
//        }
//        }}})
    }
}
