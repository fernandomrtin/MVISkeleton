package training.domain

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import training.domain.contract.MonstersRepository
import training.domain.model.Monster
import training.domain.usecase.monsters.TDDUseCase

@ExperimentalCoroutinesApi
class TDDUseCaseUnitTest {

    @MockK
    private lateinit var monstersRepository: MonstersRepository

    private lateinit var useCase: TDDUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        useCase = TDDUseCase(monstersRepository = monstersRepository)
    }

    @Test
    fun `returns correct strength for valid monster`() = runTest {
        val monster = Monster(id = 1, name = "Orc", baseExperience = 3, imageUrl = "test")

        val result = useCase(monster)

        assertTrue(result.isRight())
        assertEquals(30, result.getOrNull())
    }
}