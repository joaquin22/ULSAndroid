package com.uls.practica_6.ui.content

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.uls.practica_6.model.User
import com.uls.practica_6.ui.componets.UserItem

@Composable
fun ListContent(
    users: List<User>,
    padding: PaddingValues,
    onDelete: (User) -> Unit = {},
    onFavorite: (User) -> Unit = {}
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding)
    ){
        items(users){
                user -> UserItem(user, onDelete, onFavorite)
        }
    }

}