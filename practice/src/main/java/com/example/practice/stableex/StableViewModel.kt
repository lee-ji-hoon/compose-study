package com.example.practice.stableex

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class StableViewModel : ViewModel() {

    private val _value = MutableStateFlow(0)
    val value = _value.asStateFlow()

    fun plusValue() {
        _value.value = _value.value + 1
    }
}