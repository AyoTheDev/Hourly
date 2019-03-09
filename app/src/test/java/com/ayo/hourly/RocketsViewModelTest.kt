package com.ayo.hourly


class RocketsViewModelTest {

//    private lateinit var underTest: RocketsViewModel
//
//    @Mock
//    private lateinit var repository: RocketsRepository
//    @Mock
//    private lateinit var prefs: SharedPrefs
//    @Mock
//    private lateinit var eventObserver: Observer<RocketsViewModel.UiEvent>
//    @Mock
//    lateinit var lifecycleOwner: LifecycleOwner
//
//    @get:Rule
//    var rule: TestRule = InstantTaskExecutorRule()
//
//    lateinit var lifecycle : LifecycleRegistry
//
//
//    @Before
//    fun setUp() {
//        MockitoAnnotations.initMocks(this)
//        lifecycle = LifecycleRegistry(lifecycleOwner)
//        underTest = RocketsViewModel()
//        underTest.initiate(repository, prefs, TestContextProvider())
//        `when`(lifecycleOwner.lifecycle).thenReturn(lifecycle)
//        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
//        underTest.event.observeForever(eventObserver)
//    }
//
//    @After
//    fun finish() {
//        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
//    }
//
//    @Test
//    fun rocket_list_data_state() = runBlocking {
//
//        //GIVEN
//
//        //WHEN
//        underTest.loadRocketList()
//
//        //THEN
//        Assert.assertTrue(
//                underTest.event.value ==
//                        RocketsViewModel.UiEvent.RocketList(false, repository.getAll(), null)
//        )
//    }

//    @Test
//    fun rocket_list_loading_state() = runBlocking {
//        //GIVEN
//
//        //WHEN
//        underTest.loadRocketList()
//
//        //THEN
//        Assert.assertTrue(
//                underTest.event.value ==
//                        RocketsViewModel.UiEvent.RocketList(true, null, null)
//        )
//    }
//
//    @Test
//    fun rocket_list_error_state() = runBlocking {
//
//    }
//
//
//    @Test
//    fun load_rocket_list() {
//        //GIVEN
//        val forceRefresh = false
//        underTest.event.observeForever(eventObserver)
//
//        //WHEN
//        underTest.loadRocketList(forceRefresh)
//
//        //THEN
//        launch {
//            Mockito.verify(repository).getAll(forceRefresh)
//            val captor = ArgumentCaptor.forClass(RocketsViewModel.UiEvent::class.java)
//            Mockito.verify(eventObserver).onChanged(MockitoKotlinHelpers.capture(captor))
//            //Assert.assertTrue(captor.value is RocketsViewModel.UiEvent.Loading)
//
//        }
//
//
//    }
//
//    private inline fun <reified T> lambdaMock(): T = mock(T::class.java)

}
