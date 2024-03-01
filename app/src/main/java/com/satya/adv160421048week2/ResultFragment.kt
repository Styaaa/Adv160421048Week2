package com.satya.adv160421048week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.satya.adv160421048week2.GameFragmentDirections.Companion.actionResultFragment
import com.satya.adv160421048week2.databinding.FragmentResultBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null){
            val score = ResultFragmentArgs.fromBundle(requireArguments()).point
            binding.txtScore.text = "Your score is $score"
        }

        binding.btnBack.setOnClickListener {
            val action = ResultFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}