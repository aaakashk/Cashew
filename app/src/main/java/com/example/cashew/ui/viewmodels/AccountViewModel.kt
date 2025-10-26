package com.example.cashew.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cashew.domain.model.Account
import com.example.cashew.repository.AccountRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val accountRepository: AccountRepository,
) : ViewModel() {
    val allAccounts: StateFlow<List<Account>> = accountRepository.allAccounts.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}