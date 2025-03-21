package training.presentation.feature.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import training.domain.bridge.HomeBridge
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeBridge: HomeBridge
) : ViewModel() {

    private val _homeState = MutableStateFlow(HomeState())
    val homeState: StateFlow<HomeState> = _homeState.asStateFlow()

    init {
        viewModelScope.launch {
            homeBridge.getMonstersList().fold({

            },{ monsters ->
                _homeState.update { homeState ->
                    homeState.copy(
                        monstersList = monsters
                    )
                }
            })
        }
    }

    fun onIntent(intent: HomeIntent) {

    }
}
