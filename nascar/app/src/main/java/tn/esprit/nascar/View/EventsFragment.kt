package tn.esprit.nascar.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.nascar.Controller.EventViewAdapter
import tn.esprit.nascar.Controller.NewsViewAdapter
import tn.esprit.nascar.Model.Event
import tn.esprit.nascar.R
import tn.esprit.nascar.databinding.FragmentEventsBinding

//TODO 5 Change this class to a fragment and use binding to inflate fragment_events.xml
private lateinit var binding : FragmentEventsBinding

class EventsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentEventsBinding.inflate(layoutInflater)

        var Data: List<Event> = listOf(
            Event(R.drawable.ic_event1,requireContext().getString(R.string.event1),requireContext().getString(R.string.eventDate1)),
            Event(R.drawable.ic_event2,requireContext().getString(R.string.event2),requireContext().getString(R.string.eventDate2)),
            Event(R.drawable.ic_event3,requireContext().getString(R.string.event3),requireContext().getString(R.string.eventDate3)),
            Event(R.drawable.ic_event4,requireContext().getString(R.string.event4),requireContext().getString(R.string.eventDate4))
        )

        val eventView : RecyclerView = binding.eventRecycle

        val adapter: EventViewAdapter = EventViewAdapter(Data)

        eventView.layoutManager = LinearLayoutManager(requireContext())
        eventView.adapter = adapter
        return binding.root
    }
}