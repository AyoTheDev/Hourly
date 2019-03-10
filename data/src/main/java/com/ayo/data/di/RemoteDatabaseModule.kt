package com.ayo.data.di

import com.ayo.data.network.UserNetworkRepo
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides

@Module
class RemoteDatabaseModule {

    @Provides
    fun provideFirestore(): FirebaseFirestore = FirebaseFirestore.getInstance()

    @Provides
    fun provideUserNetworkRepo(firestore: FirebaseFirestore): UserNetworkRepo = UserNetworkRepo(firestore)

}