package training.presentation.feature.details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import training.domain.bridge.DetailsBridge
import training.presentation.feature.home.viewmodel.HomeIntent
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val detailsBridge: DetailsBridge
) : ViewModel() {

    private val _detailsState = MutableStateFlow(DetailsState())
    val detailsState: StateFlow<DetailsState> = _detailsState.asStateFlow()

    init {
        viewModelScope.launch {
            detailsBridge.getMonster(0)
        }
    }

    fun onIntent(intent: HomeIntent) {

    }
}
