package codenevisha.ir.mvvmwithdagger.data.network

data class ApiError(
    val status: ApiStatus,
    val code: Int = -1,
    var message: String = "") {

    fun getErrorMessage(): String {

        if (message.isEmpty()) {

            message = when (status) {
                ApiStatus.EMPTY_RESPONSE -> "No data in response."
                ApiStatus.NO_CONNECTION -> "Error in connecting to the server."
                ApiStatus.BAD_RESPONSE -> "Error in getting response."
                ApiStatus.TIMEOUT -> " Time out  error."
                ApiStatus.NOT_DEFINED -> "An unexpected error happened!"
            }
        }

        return message
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