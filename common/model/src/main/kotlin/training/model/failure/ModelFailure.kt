package training.model.failure

private const val DEFAULT_FAILURE_STRING_RESOURCE = "empty failure message"

sealed class Failure(var msg: String = DEFAULT_FAILURE_STRING_RESOURCE) {
    data object NoConnection : Failure(msg = ErrorMessage.ERROR_NO_CONNECTION)
    class InputParamsError(msg: String) : Failure(msg = msg)
    class RequestError(msg: String) : Failure(msg = msg)
    class ServerError(msg: String) : Failure(msg = msg)
    data object NoData : Failure(msg = ErrorMessage.ERROR_NO_DATA)
    data object Unknown : Failure(msg = ErrorMessage.ERROR_UNKNOWN)
    class Error(msg: String) : Failure(msg = msg)
}

/**
 * This object gathers all error messages available throughout the app
 */
object ErrorMessage {
    const val ERROR_NO_CONNECTION = "No Connection"
    const val ERROR_PARAMS_CANNOT_BE_EMPTY = "Params cannot be empty"
    const val ERROR_PARAMS_BOTH_EMAIL_PASSWORD_REQUIRED = "Both e-mail and password are required"
    const val ERROR_BAD_REQUEST = "Bad Request"
    const val ERROR_LOGIN_REQUEST = "Login: wrong e-mail or password"
    const val ERROR_LOGIN_RESPONSE = "Login Request Error"
    const val ERROR_REGISTER_REQUEST = "Register Request Error"
    const val ERROR_REGISTER_REQUEST_DUPLICATED = "Register: e-mail already registered"
    const val ERROR_REGISTER_REQUEST_PASSWORD = "Register: a 6-digits password is required"
    const val ERROR_SOCKET_TIMEOUT_EXCEPTION = "Socket Timeout"
    const val ERROR_NO_DATA = "No Data"
    const val ERROR_SERVER = "Server Error"
    const val ERROR_UNKNOWN = "Unknown Error"
}