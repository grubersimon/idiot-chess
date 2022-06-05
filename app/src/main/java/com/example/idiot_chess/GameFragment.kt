package com.example.idiot_chess

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.findNavController

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_game, container, false)
        var currentPlayer = 0
        var sumMoves = 0

        val field0_0 = view.findViewById<Button>(R.id.field0_0) as ImageView
        val field0_1 = view.findViewById<Button>(R.id.field0_1) as ImageView
        val field0_2 = view.findViewById<Button>(R.id.field0_2) as ImageView
        val field1_0 = view.findViewById<Button>(R.id.field1_0) as ImageView
        val field1_1 = view.findViewById<Button>(R.id.field1_1) as ImageView
        val field1_2 = view.findViewById<Button>(R.id.field1_2) as ImageView
        val field2_0 = view.findViewById<Button>(R.id.field2_0) as ImageView
        val field2_1 = view.findViewById<Button>(R.id.field2_1) as ImageView
        val field2_2 = view.findViewById<Button>(R.id.field2_2) as ImageView
        val curPlayer = view.findViewById<Button>(R.id.imgCurrentPlayer) as ImageView


        fun whoIsWinner(x: String)
        {
            

        }


        fun game(x: ImageView)
        {

            if(currentPlayer == 0  && x.getTag() == "empty")
            {
                x.setImageResource(R.drawable.x_field)
                curPlayer.setImageResource(R.drawable.o_field)
                currentPlayer = 1
                sumMoves = sumMoves + 1
                x.setTag("set")

            }
            else if(x.getTag() == "empty")
            {
                x.setImageResource(R.drawable.o_field)
                curPlayer.setImageResource(R.drawable.x_field)
                currentPlayer = 0
                sumMoves = sumMoves + 1
                x.setTag("set")
            }

            if(sumMoves == 9)
            {
                view.findNavController().navigate(R.id.action_gameToResultFragment)
            }
        }

        field0_0.setOnClickListener {
            game(field0_0)
        }

        field0_1.setOnClickListener {
            game(field0_1)
        }

        field0_2.setOnClickListener {
            game(field0_2)
        }

        field1_0.setOnClickListener {
            game(field1_0)
        }

        field1_1.setOnClickListener {
            game(field1_1)
        }

        field1_2.setOnClickListener {
            game(field1_2)
        }

        field2_0.setOnClickListener {
            game(field2_0)
        }

        field2_1.setOnClickListener {
            game(field2_1)
        }

        field2_2.setOnClickListener {
            game(field2_2)
        }

        return view
    }
}