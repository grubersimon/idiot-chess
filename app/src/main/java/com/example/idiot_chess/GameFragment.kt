package com.example.idiot_chess

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.findNavController
import com.example.idiot_chess.databinding.ActivityMainBinding.inflate

class GameFragment : Fragment(R.layout.fragment_game) {

    override fun onCreateView
    (
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {

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

        fun shareRes(x: ImageView)
        {

            if(x.getTag() == "x")
            {
                val action = GameFragmentDirections
                    .actionGameToResultFragment(1)
                view.findNavController()
                    .navigate(action)
            }
            else if (x.getTag() == "o")
            {
                val action = GameFragmentDirections
                    .actionGameToResultFragment(2)
                view.findNavController()
                    .navigate(action)
            }
        }

        fun whoIsWinner (player: String)
        {
            if (field0_0.getTag() == player && field0_1.getTag() == player && field0_2.getTag() == player)         {shareRes(field0_0)}
            else if (field1_0.getTag() == player && field1_1.getTag() == player && field1_2.getTag() == player)    {shareRes(field0_1)}
            else if (field2_0.getTag() == player && field2_1.getTag() == player && field2_2.getTag() == player)    {shareRes(field2_0)}
            else if (field0_0.getTag() == player && field1_0.getTag() == player && field2_0.getTag() == player)    {shareRes(field0_0)}
            else if (field0_1.getTag() == player && field1_1.getTag() == player && field2_1.getTag() == player)    {shareRes(field1_1)}
            else if (field0_2.getTag() == player && field1_2.getTag() == player && field2_2.getTag() == player)    {shareRes(field0_2)}
            else if (field0_0.getTag() == player && field1_1.getTag() == player && field2_2.getTag() == player)    {shareRes(field0_0)}
            else if (field0_2.getTag() == player && field1_1.getTag() == player && field2_0.getTag() == player)    {shareRes(field0_2)}
        }

        fun game(x: ImageView)
        {
            if(currentPlayer == 0  && x.getTag() == "empty")
            {
                x.setImageResource(R.drawable.x_field)
                curPlayer.setImageResource(R.drawable.o_field)
                currentPlayer = 1
                sumMoves = sumMoves + 1
                x.setTag("x")
            }
            else if(x.getTag() == "empty")
            {
                x.setImageResource(R.drawable.o_field)
                curPlayer.setImageResource(R.drawable.x_field)
                currentPlayer = 0
                sumMoves = sumMoves + 1
                x.setTag("o")
            }

            if (sumMoves > 4)
            {
                whoIsWinner("x")
                whoIsWinner("o")
            }

            if(sumMoves == 9)
            {
                val action = GameFragmentDirections
                    .actionGameToResultFragment(0)
                view.findNavController()
                    .navigate(action)
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