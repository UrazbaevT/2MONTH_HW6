package com.example.hw61

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import com.example.hw61.databinding.FragmentSongsBinding

class SongsFragment : Fragment() {

    private lateinit var binding: FragmentSongsBinding
    private lateinit var adapter: SongsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSongsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        adapter = SongsAdapter(uploadSongs(), this::onItemClick)
        binding.recyclerView.adapter = adapter
    }

    private fun uploadSongs() = listOf(
        Song("1", "DNCE", "Cake By the Ocean", "3:45"),
        Song("2", "French Montana ft. Swae Lee", "Unforgettable", "3:51"),
        Song("3", "The Weeknd, Kendrick Lamar", "Pray for Me", "3:29"),
        Song("4", "Doja Cat, The Weeknd", "You Right", "3:05"),
        Song("5", "Allen Block", "I Need a Dollar", "4:18"),
        Song("6", "Billie Eilish", "everything i wanted", "4:07"),
        Song("7", "The Cat Empire", "The Lost Song", "5:54"),
        Song("8", "Pompeya", "90", "4:33"),
        Song("9", "Lil Nas X, Jack Harlow", "INDUSTRY BABY", "3:33"),
        Song("10", "bbno$ & Rich Brian", "edamame", "2:16"),
    )

    private fun onItemClick(title: String) {
        requireActivity().supportFragmentManager.findFragmentById(R.id.image_fragment)?.view?.isGone = true

        val bundle = Bundle()
        bundle.putString("Name", title)

        val songFragment = SongFragment()
        songFragment.arguments = bundle

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.songs_fragment, songFragment).commit()
    }
}