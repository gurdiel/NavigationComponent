package com.mpd.pmdm.navigationcomponent_distancia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.mpd.pmdm.navigationcomponent_distancia.databinding.FragmentResultBinding

const val PERRO = 1
const val GATO = 2

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding?=null
    private val binding get() = _binding!!
    private val args: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentResultBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvResultName.text = getString(R.string.result_name,args.nombre)
        binding.tvResultSex.text = getString(R.string.result_sex,args.sexo)

        binding.tvResultPet.text = if(args.mascota == PERRO){ getString(R.string.result_pet,"Perro")
        }else getString(R.string.result_pet,"Gato")

        binding.btnResultVolver.setOnClickListener {
            it.findNavController().popBackStack()
        }
        binding.btnResultTerminar.setOnClickListener {
            activity?.finish()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}