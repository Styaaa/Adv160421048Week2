package com.satya.adv160421048week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.satya.adv160421048week2.databinding.FragmentGameBinding
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private var point = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameBinding.inflate(inflater, container, false)

        return binding.root
//        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var randomValues = List(2) { Random.nextInt(0, 100) }
        binding.txtNumOne.text = randomValues.elementAt(0).toString()
        binding.txtNumTwo.text = randomValues.elementAt(1).toString()

        var realAnsw = randomValues.elementAt(0) + randomValues.elementAt(1)
        binding.btnSubmit.setOnClickListener {
            if(binding.txtAnwer.text.toString() != realAnsw.toString()){
                val action = GameFragmentDirections.actionResultFragment(point.toString())
                Navigation.findNavController(it).navigate(action)
            }else{
                randomValues = List(2) { kotlin.random.Random.nextInt(0, 100) }

                binding.txtNumOne.text = randomValues.elementAt(0).toString()
                binding.txtNumTwo.text = randomValues.elementAt(1).toString()

                realAnsw = randomValues.elementAt(0) + randomValues.elementAt(1)

                point += 1

                binding.txtAnwer.setText("")
            }
        }

        if(arguments != null){
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            binding.txtTurn.text = "$playerName's Turn"
        }
    }
}