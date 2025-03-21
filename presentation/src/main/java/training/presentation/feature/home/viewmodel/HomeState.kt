package training.presentation.feature.home.viewmodel

import training.model.monster.domain.Monster

data class HomeState(
    val monstersList: List<Monster> = arrayListOf()
)