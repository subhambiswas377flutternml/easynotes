package com.app.easynotes.presentation.auth.provider

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.easynotes.domain.auth.model.AuthModel
import com.app.easynotes.domain.auth.usecase.Login
import com.app.easynotes.domain.auth.usecase.Signup
import com.app.easynotes.presentation.auth.ui.AuthType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class AuthState{
    data object Initial: AuthState()
    data object Loading: AuthState()
    data class Loaded(val data: AuthModel): AuthState()
    data class Error(val ex: Exception?=null): AuthState()
}

sealed class UIEvents{
    data object SuccessAndNavigate: UIEvents()
}

fun AuthState.isLoading(): Boolean{
    return when(this){
        AuthState.Loading-> true
        else-> false
    }
}

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: Login,
    private val signupUseCase: Signup,
) : ViewModel() {
    private val _authState: MutableState<AuthState> = mutableStateOf<AuthState>(value = AuthState.Initial)
    val authState: State<AuthState> = _authState

    private val _uiEventAction: MutableSharedFlow<UIEvents> = MutableSharedFlow<UIEvents>()
    val uiEventsAction = _uiEventAction.asSharedFlow()

    private val exceptionHandler = CoroutineExceptionHandler{context, throwable->
        _authState.value = AuthState.Error()
    }

    fun signup(name: String, username: String, password: String) {
        viewModelScope.launch(exceptionHandler + Dispatchers.IO) {
            _authState.value = AuthState.Loading
            try{
                signupUseCase(name, username, password)
                login(username, password, afterSignup = true)
            }catch(ex: Exception){
                throw ex
            }
        }
    }

    fun login(username: String, password: String, afterSignup:Boolean = false){

        viewModelScope.launch(exceptionHandler + Dispatchers.IO){
            if(!afterSignup){
                _authState.value = AuthState.Loading
            }
            try{
                val user:AuthModel = loginUseCase(username, password)
                _authState.value = AuthState.Loaded(user)
                _uiEventAction.emit(UIEvents.SuccessAndNavigate)
            }catch(ex: Exception){
                throw ex
            }
        }
    }
}
