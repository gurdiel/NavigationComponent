package com.mpd.pmdm.navigationcomponent_distancia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mpd.pmdm.navigationcomponent_distancia.databinding.FragmentHomeBinding
import com.mpd.pmdm.navigationcomponent_distancia.databinding.FragmentPetColorBinding

//Cuando usamos navigation component solo dejamos oncreateview
class PetColorFragment : Fragment() {
    private var _binding: FragmentPetColorBinding? = null
    private val binding get() = _binding!!

    //si solo se usa en un metodo pues no se declara aquí
    private val args: PetColorFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPetColorBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Recogiendo argumentos
        binding.tvPetTitle.text = getString(R.string.welcome_name_title,args.nombre)

        binding.btnVolver.setOnClickListener {
            findNavController().popBackStack()//como las pilas hay otras formas
        }

        binding.btnPetContinuar.setOnClickListener {
            val mascota = if(binding.rbtDog.isChecked) 1 else 2

            val action = PetColorFragmentDirections.actionPetColorFragmentToResultFragment(args.nombre,args.sexo,mascota)//ES EL NOMBRE DE LA CLASE NO DEL NAVGRAPH
            findNavController().navigate(action)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}