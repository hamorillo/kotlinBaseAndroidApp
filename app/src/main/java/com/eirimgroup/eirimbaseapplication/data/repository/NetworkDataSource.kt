package com.eirimgroup.eirimbaseapplication.data.repository

import com.eirimgroup.eirimbaseapplication.domain.model.DomainError
import com.eirimgroup.eirimbaseapplication.domain.model.UnknownDomainError
import org.funktionale.either.Either
import retrofit2.Response

class NetworkDataSource(private val dataApiClient: DataApiClient): GenericDataSource{

  companion object {
    val RESPONSE_OK = 200
  }

  override fun getAll(): Either<DomainError, String> =
    try{
      mapResponse(dataApiClient.getAll()){it?:""}
    }catch (exception:Exception){
      Either.left(mapException(exception))
    }

  private fun <T, R> mapResponse(
          response: Response<T>, mapper: (T?) -> R):
          Either<DomainError, R> =
          when (response.code()) {
            RESPONSE_OK -> Either.right(mapper(response.body()))
            else -> Either.left(UnknownDomainError())
          }

  private fun mapException(exception: Exception): DomainError =
          UnknownDomainError()
//          when {
//            exception is MarvelAuthApiException -> AuthDomainError()
//            exception.cause is ConnectException -> NotInternetDomainError()
//            else -> UnknownDomainError()
//          }
}