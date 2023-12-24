package com.example.randomapps.ui.bookmark

<<<<<<< HEAD
=======
import android.content.Intent
>>>>>>> eff515b (Database Simple Add Note)
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
<<<<<<< HEAD
import com.example.randomapps.R
import com.example.randomapps.ui.ARG_PARAM1
import com.example.randomapps.ui.ARG_PARAM2
/**
 * A simple [Fragment] subclass.
 * Use the [BookmarkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
=======
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.randomapps.ViewModelFactory
import com.example.randomapps.databinding.FragmentBookmarkBinding
import com.example.randomapps.ui.ARG_PARAM1
import com.example.randomapps.ui.ARG_PARAM2
import com.example.randomapps.ui.insert.NoteAddUpdateActivity

>>>>>>> eff515b (Database Simple Add Note)
class BookmarkFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

<<<<<<< HEAD
=======
    private var _fragmentBookmarkBinding: FragmentBookmarkBinding? = null
    private val binding get() = _fragmentBookmarkBinding
    private lateinit var adapter: NoteAdapter

>>>>>>> eff515b (Database Simple Add Note)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
<<<<<<< HEAD
        return inflater.inflate(R.layout.fragment_bookmark, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BookmarkFragment.
         */
=======
        _fragmentBookmarkBinding = FragmentBookmarkBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bookmarkViewModel = obtainViewModel(requireActivity())
        bookmarkViewModel.getAllNotes().observe(viewLifecycleOwner) { noteList ->
            if (noteList != null) {
                adapter.setListNotes(noteList)
            }
        }

        binding?.fabAdd?.setOnClickListener {
            val intent = Intent(requireContext(), NoteAddUpdateActivity::class.java)
            startActivity(intent)
        }

        adapter = NoteAdapter()

        binding?.rvNotes?.layoutManager = LinearLayoutManager(requireContext())
        binding?.rvNotes?.setHasFixedSize(true)
        binding?.rvNotes?.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentBookmarkBinding = null
    }

    private fun obtainViewModel(activity: FragmentActivity): BookmarkViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(BookmarkViewModel::class.java)
    }

    companion object {
>>>>>>> eff515b (Database Simple Add Note)
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BookmarkFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> eff515b (Database Simple Add Note)
