package mvvm.practice.app.repositories


import mvvm.practice.app.models.WordedImageModel

class WordedImageListFragmentRepo {

    /***
     * The data here are just dummy
     */


    fun getDataSet(whichDataSet:Int):MutableList<WordedImageModel>{
        return when(whichDataSet){
            1 -> getFromSource1()
            2 -> getFromSource2()
            3 -> getFromSource3()
            4 -> getFromSource4()
            5 -> getFromSource5()
            else -> mutableListOf()
        }


    }


    private fun getFromSource1():MutableList<WordedImageModel>{
        val dataset:MutableList<WordedImageModel> = mutableListOf()
        dataset.add(WordedImageModel("list1","https://www.countryflags.io/be/flat/64.png"))
        dataset.add(WordedImageModel("list1","https://www.countryflags.io/be/flat/64.png"))
        dataset.add(WordedImageModel("list1","https://www.countryflags.io/be/flat/64.png"))
        dataset.add(WordedImageModel("list1","https://www.countryflags.io/be/flat/64.png"))
        dataset.add(WordedImageModel("list1","https://www.countryflags.io/be/flat/64.png"))

        return dataset
    }



    private fun getFromSource2():MutableList<WordedImageModel>{
        val dataset:MutableList<WordedImageModel> = mutableListOf()
        dataset.add(WordedImageModel("list2","https://www.countryflags.io/ad/flat/64.png"))
        dataset.add(WordedImageModel("list2","https://www.countryflags.io/ad/flat/64.png"))
        dataset.add(WordedImageModel("list2","https://www.countryflags.io/ad/flat/64.png"))
        dataset.add(WordedImageModel("list2","https://www.countryflags.io/ad/flat/64.png"))
        return dataset
    }


    private fun getFromSource3():MutableList<WordedImageModel>{
        val dataset:MutableList<WordedImageModel> = mutableListOf()
        dataset.add(WordedImageModel("list3","https://www.countryflags.io/as/flat/64.png"))
        dataset.add(WordedImageModel("list3","https://www.countryflags.io/as/flat/64.png"))
        dataset.add(WordedImageModel("list3","https://www.countryflags.io/as/flat/64.png"))
        dataset.add(WordedImageModel("list3","https://www.countryflags.io/as/flat/64.png"))
        dataset.add(WordedImageModel("list3","https://www.countryflags.io/as/flat/64.png"))
        dataset.add(WordedImageModel("list3","https://www.countryflags.io/as/flat/64.png"))
        return dataset
    }



    private fun getFromSource4():MutableList<WordedImageModel>{
        val dataset:MutableList<WordedImageModel> = mutableListOf()
        dataset.add(WordedImageModel("list4","https://www.countryflags.io/bh/flat/64.png"))
        dataset.add(WordedImageModel("list4","https://www.countryflags.io/bh/flat/64.png"))
        dataset.add(WordedImageModel("list4","https://www.countryflags.io/bh/flat/64.png"))
        dataset.add(WordedImageModel("list4","https://www.countryflags.io/bh/flat/64.png"))
        dataset.add(WordedImageModel("list4","https://www.countryflags.io/bh/flat/64.png"))
        dataset.add(WordedImageModel("list4","https://www.countryflags.io/bh/flat/64.png"))
        return dataset
    }


    private fun getFromSource5():MutableList<WordedImageModel>{
        val dataset:MutableList<WordedImageModel> = mutableListOf()
        dataset.add(WordedImageModel("list5","https://www.countryflags.io/br/flat/64.png"))
        dataset.add(WordedImageModel("list5","https://www.countryflags.io/br/flat/64.png"))
        dataset.add(WordedImageModel("list5","https://www.countryflags.io/br/flat/64.png"))
        dataset.add(WordedImageModel("list5","https://www.countryflags.io/br/flat/64.png"))
        dataset.add(WordedImageModel("list5","https://www.countryflags.io/br/flat/64.png"))
        return dataset
    }

}