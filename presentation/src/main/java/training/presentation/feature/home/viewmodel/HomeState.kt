package training.presentation.feature.home.viewmodel

import training.domain.model.Monster

data class HomeState(
    val monstersList: List<Monster> = arrayListOf()
)