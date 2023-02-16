package com.example.cleanarchitecture.presentation

interface MainEvent

class SaveEvent(val text : String) : MainEvent

class LoadEvent : MainEvent