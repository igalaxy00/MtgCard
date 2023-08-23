package com.igalaxy.android.mtgcard.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import coil.load
import com.igalaxy.android.mtgcard.R
import kotlinx.coroutines.launch

class ChoiceFragment : Fragment() {
    private lateinit var generateCard: Button
    private lateinit var choiceViewModel: ChoiceViewModel
    private lateinit var cardPhoto: ImageView
    private lateinit var defaultPhoto: ImageView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_choice, container, false)
        generateCard = view.findViewById(R.id.generate_Card)
        cardPhoto = view.findViewById(R.id.card_photo)
        defaultPhoto = view.findViewById(R.id.default_photo)

        choiceViewModel = ViewModelProvider(this)[ChoiceViewModel::class.java]
        return view
    }


    override fun onStart() {
        super.onStart()

        lifecycleScope.launch() {
            choiceViewModel.stateFlow.collect {

                cardPhoto.load(it?.body()?.image_uris?.png)
                cardPhoto.scaleType = ImageView.ScaleType.FIT_END
                generateCard.isEnabled = true
            }
        }


        generateCard.setOnClickListener {
            choiceViewModel.getImage()
            generateCard.isEnabled = false
        }
    }

    companion object {
        fun newInstance(): ChoiceFragment {
            return ChoiceFragment()
        }
    }

}