package com.halac123b.bullseye

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.appcompat.app.AlertDialog
import com.halac123b.bullseye.databinding.ActivityMainBinding
import kotlin.math.abs
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var sliderValue = 0
    private  var targetValue = Random.nextInt(1, 100)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.hitMeButton.setOnClickListener {
            Log.i("Button click event", "You clicked the Hit Me button")
            showResult()
        }

        binding.targetTextView.text = targetValue.toString()

        binding.seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                sliderValue = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun pointsForCurrentRound(): Int{
        val maxScore = 100
        var difference = abs(targetValue - sliderValue)

        return maxScore - difference
    }

    private fun showResult(){
        val dialogueTitle = getString(R.string.result_dialogue_title)
        val dialogueMessage = getString(R.string.result_dialogue_message, sliderValue, pointsForCurrentRound())

        val builder = AlertDialog.Builder(this)
        builder.setTitle(dialogueTitle)
        builder.setMessage(dialogueMessage)
        builder.setPositiveButton(R.string.button_text){ dialog, _ ->
            dialog.dismiss()
            targetValue = Random.nextInt(1, 100)
            binding.targetTextView.text = targetValue.toString()
        }
        builder.create().show()
    }
}