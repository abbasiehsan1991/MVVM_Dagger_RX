package codenevisha.ir.mvvmwithdagger.data.network

import codenevisha.ir.mvvmwithdagger.R

data class ApiError(
    val status: ApiStatus,
    val code: Int = -1,
    var message: String=""
) {
    fun getApiErrorMessage(status: ApiStatus): Int {

        return when (status) {
            ApiStatus.EMPTY_RESPONSE -> R.string.api_no_data_response
            ApiStatus.NO_CONNECTION -> R.string.api_error_in_connecting_to_server
            ApiStatus.BAD_RESPONSE -> R.string.api_error_bad_response
            ApiStatus.TIMEOUT -> R.string.api_error_time_out
            ApiStatus. NOT_DEFINED -> R.string.api_error_not_defined
        }

    }

    enum class ApiStatus {
        /**
         * error in connecting to repository (Server or Database)
         */
        NO_CONNECTION,
        /**
         * error in getting response (Json Error, Server Error, etc)
         */
        BAD_RESPONSE,
        /**
         * Time out  error
         */
        TIMEOUT,
        /**
         * no data available in repository
         */
        EMPTY_RESPONSE,
        /**
         * an unexpected error
         */
        NOT_DEFINED;
    }

}