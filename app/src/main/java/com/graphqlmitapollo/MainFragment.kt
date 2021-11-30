package com.graphqlmitapollo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import apolloClient
import com.apollographql.apollo.coroutines.await
import com.graphqlmitapollo.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenResumed {

            val repositorySearch =
                apolloClient.query(DreiRepositoriesDenElbenkoenigenHochImLichtQuery()).await()
            val discussionSearch =
                apolloClient.query(SiebenDenZwergenherrschernInIhrenHallenAusSteinQuery()).await()
            val eigenesRepo = apolloClient.query(EinerDemDunklenHerrscherAufDunklemThronQuery()).await()

            //Log.d("GraphQLAnswer", "Success: ${response.data}")

            // was fürs Auge, ist jetzt nur hingeschludert, das kann man alles mit Adaptern und Bindings
            // noch viel schöner machen
            binding.dreiRepositories.text = repositorySearch.data.toString()
            binding.textView.text = discussionSearch.data.toString()
            binding.textView5.text = eigenesRepo.data.toString()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

