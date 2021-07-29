package mvvm.practice.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mvvm.practice.app.models.WordedImageModel
import mvvm.practice.app.repositories.WordedImageListFragmentRepo

class WordedImageListFragmentViewModel(datasetNumber:Int):ViewModel() {
    val repo = WordedImageListFragmentRepo()
    val dataset:MutableLiveData<MutableList<WordedImageModel>> = MutableLiveData(repo.getDataSet(datasetNumber))

    fun addWordedImage(wordedImageModel: WordedImageModel){
        val newDataSet = dataset.value!!
        newDataSet.add(wordedImageModel)
        dataset.postValue(newDataSet)
    }


    fun popDataSet(){
        val newDataSet = dataset.value!!
        if (newDataSet.isNotEmpty()){
            newDataSet.removeAt(newDataSet.size - 1)
            dataset.postValue(newDataSet)
        }

    }



}