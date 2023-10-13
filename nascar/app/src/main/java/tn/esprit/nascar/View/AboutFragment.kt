package tn.esprit.nascar.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tn.esprit.nascar.databinding.FragmentAboutBinding

//TODO 6 Change this class to a fragment and use binding to inflate fragment_about.xml
private lateinit var binding :FragmentAboutBinding

class AboutFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutBinding.inflate(layoutInflater)
        return binding.root
    }
}