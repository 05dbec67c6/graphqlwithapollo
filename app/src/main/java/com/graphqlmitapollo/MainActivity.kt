package com.graphqlmitapollo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


//Es wäre toll, wenn du eine kleine App bauen könntest, die ein
//paar Daten von der öffentlichen Github GraphQL-API abruft (bspw. repo,
//topics, search):
//https://docs.github.com/en/graphql/overview/explorer
//Du musst keine UI bauen und der Code muss auch nicht super
//ausgereift sein. Es reicht, wenn man ein bisschen was im Log sieht.
//Es wäre gut, wenn du die Apollo Library nutzen könntest, da unser Produkt
//diese
//ebenfalls nutzt: https://github.com/apollographql/apollo-android


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}