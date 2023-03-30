package com.mobile.simple_generator

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mobile.simple_generator.databinding.FragmentGeneratorBinding
import com.mobile.simple_generator.models.Card
import com.mobile.simple_generator.viewmodels.CardViewModel
import kotlin.random.Random


class GeneratorFragment : Fragment() {

    private lateinit var binding: FragmentGeneratorBinding
    private val viewModel: CardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGeneratorBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.generatorFragment = this@GeneratorFragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var cardColors: List<ConstraintLayout> = listOf(
            binding.firstCardColor,
            binding.secondCardColor,
            binding.thirdCardColor,
            binding.fourthCardColor,
            binding.fifthCardColor)

        var cardTexts: List<TextView> = listOf(
            binding.firstCardText,
            binding.secondCardText,
            binding.thirdCardText,
            binding.fourthCardText,
            binding.fifthCardText)

        var cardIcons: List<ImageView> = listOf(
            binding.firstCardIcon,
            binding.secondCardIcon,
            binding.thirdCardIcon,
            binding.fourthCardIcon,
            binding.fifthCardIcon)

//        generateColors()

        viewModel.cards.observe(viewLifecycleOwner) { cardList ->
            Log.i("Observer", "Observer")
            for (i in 0..4) {
                bind(cardList[i], cardColors[i], cardTexts[i], cardIcons[i])
            }
        }

        binding.apply {
            firstCard.setOnClickListener { changeStatement(0) }
            secondCard.setOnClickListener { changeStatement(1) }
            thirdCard.setOnClickListener { changeStatement(2) }
            fourthCard.setOnClickListener { changeStatement(3) }
            fifthCard.setOnClickListener { changeStatement(4) }

            generatorButton.setOnClickListener { generateColors() }
            resetButton.setOnClickListener { resetColors() }
        }
    }

    private fun changeStatement(index: Int) {
        Log.i("changeStatement", "$index")
        viewModel.changeStatement(index)
    }

    private fun generateColors() {
        Log.i("generateColors", "TEST")
        for (i in 0..4) {
            val color = generateColor()
            viewModel.setColor(i, color)
            viewModel.setText(i, color)
        }
    }

    private fun resetColors() {
        viewModel.reset()
    }

    private fun bind(card: Card, cardColor: ConstraintLayout, cardText: TextView, cardIcon: ImageView) {
        if (!card.statement) {
            cardColor.setBackgroundColor(Color.parseColor(card.color))
            cardText.text = card.text
            cardIcon.setImageResource(R.drawable.outline_lock_open_24)
        } else {
            cardIcon.setImageResource(R.drawable.outline_lock_24)
        }
    }

    private fun generateColor(): String {
        return Random.nextInt(0, 16_777_215)
            .toString(16)
            .padEnd(6, '0')
            .padStart(7, '#')
    }
}