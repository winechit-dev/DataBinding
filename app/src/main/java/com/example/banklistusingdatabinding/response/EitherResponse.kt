package com.example.banklistusingdatabinding.response

import com.example.banklistusingdatabinding.Status


data class Either<out T>(val status: Status, val data : T?, val errorMsg: String?){
    companion object {
        fun <T> success(data : T?) : Either<T> {
            return Either(
                Status.SUCCESS,
                data,
                null
            )
        }
        fun <T> error(errorMsg : String?) : Either<T> {
            return Either(
                Status.ERROR,
                null,
                errorMsg
            )
        }
    }
}