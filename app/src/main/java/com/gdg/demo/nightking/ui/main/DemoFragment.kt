package com.gdg.demo.nightking.ui.main


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.gdg.demo.nightking.R
import com.gdg.demo.nightking.data.dummyData
import kotlinx.android.synthetic.main.fragment_demo.view.*

/**
 * A simple [Fragment] subclass.
 *
 */
class DemoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_demo, container, false)
        view.demo_recycler_view.layoutManager = LinearLayoutManager(context)
        val demoAdapter = DemoAdapter(context!!)
        demoAdapter.setDemos(dummyData())
        view.demo_recycler_view.adapter = demoAdapter
        view.demo_recycler_view.setHasFixedSize(true)
        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_share) {
            Toast.makeText(context, context?.getString(R.string.random_toast_message), Toast.LENGTH_LONG).show()
            return true
        }
        return NavigationUI
            .onNavDestinationSelected(item, view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }


}
