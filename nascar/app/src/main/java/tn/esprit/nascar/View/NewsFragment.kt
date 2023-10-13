package tn.esprit.nascar.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.nascar.Controller.NewsViewAdapter
import tn.esprit.nascar.Model.News
import tn.esprit.nascar.R
import tn.esprit.nascar.databinding.FragmentNewsBinding

//TODO 4 Change this class to a fragment and use binding to inflate fragment_news.xml
private lateinit var binding : FragmentNewsBinding

class NewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(layoutInflater)

        var Data: List<News> = listOf(
            News(
                R.drawable.ic_news1,requireContext().getString(R.string.news1),requireContext().getString(
                    R.string.newsDesc1
                )),
            News(
                R.drawable.ic_news2,requireContext().getString(R.string.news2),requireContext().getString(
                    R.string.newsDesc2
                )),
            News(
                R.drawable.ic_news3,requireContext().getString(R.string.news3),requireContext().getString(
                    R.string.newsDesc3
                ))
        )

        val newview : RecyclerView = binding.NewsView

        val adapter: NewsViewAdapter = NewsViewAdapter(Data)

        newview.layoutManager = LinearLayoutManager(requireContext())
        newview.adapter = adapter

        return binding.root
    }
}