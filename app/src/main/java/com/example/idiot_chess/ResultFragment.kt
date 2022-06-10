package com.example.idiot_chess

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController


class ResultFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_result, container, false)
        val startBtn = view.findViewById<Button>(R.id.btnRestartGame)

        val winnerInput = ResultFragmentArgs.fromBundle(requireArguments()).winnerInput

        val textView: TextView = view.findViewById(R.id.winnerText) as TextView
            if (winnerInput == 0)
            {
                textView.text = getString(R.string.undecided)
            }
            else if (winnerInput == 1)
            {
                textView.text = getString(R.string.x_won)
            }
            else
            {
                textView.text = getString(R.string.o_won)
            }

        startBtn.setOnClickListener {
            view.findNavController().navigate(R.id.action_resultToGameFragment)
        }
        return view
    }
}