package com.mobile.simple_generator.viewmodels

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.simple_generator.R
import com.mobile.simple_generator.models.Card

open class CardViewModel: ViewModel() {

    private val _cards = MutableLiveData<List<Card>>()
    val cards: LiveData<List<Card>> = _cards

    init {
        _cards.value = List(5) { Card() }
    }

    fun setText(index: Int, text: String) {
        val currentCard = _cards.value.orEmpty().toMutableList()
        currentCard[index].text = text
        _cards.value = currentCard
    }

    fun setColor(index: Int, color: String) {
        val currentCard = _cards.value.orEmpty().toMutableList()
        currentCard[index].color = color
        _cards.value = currentCard
    }

    fun changeStatement(index: Int) {
        val currentCard = _cards.value.orEmpty().toMutableList()
        currentCard[index].statement = !currentCard[index].statement
        _cards.value = currentCard
    }

    fun getText(index: Int): String {
        return (_cards.value as MutableList<Card>)[index].text
    }

    fun getColor(index: Int): String {
        return (_cards.value as MutableList<Card>)[index].color
    }

    fun reset() {
        _cards.value = List(5) { Card() }
    }
}