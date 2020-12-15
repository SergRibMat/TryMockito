package com.example.trymockito

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RepositoryTest {


    @Mock
    private lateinit var repositoryMock: Repository

     @Spy
     private lateinit var repositorySpy: Repository

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        repositoryMock = mock(Repository::class.java)
    }

    @Test
    fun tryMockAnnotation() {

        `when`(repositoryMock.returnString()).thenReturn("Mockito String")
        assertEquals("Mockito String", repositoryMock.returnString())
    }

    @Test
    fun trySpyAnnotation(){
        doReturn(repositorySpy.returnString()).`when`(repositorySpy).returnString()
        assertEquals("Repository String", repositorySpy.returnString())
    }

    @Test
    fun tryExecuteVoidMethod(){

        repositoryMock.voidMethod("Execute", "Method")

        verify(repositoryMock, times(1)).voidMethod("Execute", "Method")
    }

    @Test
    fun liveDataTest(){
        `when`(repositoryMock.myList.value).thenReturn(repositoryMock.liveDataList())
        assertEquals(repositoryMock.liveDataList(), repositoryMock.myList.value)
    }

    @After
    fun close(){
    }
}