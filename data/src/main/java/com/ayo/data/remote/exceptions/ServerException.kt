package com.ayo.data.remote.exceptions

class ServerException(code: Int, message: String) : NetworkException(code, message)