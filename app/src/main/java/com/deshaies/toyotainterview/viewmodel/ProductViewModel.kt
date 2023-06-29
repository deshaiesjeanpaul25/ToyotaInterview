package com.deshaies.toyotainterview.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deshaies.toyotainterview.data.Product
import com.deshaies.toyotainterview.network.ApiClient
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {

    private val apiService = ApiClient.create()

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    val _error: MutableLiveData<String> = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchProducts(){

        viewModelScope.launch{
            try{
                val response = apiService.getProducts()
                if(response.isSuccessful){
                    _products.value = response.body()?.products
                    Log.e("API Response List", products.value.toString())
                }

                else{
                    _error.value = response.errorBody().toString()
                }

            }

            catch (e: Exception){
                e.printStackTrace()
                _error.value  = e.message
            }
        }
    }
}