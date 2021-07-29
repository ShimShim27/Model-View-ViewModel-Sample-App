package mvvm.practice.app

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import mvvm.practice.app.adapters.WordedImageRecyclerAdapter
import mvvm.practice.app.models.WordedImageModel
import mvvm.practice.app.viewmodel.WordedImageListFragmentViewModel
import mvvm.practice.utilities.MainUtility

class WordedImageListFragment: Fragment(R.layout.worded_image_list_fragment) {
    private var m:MainUtility? = null
    private var viewModel:WordedImageListFragmentViewModel? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        m = MainUtility(requireContext())
        viewModel  = WordedImageListFragmentViewModel(
            requireArguments().getInt("fragmentNumber")
        )
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val scrollToBottom = { recyclerView.smoothScrollToPosition(viewModel!!.dataset.value!!.size) }

        recyclerView.adapter = WordedImageRecyclerAdapter(requireContext(),viewModel!!.dataset.value!!)

        viewModel!!.dataset.observe(viewLifecycleOwner,{
            recyclerView?.adapter?.notifyDataSetChanged()
        })


        view.findViewById<View>(R.id.addDataButton).setOnClickListener{
            showAddDataView{model->
                viewModel!!.addWordedImage(model)
                scrollToBottom()
            }
        }


        view.findViewById<View>(R.id.popDataButton).setOnClickListener{
            viewModel!!.popDataSet()
            scrollToBottom()
        }

    }





    private fun showAddDataView(onDataAdded:(wordedImage:WordedImageModel)->Unit){

        val view = LayoutInflater.from(requireContext()).inflate(R.layout.add_data_layout,null)
        val dialog = m!!.showViewInDialog(view)

        view.findViewById<View>(R.id.addDataButton).setOnClickListener{
            val url = view.findViewById<EditText>(R.id.urlInput).text.toString()
            val description = view.findViewById<EditText>(R.id.descriptionInput).text.toString()

            if (url.trim().isEmpty() || description.trim().isEmpty()) m!!.makeToast("Please fill out all fields")
            else{
                onDataAdded(WordedImageModel(description,url))
                dialog.cancel()
            }
        }

    }





}